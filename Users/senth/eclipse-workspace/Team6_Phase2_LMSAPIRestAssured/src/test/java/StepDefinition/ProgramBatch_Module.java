package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.Endpoint;
import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utilities.ConfigReader;
import Utilities.UserExcelReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ProgramBatch_Module {
	Response BatchmoduleValidDataResponse;
	Response Batchmoduleexistingdata;
	String token;
	Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token", token);
	List<Map<String, String>> getUserData;
	String message;
	String success;
	@Given("Admin creates POST Request  with valid data in request body")
	public void admin_creates_post_request_with_valid_data_in_request_body() throws InvalidFormatException, IOException {
		try {
			// List<Map<String, String>> getUserData=(UserExcelReader.getData(Endpoint.BatchmoduleExcelpath, "LMS_valid_data_Batchmodule"));
			List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Batchmodule_validData"));
			// Iterate over each row of data
			 for (Map<String, String> row : getUserData){
				String batchDescription = row.get("batchDescription");
				String batchName = row.get("batchName");
				String batchNoOfClasses = row.get("batchNoOfClasses");
				long batchNoOfClasses1 =Long.parseLong(batchNoOfClasses);
				String batchStatus = row.get("batchStatus");
				String programId = row.get("programId");
				long programId1 =Long.parseLong(programId);
				String programName = row.get("programName");
						            
				
				  // Construct JSON body for the request
				String userInfoJson1 = "{" +
						"\"batchDescription\": \"" + batchDescription+"\"," +
						"\"batchName\": \"" + batchName + "\"," +
						"\"batchNoOfClasses\": \"" + batchNoOfClasses1+"\"," +
						"\"batchStatus\": \"" + batchStatus + "\"," +
						"\"programId\": \"" + programId1+"\"," +
						"\"programName\": \"" + programName+"\"" +
						"}";
				System.out.println(userInfoJson1);
				BatchmoduleValidDataResponse = RestAssured
						.given().header("Authorization","Bearer "+retrievedToken)
			    		.spec(LMSReqspec.BatchModulePostValidData()).body(userInfoJson1)
			    		.when()
				    	.post();
				BatchmoduleValidDataResponse.then().log().all();
				BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
				assertEquals(batchDescription,BatchmoduleValidDataResponse.jsonPath().getString("batchDescription") ); 
				assertEquals(batchName,BatchmoduleValidDataResponse.jsonPath().getString("batchName") );
				assertEquals(batchNoOfClasses,BatchmoduleValidDataResponse.jsonPath().getString("batchNoOfClasses") );
				assertEquals(batchStatus,BatchmoduleValidDataResponse.jsonPath().getString("batchStatus") );
				assertEquals(programId,BatchmoduleValidDataResponse.jsonPath().getString("programId") );
				assertEquals(programName,BatchmoduleValidDataResponse.jsonPath().getString("programName") );
				
			
				
				System.out.println(userInfoJson1);
			
			
			 }
			 
			 } catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }
			
		   
		}
	private String getValue(Map<String, String> row, String key) {
	    String value = row.get(key);
	    return value != null ? value : "";
	}

		private ResponseAwareMatcher<Response> is(Object message) {
			// TODO Auto-generated method stub
			return null;
		}
		@When("Admin sends HTTPS Request with endpoint for batchmodule")
		public void admin_sends_https_request_with_endpoint_for_batchmodule() {
			BatchmoduleValidDataResponse.then().log().all();
		}

		@Then("Admin receives {int} Created Status with response body for batchmodule.")
		public void admin_receives_created_status_with_response_body_for_batchmodule(Integer int1) {
			/*BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getClass()
		    		   .getClassLoader()
		    		   .getResourceAsStream("BatchmoduleSchema.json")));*/
			
			 BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
			
		}	

	@Given("Admin creates POST Request  with existing value in request body")
	public void admin_creates_post_request_with_existing_value_in_request_body() {
		try {
			// List<Map<String, String>> getUserData=(UserExcelReader.getData(Endpoint.BatchmoduleExcelpath, "LMS_valid_data_Batchmodule"));
			List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Batchmodule_invaliddata"));
			// Iterate over each row of data
			
			 for (Map<String, String> row : getUserData){
				String batchDescription = row.get("batchDescription");
				String batchName = row.get("batchName");
				String batchNoOfClasses = row.get("batchNoOfClasses");
				long batchNoOfClasses1 =Long.parseLong(batchNoOfClasses);
				String batchStatus = row.get("batchStatus");
				String programId = row.get("programId");
				long programId1 =Long.parseLong(programId);
				String programName = row.get("programName");
				 message =row.get("message");
				 System.out.println(message);
			    success =row.get("success");
						            
				
				  // Construct JSON body for the request
				String userInfoJson1 = "{" +
						"\"batchDescription\": \"" + batchDescription+"\"," +
						"\"batchName\": \"" + batchName + "\"," +
						"\"batchNoOfClasses\": \"" + batchNoOfClasses1+"\"," +
						"\"batchStatus\": \"" + batchStatus + "\"," +
						"\"programId\": \"" + programId1+"\"," +
						"\"programName\": \"" + programName+"\"" +
						"}";
				System.out.println(userInfoJson1);
				BatchmoduleValidDataResponse = RestAssured
						.given().header("Authorization","Bearer "+retrievedToken)
			    		.spec(LMSReqspec.BatchModulePostValidData()).body(userInfoJson1)
			    		.when()
				    	.post();
				
				int statuscode = BatchmoduleValidDataResponse.getStatusCode();
				
				if (statuscode == 201) {
					
										
				BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
				assertEquals(batchDescription,BatchmoduleValidDataResponse.jsonPath().getString("batchDescription") ); 
				assertEquals(batchName,BatchmoduleValidDataResponse.jsonPath().getString("batchName") );
				assertEquals(batchNoOfClasses,BatchmoduleValidDataResponse.jsonPath().getString("batchNoOfClasses") );
				assertEquals(batchStatus,BatchmoduleValidDataResponse.jsonPath().getString("batchStatus") );
				assertEquals(programId,BatchmoduleValidDataResponse.jsonPath().getString("programId") );
				assertEquals(programName,BatchmoduleValidDataResponse.jsonPath().getString("programName") );
				}
				
				
			
				
				//System.out.println(userInfoJson1);
			
			
			 }
			 
			 } catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }
			
		   
		}
	
	
	@When("Admin sends HTTPS Request with endpoint witheixisting value")
	public void admin_sends_https_request_with_endpoint_witheixisting_value() {
		BatchmoduleValidDataResponse.then().log().all();
	}
	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
		/*BatchmoduleValidDataResponse.then().assertThat()
		.body("success", is(Boolean.parseBoolean("success")))
		.body("message", is(message)); // Use equalTo() matcher for comparison*/
		//.body("success", is(Boolean.parseBoolean("success"))); // Use equalTo() matcher for comparison
			assertEquals(message,BatchmoduleValidDataResponse.jsonPath().getString("message") );
		   // assertEquals(Boolean.parseBoolean("success"),BatchmoduleValidDataResponse.jsonPath().getString("success") );
			
		}
	
	@Given("Admin creates POST Request  with invalid data in request body")
	public void admin_creates_post_request_with_invalid_data_in_request_body1() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin creates POST Request")
	public void admin_creates_post_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		BatchmoduleValidDataResponse.then().log().all();
	}

	@Then("Admin receives {int} not found  Status")
	public void admin_receives_not_found_status(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin creates POST Request with missing additional fields")
	public void admin_creates_post_request_with_missing_additional_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin creates POST Request with invalid data in request body")
	public void admin_creates_post_request_with_invalid_data_in_request_body() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin creates POST Request with inactive program id")
	public void admin_creates_post_request_with_inactive_program_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	
	
	
	
	
}
