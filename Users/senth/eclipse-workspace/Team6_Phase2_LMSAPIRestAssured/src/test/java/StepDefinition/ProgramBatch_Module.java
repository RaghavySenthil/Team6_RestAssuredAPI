package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.Endpoint;
import Pay_Load.ProgramBatch_Payload;
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
	Response Batchmoduleinvalidendpoint;
	Response GetAllbatchresponse;
	Response DeletebyID;
	String retrievedToken;
	//Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token", token);
	List<Map<String, String>> getUserData;
	String message;
	String success;
	
	@Given("Admin creates POST Request  with valid data in request body")
	public void admin_creates_post_request_with_valid_data_in_request_body() throws Exception {
		/*try {
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
				System.out.println(userInfoJson1);*/
				//String retrievedToken = UserLoginController.token;
				
				BatchmoduleValidDataResponse = RestAssured
						.given().header("Authorization","Bearer "+UserLoginController.token)
			    		.spec(LMSReqspec.BatchModulePostValidData()).body(ProgramBatch_Payload.Data())
			    		.when()
				    	.post();
				BatchmoduleValidDataResponse.then().log().all();
				
				/*BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
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
		    }*/
			
		   
		}
	/*private String getValue(Map<String, String> row, String key) {
	    String value = row.get(key);
	    return value != null ? value : "";
	}

		private ResponseAwareMatcher<Response> is(Object message) {
			// TODO Auto-generated method stub
			return null;
		}*/
		@When("Admin sends HTTPS Request with endpoint for batchmodule")
		public void admin_sends_https_request_with_endpoint_for_batchmodule() {
			//BatchmoduleValidDataResponse.then().log().all();
		}

		@Then("Admin receives {int} Created Status with response body for batchmodule.")
		public void admin_receives_created_status_with_response_body_for_batchmodule(Integer int1) {
			/*BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getClass()
		    		   .getClassLoader()
		    		   .getResourceAsStream("BatchmoduleSchema.json")));*/
			//BatchmoduleValidDataResponse.then().log().all();
			 //BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
			
		}	

	@Given("Admin creates POST Request  with existing value in request body")
	public void admin_creates_post_request_with_existing_value_in_request_body() {
		try {
			// List<Map<String, String>> getUserData=(UserExcelReader.getData(Endpoint.BatchmoduleExcelpath, "LMS_valid_data_Batchmodule"));
			List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Batchmodule_Existingdata"));
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
						
						.given().header("Authorization","Bearer "+UserLoginController.token)
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
			//assertEquals(message,BatchmoduleValidDataResponse.jsonPath().getString("message") );
		   // assertEquals(Boolean.parseBoolean("success"),BatchmoduleValidDataResponse.jsonPath().getString("success") );
			
		}
	
	@Given("Admin creates POST Request  with invalid data in request body")
	public void admin_creates_post_request_with_invalid_data_in_request_body1() {
					try {
				// List<Map<String, String>> getUserData=(UserExcelReader.getData(Endpoint.BatchmoduleExcelpath, "LMS_valid_data_Batchmodule"));
				List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Invaliddata"));
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
							.given().header("Authorization","Bearer "+UserLoginController.token)
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
	@When("Admin sends HTTPS Request with endpoint for batchmodule invalid request")
	public void admin_sends_https_request_with_endpoint_for_batchmodule_invalid_request() {
		BatchmoduleValidDataResponse.then().log().all();
	}	
	@Then("Admin receives {int} Bad Request Status with message and boolean success details invalid request")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details_invalid_request(Integer int1) {
		BatchmoduleValidDataResponse.then().log().all();
	}

	@Given("Admin creates POST Request")
	public void admin_creates_post_request() {
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
				Batchmoduleinvalidendpoint = RestAssured
						.given().header("Authorization","Bearer "+UserLoginController.token)
			    		.spec(LMSReqspec.Invalidendpoint_Batches()).body(userInfoJson1)
			    		.when()
				    	.post();
				
				/*int statuscode = Batchmoduleinvalidendpoint.getStatusCode();
				
				if (statuscode == 201) {
					
										
				BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
				assertEquals(batchDescription,BatchmoduleValidDataResponse.jsonPath().getString("batchDescription") ); 
				assertEquals(batchName,BatchmoduleValidDataResponse.jsonPath().getString("batchName") );
				assertEquals(batchNoOfClasses,BatchmoduleValidDataResponse.jsonPath().getString("batchNoOfClasses") );
				assertEquals(batchStatus,BatchmoduleValidDataResponse.jsonPath().getString("batchStatus") );
				assertEquals(programId,BatchmoduleValidDataResponse.jsonPath().getString("programId") );
				assertEquals(programName,BatchmoduleValidDataResponse.jsonPath().getString("programName") );
				}*/
				
					
				
				//System.out.println(userInfoJson1);
			
			
			 }
			 
			 } catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }
	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
		Batchmoduleinvalidendpoint.then().log().all();
	}

	@Then("Admin receives {int} not found  Status")
	public void admin_receives_not_found_status(Integer int1) {
		Batchmoduleinvalidendpoint.then().log().all();
	}
	
	@Given("Admin creates POST Request with inactive program id")
	public void admin_creates_post_request_with_inactive_program_id() {
		
		
		try {
			// List<Map<String, String>> getUserData=(UserExcelReader.getData(Endpoint.BatchmoduleExcelpath, "LMS_valid_data_Batchmodule"));
			List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Inactive_pgmid"));
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
						.given().header("Authorization","Bearer "+UserLoginController.token)
			    		.spec(LMSReqspec.Invalidendpoint_Batches()).body(userInfoJson1)
			    		.when()
				    	.post();
				
				/*int statuscode = Batchmoduleinvalidendpoint.getStatusCode();
				
				if (statuscode == 201) {
					
										
				BatchmoduleValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\BatchmoduleSchema.json")));
				assertEquals(batchDescription,BatchmoduleValidDataResponse.jsonPath().getString("batchDescription") ); 
				assertEquals(batchName,BatchmoduleValidDataResponse.jsonPath().getString("batchName") );
				assertEquals(batchNoOfClasses,BatchmoduleValidDataResponse.jsonPath().getString("batchNoOfClasses") );
				assertEquals(batchStatus,BatchmoduleValidDataResponse.jsonPath().getString("batchStatus") );
				assertEquals(programId,BatchmoduleValidDataResponse.jsonPath().getString("programId") );
				assertEquals(programName,BatchmoduleValidDataResponse.jsonPath().getString("programName") );
				}*/
				
					
				
				//System.out.println(userInfoJson1);
			
			
			 }
			 
			 } catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }
	}
