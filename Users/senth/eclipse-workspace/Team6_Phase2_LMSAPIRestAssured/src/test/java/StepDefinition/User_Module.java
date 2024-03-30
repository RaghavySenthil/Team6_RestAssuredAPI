package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.Endpoint;
import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;

import Utilities.UserExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class User_Module {
	Response ValidDataResponse;
	String token;
	Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token", token);
	@Given("Admin creates POST request with all mandatory fields")
	public void admin_creates_post_request_with_all_mandatory_fields() throws InvalidFormatException, IOException {
		// Retrieve data from Excel file
		try {
				 List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
				
				// Iterate over each row of data
				 for (Map<String, String> row : getUserData){
					String userComments = row.get("userComments");
					String userEduPg = row.get("userEduPg");
					String userEduUg = row.get("userEduUg");
					String userFirstName = row.get("userFirstName");
					String userId = row.get("userId");
					String userLastName = row.get("userLastName");
					String userLinkedinUrl = row.get("userLinkedinUrl");
					String userLocation = row.get("userLocation");
					String loginStatus = row.get("loginStatus");
					String password = row.get("password");
					String roleIds = row.get("roleIds");
					String status = row.get("status");
					String userLoginEmail = row.get("userLoginEmail");
					String userMiddleName = row.get("userMiddleName");
					String userPhoneNumber = row.get("userPhoneNumber");
					long userPhoneNumber1 = Long.parseLong(userPhoneNumber);
					String roleId = row.get("roleId");
					String userRoleStatus = row.get("userRoleStatus");
					String userTimeZone = row.get("userTimeZone");
					String userVisaStatus = row.get("userVisaStatus");
						            
					
					  // Construct JSON body for the request
					String userInfoJson = "{" +
							"\"userComments\": \"" + userComments + "\"," +
							"\"userEduPg\": \"" + userEduPg + "\"," +
							"\"userEduUg\": \"" + userEduUg + "\"," +
							"\"userFirstName\": \"" + userFirstName + "\"," +
							//"\"userId\": \"" + userId + "\"," +
							"\"userLastName\": \"" + userLastName + "\"," +
							"\"userLinkedinUrl\": \"" + userLinkedinUrl + "\"," +
							"\"userLocation\": \"" + userLocation + "\"," +
							"\"userLogin\": {" +
							"\"loginStatus\": \"" + loginStatus + "\"," +
							"\"password\": \"" + password + "\"," +
							
							 "\"roleIds\": [" +
					            "\""+ roleIds +"\"" +
					        "]," +
					        "\"status\": \""+ status + "\"," +
					        "\"userLoginEmail\": \""+ userLoginEmail + "\"" +
					    "}," +
					    "\"userMiddleName\": \""+ userMiddleName +"\"," +
					   // "\"userPhoneNumber\": 1234587891," +
					   "\"userPhoneNumber\":\""+ userPhoneNumber1+"\"," +
					    "\"userRoleMaps\": [" +
					        "{" +
					            "\"roleId\": \""+ roleId +"\"," +
					            "\"userRoleStatus\": \""+ userRoleStatus +"\"" +
					        "}" +
					    "]," +
					    "\"userTimeZone\": \"" + userTimeZone + "\"," +
					    "\"userVisaStatus\": \""+ userVisaStatus + "\"" +
					"}";
					System.out.println(userInfoJson);
					ValidDataResponse = RestAssured
							.given().header("Authorization","Bearer "+retrievedToken)
				    		.spec(LMSReqspec.PostValidData()).body(userInfoJson)
				    		.when()
					    	.post();
					ValidDataResponse.then().log().all();
					ValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/Test_Data/UsermoduleSchema.json")));
					assertEquals(userComments,ValidDataResponse.jsonPath().getString("userComments") ); 
					assertEquals(userEduPg,ValidDataResponse.jsonPath().getString("userEduPg") );
					assertEquals(userEduUg,ValidDataResponse.jsonPath().getString("userEduUg") );
					assertEquals(userFirstName,ValidDataResponse.jsonPath().getString("userFirstName") );
					assertEquals(userLoginEmail,ValidDataResponse.jsonPath().getString("userLoginEmail") );
					//assertEquals(userId,ValidDataResponse.jsonPath().getString("userId") );
					assertEquals(userLastName,ValidDataResponse.jsonPath().getString("userLastName") );
					assertEquals(userLinkedinUrl,ValidDataResponse.jsonPath().getString("userLinkedinUrl") );
					assertEquals(userLocation,ValidDataResponse.jsonPath().getString("userLocation") );
					assertEquals(userMiddleName, ValidDataResponse.jsonPath().getString("userMiddleName"));
				   // assertEquals(userPhoneNumber, ValidDataResponse.jsonPath().getInt("userPhoneNumber"));
				    //assertEquals(roleId, ValidDataResponse.jsonPath().getString("userRoleMaps[0].roleId"));
				    //assertEquals(userRoleStatus, ValidDataResponse.jsonPath().getString("userRoleMaps[0].userRoleStatus"));
				    assertEquals(userTimeZone, ValidDataResponse.jsonPath().getString("userTimeZone"));
				    assertEquals(userVisaStatus, ValidDataResponse.jsonPath().getString("userVisaStatus"));
				
					
					//System.out.println(userInfoJson);
				
				
				
				}} catch (IOException | InvalidFormatException e) {
			        e.printStackTrace(); // Print the exception stack trace for debugging
			    }
				
			   
			}

			private ResponseAwareMatcher<Response> is(Object message) {
				// TODO Auto-generated method stub
				return null;
			}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
		ValidDataResponse.then().log().all();
		
	}

	@Then("Admin receives {int} Created Status with response body.")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		 ValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getClass()
	    		   .getClassLoader()
	    		   .getResourceAsStream("UsermoduleSchema.json")));
	}

	@Given("Admin creates POST request with all mandatory fields and additional fields")
	public void admin_creates_post_request_with_all_mandatory_fields_and_additional_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin receives {int} Bad Request Status with message and boolean success details.")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin creates POST request with missing mandatory fields in request body")
	public void admin_creates_post_request_with_missing_mandatory_fields_in_request_body() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin receives {int} Bad Request Status with error message.")
	public void admin_receives_bad_request_status_with_error_message(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin receives status {int} with Unauthorized message.")
	public void admin_receives_status_with_unauthorized_message(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
