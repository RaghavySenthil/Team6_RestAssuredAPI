package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import EndPoints.Endpoint;
import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;
import Utilities.UserExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import usermodule3_POJO.Json_PayLoad_PUT_UModule;

public class PUT_userrolestatus_USERMODULE {
	String reqBody;
	String token;
	Response response;
	String retrievedToken;
	@Given("Admin creates PUT Request with valid data in request body")
	public void admin_creates_put_request_with_valid_data_in_request_body() {
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String userID = row.get("userID");
				String endpoint = Endpoint.PUT_USER_ROLE_STATUS;
				endpoint = endpoint.replace("{userID}", userID);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleStatus(row);
				System.out.println("request body of post user with userid : " + reqBody);
				System.out.println("updated endpoint of post user with userid : " + endpoint);

				Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
				System.out.println("retreived token ");
				response = RestAssured.given().spec(LMSReqspec.update_UserRoleStatus()).body(reqBody).when().put(endpoint);
				response.then().log().all();
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}
	

	@When("Admin sends HTTPS Request with endpoint PUT ROLESTATUS")
	public void admin_sends_https_request_with_endpoint_put_rolestatus() {
		response.then().log().all().extract().response();
	}
	@Then("Admin receives  status code and Not Found Status for usermodule update ROLESTATUS")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details() {

		int statuscode = response.getStatusCode();
		System.out.println("Statuscode:" + statuscode);

		response.then().assertThat().statusCode(400).extract().response().asString();

	}
	 @Given ("Admin creates PUT Request with valid data in request body with no authorization")
	public void create_put_user_request_noAuth() {
		 String endpoint = Endpoint.PUT_USER_ROLE_STATUS;
			List<Map<String, String>> getUserData;
			try {
				getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

				for (Map<String, String> row : getUserData) {
					String userID = row.get("userID");
					endpoint = endpoint.replace("{userID}", userID);
					reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleStatus(row);
					System.out.println("request body of post user with userid : " + reqBody);
					System.out.println("updated endpoint of post user with userid : " + endpoint);

					Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
					System.out.println("retreived token ");
					response = RestAssured.given().spec(LMSReqspec.update_UserRoleStatus()).body(reqBody).when().put(endpoint);
					response.then().log().all();
				}
			} catch (IOException | InvalidFormatException e) {
				e.printStackTrace(); // Print the exception stack trace for debugging
			}

	}
	 @Then("Admin receives statuscode with response body for usermodule update userrolestatus.")
		public void admin_receives_ok_status_with_response_body() {
			String responseBody = response.getBody().asString();
			String message = response.jsonPath().getString("message");
			String success = response.jsonPath().getString("success");
			int statuscode = response.getStatusCode();
			System.out.println("Statuscode:" + statuscode);
			if (statuscode == 200) {
				response.then().assertThat().statusCode(200).extract().response().asString();
				Assert.assertTrue(message.contains("Updated for User"));
			} else if (statuscode == 401) {
				response.then().assertThat().statusCode(401).extract().response().asString();
			} else if (statuscode == 400) {
				response.then().assertThat().statusCode(400).extract().response().asString();
				Assert.assertTrue(message.contains("already exists for user") || message.contains("User Role Info is mandatory"));
				Assert.assertTrue(success.contains("false"));
			} else if (statuscode == 404) {
				response.then().assertThat().statusCode(404).extract().response().asString();
				Assert.assertTrue(message.contains("Not Found"));
				Assert.assertTrue(success.contains("false"));
			}
	 }
	 @Then("Admin receives statuscode with Unauthorized message for usermodule for userrolestatus")
		public void admin_receives_status_with_unauthorized_message() {
			String responseBody = response.getBody().asString();
			String error = response.jsonPath().getString("error");

			int statuscode = response.getStatusCode();
			System.out.println("Statuscode:" + statuscode);
			if (statuscode == 401) {

				response.then().assertThat().statusCode(401).extract().response().asString();
				Assert.assertTrue(error.contains("Unauthorized"));
			} else {
				System.out.println("Error message: " + error);
			}
	 }

	@Given("Admin creates PUT Request with valid data in request body  for invalid endpoint")
	public void create_put_request_Invalid_endpoint() {
		Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token");
		 List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
			 System.out.println("read the input file");
		 for (Map<String, String> row : getUserData){
			 String endpoint=Endpoint.PUT_USER_ROLE_STATUS_INVALID_ENDPOINT;
				String userID = row.get("userID");
          System.out.println("endpoint is ;"+endpoint);
		 endpoint = endpoint.replace("{userID}",userID);
		 System.out.println("updated endpoint of post user with userid : "+endpoint);	
		 reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleStatus(row);
		 
		    response = RestAssured
	        		.given().header("Authorization","Bearer "+retrievedToken)
	        		.spec(LMSReqspec.update_UserRoleStatus()).body(reqBody)
	        		.when().
	        		put(endpoint);
		    response.then().log().all();
	}
		 }
		 catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }
	}
	@When("Admin sends HTTPS Request with invalid endpoint ROLESTATUS")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response.then().log().all().extract().response();
	}
	
}