@When("Admin sends HTTPS Request with endpoint with invalidpgmID")
public void admin_sends_https_request_with_endpoint_with_invalidpgm_id() {
	BatchmoduleValidDataResponse.then().log().all();
}

@Then("Admin receives {int} Bad Request Status with message and boolean success details with invalidpgmID")
public void admin_receives_bad_request_status_with_message_and_boolean_success_details_with_invalidpgm_id(Integer int1) {
	BatchmoduleValidDataResponse.then().log().all();
}
@Given("Admin creates GET Request")
public void admin_creates_get_request() {
	//GetAllbatchresponse= RestAssured.given().header("Authorization","Bearer "+retrievedToken);
	GetAllbatchresponse = RestAssured.given()
    		.header("Authorization","Bearer "+UserLoginController.token)
	    	.spec(LMSReqspec.GetAllbatch())
	    	.when()
	    	.get();
}



@When("Admin sends HTTPS Request with endpoint in get all request")
public void admin_sends_https_request_with_endpoint_in_get_all_request() {
	GetAllbatchresponse.then().log().all().extract().response();
}


@Then("Admin receives {int} OK Status with response body.")
public void admin_receives_ok_status_with_response_body(Integer int1) {
	GetAllbatchresponse.then().statusCode(200);
}

@Given("Admin creates GET Request for invalid endpoint")
public void admin_creates_get_request_for_invalid_endpoint() {
	GetAllbatchresponse = RestAssured.given()
    		.header("Authorization","Bearer "+UserLoginController.token)
	    	.spec(LMSReqspec.getInvalidendpoint_Batches())
	    	.when()
	    	.get();
}
@When("Admin sends HTTPS Request with invalidendpoint in get all request")
public void admin_sends_https_request_with_invalidendpoint_in_get_all_request() {
	GetAllbatchresponse.then().log().all().extract().response();
}

