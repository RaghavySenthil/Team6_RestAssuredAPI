package StepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;


import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;
import TestRunner.LMSTestRunner;
//import Utilities.UserExcelReader;
import Utilities.ConfigReader;
import Utilities.LoggerLoad;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserLoginController {
	
	ConfigReader ConfigReaderobj;
	Properties prop;
	Response loginresponse;
	String reqBody;
	String token;
	
	//ConfigReader for reading UserID and password from config file	
		public  UserLoginController() throws IOException {
			ConfigReaderobj = new ConfigReader();
			        prop = ConfigReaderobj.init_prop();
			}
		
	
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() throws Exception, IOException {
		String Email = prop.getProperty("UserLoginEmail");
		String Password = prop.getProperty("Password");
		reqBody = "{\n"
		+ " \"password\": \""+ Password +"\",\n"
		+ " \"userLoginEmailId\": \""+Email+"\"\n"
		+ "}";
		
		loginresponse = RestAssured
        		.given()
        		.spec(LMSReqspec.UserLogin()).body(reqBody)
        		.when().post();
		
	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {
		loginresponse.then().log().all().extract().response();
		 token = loginresponse.jsonPath().getString("token");
	      Object gettoken = LMSTestRunner.scenarioContext.setContext("Token", token); 
	        System.out.println(gettoken);
	        loginresponse.then().log().all().extract().response();
	        //LoggerLoad.info("the response of the rquest is " + loginresponse);
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
		loginresponse.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=loginresponse.getStatusCode();
		System.out.println("Statuscode:" +statuscode);
			}

	
}