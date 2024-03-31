package usermodule3;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Properties;

import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;
import Utilities.LoggerLoad;

import Utilities.ConfigReader;

public class Authentication {

	 private static String token;
	 ConfigReader ConfigReaderobj;
		static Properties prop;
		String reqBody;
	//ConfigReader for reading UserID and password from config file	
			public  Authentication() throws IOException {
				ConfigReaderobj = new ConfigReader();
				        prop = ConfigReaderobj.init_prop();
				}
			
	
	public  void loginAPI() {
		String Email = "numpyninja@gmail.com";
		String Password = "lmsHackathon@2024";
		reqBody = "{\n"
				+ " \"password\": \""+ Password +"\",\n"
				+ " \"userLoginEmailId\": \""+Email+"\"\n"
				+ "}";
		//RestAssured.baseURI="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/swagger-ui.html#/";
		Response response = RestAssured
        		.given()
        		.spec(LMSReqspec.UserLogin()).body(reqBody)
        		.when().post();
		
		System.out.println("loggedin");
		token=response.jsonPath().getString("token");
		  Object gettoken = LMSTestRunner.scenarioContext.setContext("Token", token); 
	       System.out.println(gettoken);
	       response.then().log().all().extract().response();
	        LoggerLoad.info("the response of the rquest is " + response);
		
	}
}