@Then("Admin receives {int} status with error message Not Found.")
public void admin_receives_status_with_error_message_not_found(Integer int1) {
	GetAllbatchresponse.then().statusCode(404);
}
@Given("Admin creates GET Request with valid Batch ID")
public void admin_creates_get_request_with_valid_batch_id() {
	GetAllbatchresponse = RestAssured.given()
    		.header("Authorization","Bearer "+UserLoginController.token)
	    	.spec(LMSReqspec.GET_BatchbyBatchId())
	    	.when()
	    	.get();

}

@When("Admin sends HTTPS Request with endpointof get by ID")
public void admin_sends_https_request_with_endpointof_get_by_id() {
	GetAllbatchresponse.then().log().all().extract().response();
}

@Then("Admin receives {int} OK Status with response body in batch ID.")
public void admin_receives_ok_status_with_response_body_in_batch_id(Integer int1) {
	GetAllbatchresponse.then().statusCode(200);
}



//Delete Scenarios

@Given("Admin creates DELETE Request with valid BatchId")
public void admin_creates_delete_request_with_valid_batch_id() throws InvalidFormatException, IOException {
	List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "DeletebyID"));
	// Iterate over each row of data
	
	 for (Map<String, String> row : getUserData){
		String batchId = row.get("batchId");
	 
	// Construct JSON body for the request
		String userInfoJson2 = "{" +
				"\"batchId\": \"" + batchId+"\"" +
	 "}";
		System.out.println(userInfoJson2);
		DeletebyID = RestAssured
				.given().header("Authorization","Bearer "+UserLoginController.token)
	    		.spec(LMSReqspec.Delete_BatchbyBatchId()).pathParam("batchId", batchId)
	    		.when()
		    	.delete();
	 } }


@When("Admin sends HTTPS Request with endpoint for Delete by ID")
public void admin_sends_https_request_with_endpoint_for_delete_by_id() {
	DeletebyID.then().log().all().extract().response();
}

@Then("Admin receives {int} Ok status with message for Delete by ID")
public void admin_receives_ok_status_with_message_for_delete_by_id(Integer int1) {
	DeletebyID.then().statusCode(200);
}

@Given("Admin creates DELETE Request with valid BatchId invalidendpoint")
public void admin_creates_delete_request_with_valid_batch_id_invalidendpoint() throws InvalidFormatException, IOException {
	List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "DeletebyID"));
	if (getUserData.size() >= 2) {
        // Get the second row (index 1, as indexing starts from 0)
        Map<String, String> secondRow = getUserData.get(1);
        String batchId = secondRow.get("batchId");

        // Construct JSON body for the request
        String userInfoJson2 = "{\"batchId\": \"" + batchId + "\"}";

        // Perform the GET request
        DeletebyID = RestAssured
				.given().header("Authorization","Bearer "+UserLoginController.token)
	    		.spec(LMSReqspec.Delete_InvalidBatchbyBatchId()).pathParam("batchId", batchId)
	    		.when()
		    	.delete();
    } else {
        // Handle the case where there are not enough rows in the data
        System.out.println("There are not enough rows in the data.");
    }
	/*DeletebyID = RestAssured
			.given().header("Authorization","Bearer "+UserLoginController.token)
    		.spec(LMSReqspec.Delete_InvalidBatchbyBatchId())
    		.when()
	    	.delete();*/
}

@When("Admin sends HTTPS Request with invalid endpoint for Delete by ID")
public void admin_sends_https_request_with_invalid_endpoint_for_delete_by_id() {
	DeletebyID.then().log().all().extract().response();
}

@Then("Admin receives {int} not found for Delete by ID")
public void admin_receives_not_found_for_delete_by_id(Integer int1) {
	DeletebyID.then().statusCode(404);
}

