package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import usermodule3.Authentication;
import usermodule3_POJO.Json_PayLoad_PUT_UModule;

import org.junit.Assert;

import EndPoints.Endpoint;
import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;
import Utilities.UserExcelReader;

public class PUT_userRoleId_USERMODULE {

	String reqBody;
	String token;
	Response response;
	String retrievedToken;

	@Given("Admin sets authorization to bearer token")
	public void admin_sets_authorization_to_bearer_token() {

		try {
			Authentication authentication = new Authentication();
			authentication.loginAPI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Given("Admin creates PUT Request with valid request body")
	public void admin_creates_put_request_with_valid_request_body() {

		Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String endpoint = Endpoint.PUT_USER_ROLEID;
				String userID = row.get("userID");
				System.out.println("endpoint is ;" + endpoint);
				endpoint = endpoint.replace("{userID}", userID);
				System.out.println("updated endpoint of post user with userid : " + endpoint);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleID(row);

				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.Update_UserRoleID()).body(reqBody).when().put(endpoint);
				response.then().log().all();
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}

	@When("Admin sends HTTPS Request with endpoint PUT ROLEID")
	public void admin_sends_https_request_with_endpoint() {

		response.then().log().all().extract().response();

	}

	@Then("Admin receives statuscode with response body for usermodule update userRoleid.")
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

	@Given("Admin creates PUT Request with request body and sets authorization to bearer token to No Auth")
	public void admin_creates_put_request_with_request_body_and_sets_authorization_to_bearer_token_to_no_auth() {
		
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String userID = row.get("userID");
				String endpoint = Endpoint.PUT_USER_ROLEID;
				endpoint = endpoint.replace("{userID}", userID);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleID(row);
				System.out.println("request body of post user with userid : " + reqBody);
				System.out.println("updated endpoint of post user with userid : " + endpoint);

				Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
				System.out.println("retreived token ");
				response = RestAssured.given().spec(LMSReqspec.Update_UserRoleID()).body(reqBody).when().put(endpoint);
				response.then().log().all();
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}

	}

	@Then("Admin receives statuscode with Unauthorized message for usermodule update userroleid")
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

	@Given("Admin creates PUT Request with request body for invalid endpoint")
	public void admin_creates_put_request_with_request_body() {
		String endpoint = Endpoint.PUT_USER_ROLEID_INVALID_ENDPOINT;
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String userID = row.get("userID");
				endpoint = endpoint.replace("{userID}", userID);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleID(row);
				System.out.println("request body of post user with userid : " + reqBody);
				System.out.println("updated endpoint of post user with userid : " + endpoint);

				Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
				System.out.println("retreived token ");
				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.Update_UserRoleID()).body(reqBody).when().put(endpoint);
				response.then().log().all();
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response.then().log().all().extract().response();
	}

	@Then("Admin receives  status code and Not Found Status for usermodule update userroleid")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details() {

		int statuscode = response.getStatusCode();
		System.out.println("Statuscode:" + statuscode);

		response.then().assertThat().statusCode(400).extract().response().asString();

	}

}