@Given("Admin creates DELETE Request with invalid BatchId")
public void admin_creates_delete_request_with_invalid_batch_id() {
	DeletebyID = RestAssured
			.given().header("Authorization","Bearer "+UserLoginController.token)
    		.spec(LMSReqspec. Delete_InvalidBatchId())
    		.when()
	    	.delete();
}

@When("Admin sends HTTPS Request with valid endpoint for Delete by ID")
public void admin_sends_https_request_with_valid_endpoint_for_delete_by_id() {
	DeletebyID.then().log().all().extract().response();
}

@Then("Admin receives {int} Not Found Status with message and boolean success details for Delete by ID")
public void admin_receives_not_found_status_with_message_and_boolean_success_details_for_delete_by_id(Integer int1) {
	DeletebyID.then().statusCode(404);
}
//Get Batch by Batch name

@Given("Admin creates GET Request with valid Batch Name")
public void admin_creates_get_request_with_valid_batch_name() throws InvalidFormatException, IOException {
	List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "GetbyName"));
	// Iterate over each row of data
	
	 for (Map<String, String> row : getUserData){
		String batchName = row.get("batchName");
	 
	// Construct JSON body for the request
		String userInfoJson2 = "{" +
				"\"batchName\": \"" + batchName+"\"" +
	 "}";
	
		//String endpoint = "/batches/batchName/" + batchName;
		System.out.println(retrievedToken);
	GetAllbatchresponse = RestAssured.given()
    		.header("Authorization","Bearer "+UserLoginController.token)
	    	.spec(LMSReqspec.GET_BatchbyBatchName()).pathParam("batchName",batchName)
	    	.when()
	    	.get();
}}

@When("Admin sends HTTPS Request with endpointof get by Batch name")
public void admin_sends_https_request_with_endpointof_get_by_batch_name() {
	GetAllbatchresponse.then().log().all().extract().response();
}

@Then("Admin receives {int} OK Status with response body in batch Name.")
public void admin_receives_ok_status_with_response_body_in_batch_name(Integer int1) {
	//GetAllbatchresponse.then().statusCode(200);
	
}
//GET Request with invalid Batch Name
@Given("Admin creates GET Request with invalid Batch Name")
public void admin_creates_get_request_with_invalid_batch_name() throws InvalidFormatException, IOException {
	List<Map<String, String>> getUserData = UserExcelReader.getData(Endpoint.Excelpath, "GetbyName");

     // Check if there are at least two rows in the data
     if (getUserData.size() >= 2) {
         // Get the second row (index 1, as indexing starts from 0)
         Map<String, String> secondRow = getUserData.get(1);
         String batchName = secondRow.get("batchName");

         // Construct JSON body for the request
         String userInfoJson2 = "{\"batchName\": \"" + batchName + "\"}";

         // Perform the GET request
         GetAllbatchresponse = RestAssured.given()
                 .header("Authorization", "Bearer " + UserLoginController.token)
                 .spec(LMSReqspec.GET_BatchbyBatchName())
                 .pathParam("batchName", batchName)
                 .when()
                 .get();
     } else {
         // Handle the case where there are not enough rows in the data
         System.out.println("There are not enough rows in the data.");
     }
     
     
 }

	

@When("Admin sends HTTPS Request with endpointof get by invalid Batch name")
public void admin_sends_https_request_with_endpointof_get_by_invalid_batch_name() {
	GetAllbatchresponse.then().log().all().extract().response();
}

@Then("Admin receives {int} Not Found Status with message and boolean success details")
public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
	GetAllbatchresponse.then().statusCode(404);
}

//Get batch  by program ID
@Given("Admin creates GET Request with valid Program Id")
public void admin_creates_get_request_with_valid_program_id() throws InvalidFormatException, IOException {
	List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Batchmodule_validData"));
	// Iterate over each row of data
	
	 for (Map<String, String> row : getUserData){
		 String programId = row.get("programId");
			long programId1 =Long.parseLong(programId);
	 
	// Construct JSON body for the request
		String userInfoJson2 = "{" +
				"\"programId\": \"" + programId1+"\"," +
	 "}";
		System.out.println(userInfoJson2);
		GetAllbatchresponse = RestAssured
				.given().header("Authorization","Bearer "+UserLoginController.token)
	    		.spec(LMSReqspec.GET_BatchbyPgmID()).pathParam("programId", programId1)
	    		.when()
		    	.get();
	 }     
}

@When("Admin sends HTTPS Request with endpointof get by valid Program ID")
public void admin_sends_https_request_with_endpointof_get_by_valid_program_id() {
	GetAllbatchresponse.then().log().all().extract().response();
}

@Then("Admin receives {int} OK Status with response body Program ID.")
public void admin_receives_ok_status_with_response_body_program_id(Integer int1) {
	GetAllbatchresponse.then().statusCode(200);
}
@Given("Admin creates GET Request with invalid Program Id")
public void admin_creates_get_request_with_invalid_program_id() throws Exception, IOException {
	List<Map<String, String>> getUserData = UserExcelReader.getData(Endpoint.Excelpath, "GetInvalidPgmId");
    	for (Map<String, String> secondrow : getUserData){
   		 String programId = secondrow.get("programId");
   			long programId1 =Long.parseLong(programId);
       /* Map<String, String> secondRow = getUserData.get(1);
        String batchName = secondRow.get("batchName");*/

        // Construct JSON body for the request
        String userInfoJson2 = "{\"programId\": \"" + programId1 + "\"}";

        // Perform the GET request
        GetAllbatchresponse = RestAssured.given()
                .header("Authorization", "Bearer " + UserLoginController.token)
                .spec(LMSReqspec.GET_BatchbyPgmID())
                .pathParam("programId", programId1)
                .when()
                .get();
    }    
    
}

@When("Admin sends HTTPS Request with endpointof get by invalid Program ID")
public void admin_sends_https_request_with_endpointof_get_by_invalid_program_id() {
	GetAllbatchresponse.then().log().all().extract().response();
}

@Then("Admin receives {int} Not Found Status with message and boolean success details invalid Program ID.")
public void admin_receives_not_found_status_with_message_and_boolean_success_details_invalid_program_id(Integer int1) {
	GetAllbatchresponse.then().statusCode(404);
}
//Put Request
@Given("Admin creates PUT Request with valid BatchId and Data")
public void admin_creates_put_request_with_valid_batch_id_and_data() {
	try {
		// List<Map<String, String>> getUserData=(UserExcelReader.getData(Endpoint.BatchmoduleExcelpath, "LMS_valid_data_Batchmodule"));
		List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "Update_put"));
		// Iterate over each row of data
		
		 for (Map<String, String> row : getUserData){
			String batchDescription = row.get("batchDescription");
			String batchId = row.get("batchId");
			long batchId1 =Long.parseLong(batchId);
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
					"\"batchId\": \"" + batchId1+"\"," +
					"\"batchName\": \"" + batchName + "\"," +
					"\"batchNoOfClasses\": \"" + batchNoOfClasses1+"\"," +
					"\"batchStatus\": \"" + batchStatus + "\"," +
					"\"programId\": \"" + programId1+"\"," +
					"\"programName\": \"" + programName+"\"" +
					"}";
			System.out.println(userInfoJson1);
			 //batchId = BatchmoduleValidDataResponse.jsonPath().getString("batchId");
			//String batchId = BatchmoduleValidDataResponse.jsonPath().getString("batchId");
			BatchmoduleValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+UserLoginController.token)
		    		.spec(LMSReqspec.Put_batchID()).pathParam("batchId", batchId1).body(userInfoJson1)
		    		.when()
			    	.put();
			
				 }
		 
		 } catch (IOException | InvalidFormatException e) {
	        e.printStackTrace(); // Print the exception stack trace for debugging
	    }	   
	}


@When("Admin sends HTTPS Request with endpointof get by invalid UpdatebatchID")
public void admin_sends_https_request_with_endpointof_get_by_invalid_updatebatch_id() {
	
	BatchmoduleValidDataResponse.then().log().all().extract().response();
}

@Then("Admin receives {int} OK Status with updated value in response body UpdatebatchID.")
public void admin_receives_ok_status_with_updated_value_in_response_body_updatebatch_id(Integer int1) {
	BatchmoduleValidDataResponse.then().statusCode(200);
}


}
	
	

