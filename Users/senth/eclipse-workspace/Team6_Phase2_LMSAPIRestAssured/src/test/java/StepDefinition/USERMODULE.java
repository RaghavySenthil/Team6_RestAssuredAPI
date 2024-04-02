package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.testng.Assert.assertEquals;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import usermodule3_POJO.Json_PayLoad_PUT_UModule;

import org.junit.Assert;

import EndPoints.Endpoint;

import TestRequest.LMSReqspec;
import TestRunner.LMSTestRunner;
import Utilities.UserExcelReader;

public class USERMODULE {

	String reqBody;
	String token;
	Response response;
	

	Response ValidDataResponse;
	
    Object invalidtoken ="878rfjkh24938490frewkjf32423";
    Object invaliduserid ="UA692";
    Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
	Object getuserid =LMSTestRunner.scenarioContext.getContext("userid");	
	JSONObject requestParams = new JSONObject();
	JSONObject subrequestParams = new JSONObject();
	JSONObject userrolemaponj = new JSONObject();
	JSONArray requestarray = new JSONArray();
	JSONArray userrolemaparray = new JSONArray();


	@Given("Admin creates PUT Request with valid request body FOR USERROLEID")
	public void admin_creates_put_request_with_valid_request_body() {

		Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String endpoint = Endpoint.PUT_USER_ROLEID;
				String userID = row.get("userID");
				if(userID != null) {
				System.out.println("endpoint is ;" + endpoint);
				endpoint = endpoint.replace("{userID}", userID);
				System.out.println("updated endpoint of post user with userid : " + endpoint);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleID(row);

				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.Update_UserRoleID()).body(reqBody).when().put(endpoint);
				response.then().log().all();
				}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}

	@When("Admin sends HTTPS Request with endpoint UPDATE USERMODULE3")
	public void response_UPDATE_USERMODULE() {

		response.then().log().all().extract().response();

	}

	@Then("Admin receives statuscode with response body for usermodule3 update.")
	public void admin_receives_ok_status_with_response_body() {
		
		
		String responseBody = response.getBody().asString();
		try {
		String message = response.jsonPath().getString("message");
		String success = response.jsonPath().getString("success");
		
		int statuscode = response.getStatusCode();
		System.out.println("Statuscode:" + statuscode);
		
		if (statuscode == 200 && message != null) {
			response.then().assertThat().statusCode(200).extract().response().asString();
			Assert.assertTrue(message.contains("Updated for User"));
		} else if (statuscode == 401) {
			response.then().assertThat().statusCode(401).extract().response().asString();
		} else if (statuscode == 400 && message != null) {
			response.then().assertThat().statusCode(400).extract().response().asString();
			Assert.assertTrue(message.contains("already exists for user") || message.contains("User Role Info is mandatory") ||
					message.contains("User not found with Role") || message.contains("Batch Id must be greater than or equal to 1")
					|| message.contains(" User-Role-Program-Batch Status is Mandatory") || message.contains("Program Id must be greater than or equal to 1"));
			Assert.assertTrue(success.contains("false"));
		} else if (statuscode == 404 && message != null) {
			response.then().assertThat().statusCode(404).extract().response().asString();
			Assert.assertTrue(message.contains("Not Found") || message.contains("does not exist"));
			Assert.assertTrue(success.contains("false"));
		}
		else if (statuscode == 500) {
			
			String error = response.jsonPath().getString("error");
			response.then().assertThat().statusCode(500).extract().response().asString();
		}
		}catch (JsonPathException e) {
            System.err.println("Failed to parse JSON response error: " + e.getMessage());
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
				if(userID != null) {
				endpoint = endpoint.replace("{userID}", userID);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleID(row);
				System.out.println("request body of post user with userid : " + reqBody);
				System.out.println("updated endpoint of post user with userid : " + endpoint);

				Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
				System.out.println("retreived token ");
				response = RestAssured.given().spec(LMSReqspec.Update_UserRoleID()).body(reqBody).when().put(endpoint);
				response.then().log().all();}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}

	}

	@Then("Admin receives statuscode with Unauthorized message for usermodule3 update")
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
				if (userID != null) {
				endpoint = endpoint.replace("{userID}", userID);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleID(row);
				System.out.println("request body of post user with userid : " + reqBody);
				System.out.println("updated endpoint of post user with userid : " + endpoint);

				Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
				System.out.println("retreived token ");
				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.Update_UserRoleID()).body(reqBody).when().put(endpoint);
				response.then().log().all();}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}


	@Then("Admin receives  status code and Not Found Status for usermodule3 update")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details() {

		int statuscode = response.getStatusCode();
		System.out.println("Statuscode:" + statuscode);

		response.then().assertThat().statusCode(400).extract().response().asString();

	}
//PUT_Loginstatus_USERMODULE3 

	@Given("Admin creates PUT Request with valid data in request body for USerLOGINSTATUS")
	public void create_PUT_USERModule_loginstatus() {
		Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token");
		 List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
			
		 for (Map<String, String> row : getUserData){
			 String endpoint=Endpoint.PUT_LOGIN_STATUS;
				String userID = row.get("userID");
          System.out.println("endpoint is ;"+endpoint);
          if(userID !=null) {
		 endpoint = endpoint.replace("{userId}",userID);
		 System.out.println("updated endpoint of post user with userid : "+endpoint);	
		 reqBody = Json_PayLoad_PUT_UModule.createPayload_userloginstatus(row);
		 
		    response = RestAssured
	        		.given().header("Authorization","Bearer "+retrievedToken)
	        		.spec(LMSReqspec.Update_UserLoginStatus()).body(reqBody)
	        		.when().
	        		put(endpoint);
		    response.then().log().all();}
	}
		 }
		 catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }  
	}
	

	@Given("Admin creates PUT Request with valid data in request body but no Auth for USerLOGINSTATUS")
	public void create_put_reques_loginstatus_noAuth() {
		Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token");
		 List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
			
		 for (Map<String, String> row : getUserData){
			 String endpoint=Endpoint.PUT_LOGIN_STATUS;
				String userID = row.get("userID");
				if(userID != null) {
         System.out.println("endpoint is ;"+endpoint);
		 endpoint = endpoint.replace("{userId}",userID);
		 System.out.println("updated endpoint of post user with userid : "+endpoint);	
		 reqBody = Json_PayLoad_PUT_UModule.createPayload_userloginstatus(row);
		 
		    response = RestAssured
	        		.given()
	        		.spec(LMSReqspec.Update_UserLoginStatus()).body(reqBody)
	        		.when().
	        		put(endpoint);
		    response.then().log().all();}
	}
		 }
		 catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }  
	}
	
	
	@Given("Admin creates PUT Request with invalid enpoint and valid request body for USerLOGINSTATUS")
	public void admin_creates_put_request_with_invalid_enpoint_and_valid_request_body_for_u_ser_loginstatus() {
		Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token");
		 List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
			
		 for (Map<String, String> row : getUserData){
			 String endpoint=Endpoint.PUT_LOGIN_STATUS_INVALID_ENDPOINT;
				String userID = row.get("userID");
				if(userID != null) {
         System.out.println("endpoint is ;"+endpoint);
		 endpoint = endpoint.replace("{userId}",userID);
		 System.out.println("updated endpoint of post user with userid : "+endpoint);	
		 reqBody = Json_PayLoad_PUT_UModule.createPayload_userloginstatus(row);
		 
		    response = RestAssured
	        		.given().header("Authorization","Bearer "+retrievedToken)
	        		.spec(LMSReqspec.Update_UserLoginStatus()).body(reqBody)
	        		.when().
	        		put(endpoint);
		    response.then().log().all();}
	}
		 }
		 catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); 
		    }  
	}
	//USER ROLE STATUS IN USERMODULE3
	@Given("Admin creates PUT Request with valid data in request body")
	public void admin_creates_PUT_USER_ROLE_STATUS_valid_request_body() {
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String userID = row.get("userID");
				String endpoint = Endpoint.PUT_USER_ROLE_STATUS;
				if(userID != null) {
				endpoint = endpoint.replace("{userID}", userID);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleStatus(row);
				System.out.println("request body of post user with userid : " + reqBody);
				System.out.println("updated endpoint of post user with userid : " + endpoint);

				Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
				System.out.println("retreived token ");
				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.update_UserRoleStatus()).body(reqBody).when().put(endpoint);
				response.then().log().all();}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}
	
	 @Given ("Admin creates PUT Request with valid data in request body with no authorization")
	public void create_put_userroleStatus_request_noAuth() {
		 String endpoint = Endpoint.PUT_USER_ROLE_STATUS;
			List<Map<String, String>> getUserData;
			try {
				getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

				for (Map<String, String> row : getUserData) {
					String userID = row.get("userID");
					if(userID != null) {
					endpoint = endpoint.replace("{userID}", userID);
					reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleStatus(row);
					System.out.println("request body of post user with userid : " + reqBody);
					System.out.println("updated endpoint of post user with userid : " + endpoint);

					Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
					System.out.println("retreived token ");
					response = RestAssured.given().spec(LMSReqspec.update_UserRoleStatus()).body(reqBody).when().put(endpoint);
					response.then().log().all();}
				}
			} catch (IOException | InvalidFormatException e) {
				e.printStackTrace(); 
			}

	}
	
	 

	@Given("Admin creates PUT Request with valid data in request body  for invalid endpoint")
	public void create_put_request_userROlestatus_Invalid_endpoint() {
		Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token");
		 List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
			 System.out.println("read the input file");
		 for (Map<String, String> row : getUserData){
			 String endpoint=Endpoint.PUT_USER_ROLE_STATUS_INVALID_ENDPOINT;
				String userID = row.get("userID");
				if(userID !=null) {
          System.out.println("endpoint is ;"+endpoint);
		 endpoint = endpoint.replace("{userID}",userID);
		 System.out.println("updated endpoint of post user with userid : "+endpoint);	
		 reqBody = Json_PayLoad_PUT_UModule.createPayload_RoleStatus(row);
		 
		    response = RestAssured
	        		.given().header("Authorization","Bearer "+retrievedToken)
	        		.spec(LMSReqspec.update_UserRoleStatus()).body(reqBody)
	        		.when().
	        		put(endpoint);
		    response.then().log().all();}
	}
		 }
		 catch (IOException | InvalidFormatException e) {
		        e.printStackTrace(); // Print the exception stack trace for debugging
		    }
	}
	//DELETE USER IN USERMODULE3
	@Given("Admin creates DELETE Request to delete Admin details for USERMODULE")
	public void Delete_usermodulebyuserid() {

		Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String endpoint = Endpoint.DELETE_USER_BYID;
				String userID = row.get("userID");
				System.out.println("endpoint is ;" + endpoint);
				if(userID != null) {
				endpoint = endpoint.replace("{userID}", userID);
				System.out.println("updated endpoint of post user with userid : " + endpoint);
				

				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.DeleteByUserID()).when().delete(endpoint);
				response.then().log().all();
				}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); 
		}
	}
	@Given("Admin creates DELETE Request to delete Admin details without Auth")
	public void Delete_usermodulebyuserid_NOAUTH() {

		Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String endpoint = Endpoint.DELETE_USER_BYID;
				String userID = row.get("userID");
				System.out.println("endpoint is ;" + endpoint);
				if(userID != null) {
				endpoint = endpoint.replace("{userID}", userID);
				
				System.out.println("updated endpoint of post user with userid : " + endpoint);
				response = RestAssured.given()
						.spec(LMSReqspec.DeleteByUserID()).when().delete(endpoint);
				response.then().log().all();
				}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); 
		}
	}
	//update request for USERMODULE URPBS
	@Given("Admin creates PUT Request with valid data in request body for userrolePBS")
	public void Create_PUT_URPBS_REQ() {

		Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String endpoint = Endpoint.PUT_URPBS;
				String userID = row.get("userID");
				if(userID != null) {
				System.out.println("endpoint is ;" + endpoint);
				endpoint = endpoint.replace("{userId}", userID);
				System.out.println("updated endpoint of post user with userid : " + endpoint);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_URPBS(row);

				response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
						.spec(LMSReqspec.update_URPBS()).body(reqBody).when().put(endpoint);
				response.then().log().all();}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}
	@Given("Admin creates PUT Request with valid data in request body for userrolePBS with NoAUTH")
	public void Create_PUT_URPBS_REQ_NOAUTH() {

		Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
		List<Map<String, String>> getUserData;
		try {
			getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

			for (Map<String, String> row : getUserData) {
				String endpoint = Endpoint.PUT_URPBS;
				String userID = row.get("userID");
				if(userID != null) {
				System.out.println("endpoint is ;" + endpoint);
				endpoint = endpoint.replace("{userId}", userID);
				System.out.println("updated endpoint of post user with userid : " + endpoint);
				reqBody = Json_PayLoad_PUT_UModule.createPayload_URPBS(row);

				response = RestAssured.given()
						.spec(LMSReqspec.update_URPBS()).body(reqBody).when().put(endpoint);
				response.then().log().all();}
			}
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}
	
		@Given("Admin creates PUT Request with valid data in request body for userrolePBS with invalid endpoint")
		public void Create_PUT_URPBS_REQ_invalid_endpoint() {

			Object retrievedToken = LMSTestRunner.scenarioContext.getContext("Token");
			List<Map<String, String>> getUserData;
			try {
				getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));

				for (Map<String, String> row : getUserData) {
					String endpoint = Endpoint.PUT_URPBS_INVALID_ENDPOINT;
					String userID = row.get("userID");
					if(userID != null) {
					System.out.println("endpoint is ;" + endpoint);
					endpoint = endpoint.replace("{userId}", userID);
					System.out.println("updated endpoint of post user with userid : " + endpoint);
					reqBody = Json_PayLoad_PUT_UModule.createPayload_URPBS(row);

					response = RestAssured.given().header("Authorization", "Bearer " + retrievedToken)
							.spec(LMSReqspec.update_URPBS()).body(reqBody).when().put(endpoint);
					response.then().log().all();}
				}
			} catch (IOException | InvalidFormatException e) {
				e.printStackTrace(); // Print the exception stack trace for debugging
			}
	}
		// *********  end of usermodule3 ***********//

		String userComments;
		String userEduPg;
		String userEduUg;
		String userFirstName;
		String userId;
		String userLastName;
		String userLinkedinUrl;
		String userLocation;
		String loginStatus;
		String password;
		String roleIds;
		String status;
		String userLoginEmail;
		String userMiddleName;
		String userPhoneNumber;
		long userPhoneNumber1;
		String roleId;
		String userRoleStatus;
		String userTimeZone;
		String userVisaStatus;

		@Given("Admin creates POST request with all mandatory fields")
		public void admin_creates_post_request_with_all_mandatory_fields() throws InvalidFormatException, IOException {


			 List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));
			 System.out.println(getUserData.get(1).get("userLocation"));	

				userComments = getUserData.get(0).get("userComments");
				userEduPg = getUserData.get(0).get("userEduPg");
				userEduUg = getUserData.get(0).get("userEduUg");
				userFirstName = getUserData.get(0).get("userFirstName");
				userLastName = getUserData.get(0).get("userLastName");
				userLinkedinUrl = getUserData.get(0).get("userLinkedinUrl");
				//userLocation = getUserData.get(0).get("userLocation");
				//loginStatus = getUserData.get(0).get("loginStatus");
				//password = getUserData.get(0).get("password");
				//roleIds = getUserData.get(0).get("roleIds");
				//status = getUserData.get(0).get("status");
				userLocation = "null";  
				loginStatus = "null";
				password = "null";
				roleIds = "null";
				status = "null";
				
				userLoginEmail = getUserData.get(0).get("userLoginEmail");
				userMiddleName = getUserData.get(0).get("userMiddleName");
				userPhoneNumber = getUserData.get(0).get("userPhoneNumber");
				userPhoneNumber1 = Long.parseLong(userPhoneNumber);
				roleId = getUserData.get(0).get("roleId");
				userRoleStatus = getUserData.get(0).get("userRoleStatus");
				userTimeZone = getUserData.get(0).get("userTimeZone");
				userVisaStatus = getUserData.get(0).get("userVisaStatus");
				
			    requestParams.put("userComments", userComments);
			    requestParams.put("userEduPg", userEduPg); 
			    requestParams.put("userEduUg", userEduUg);
			    requestParams.put("userFirstName", userFirstName); 
			    requestParams.put("userLastName", userLastName);
			    requestParams.put("userLinkedinUrl", userLinkedinUrl); 
			    requestParams.put("userLocation", userLocation);
			    
			    subrequestParams.put("loginStatus", loginStatus);
			    subrequestParams.put("password", password);
			    
			    
			    requestParams.put("userLogin", subrequestParams);
			    
			    requestarray.add(roleIds);
			    subrequestParams.put("roleIds", requestarray);
			    subrequestParams.put("status", status);
			    subrequestParams.put("userLoginEmail", userLoginEmail);
			    
			    requestParams.put("userMiddleName", userMiddleName);
			    requestParams.put("userPhoneNumber", userPhoneNumber1);
			    
			    userrolemaponj.put("roleId", roleId);
			    userrolemaponj.put("userRoleStatus", userRoleStatus);
			    
			    userrolemaparray.add(userrolemaponj);
			    requestParams.put("userRoleMaps", userrolemaparray);
			    
			    requestParams.put("userTimeZone", userTimeZone);
			    requestParams.put("userVisaStatus", userVisaStatus);

			    System.out.println(requestParams.toJSONString());

		}

		@When("Admin sends HTTPS Request with endpoint")
		public void admin_sends_https_request_with_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
		    		.spec(LMSReqspec.PostValidData()).body(requestParams.toJSONString())
		    		.when()
			    	.post();

		}

		@Then("Admin receives {int} Created Status with response body.")
		public void admin_receives_created_status_with_response_body(Integer int1) {

			Object set_userid = LMSTestRunner.scenarioContext.setContext("userid", ValidDataResponse.jsonPath().getString("userId"));
			
			ValidDataResponse.then().log().all();
			ValidDataResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/Test_Data/UsermoduleSchema.json")));
			assertEquals(userComments,ValidDataResponse.jsonPath().getString("userComments") ); 
			assertEquals(userEduPg,ValidDataResponse.jsonPath().getString("userEduPg") );
			assertEquals(userEduUg,ValidDataResponse.jsonPath().getString("userEduUg") );
			assertEquals(userFirstName,ValidDataResponse.jsonPath().getString("userFirstName") );
			assertEquals(userLoginEmail,ValidDataResponse.jsonPath().getString("userLoginEmail") );
			assertEquals(userLastName,ValidDataResponse.jsonPath().getString("userLastName") );
			assertEquals(userLinkedinUrl,ValidDataResponse.jsonPath().getString("userLinkedinUrl") );
			assertEquals(userLocation,ValidDataResponse.jsonPath().getString("userLocation") );
			assertEquals(userMiddleName, ValidDataResponse.jsonPath().getString("userMiddleName"));
		    assertEquals(userTimeZone, ValidDataResponse.jsonPath().getString("userTimeZone"));
		    assertEquals(userVisaStatus, ValidDataResponse.jsonPath().getString("userVisaStatus"));
		    ValidDataResponse.then().statusCode(201);
		    ValidDataResponse.then().header("Content-Type", "application/json");


		}

		@Given("Admin creates POST request with all mandatory fields and additional fields")
		public void admin_creates_post_request_with_all_mandatory_fields_and_additional_fields() throws InvalidFormatException, IOException {
			
			 List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));


				userComments = getUserData.get(1).get("userComments");
				userEduPg = getUserData.get(1).get("userEduPg");
				userEduUg = getUserData.get(1).get("userEduUg");
				userFirstName = getUserData.get(1).get("userFirstName");
				userLastName = getUserData.get(1).get("userLastName");
				userLinkedinUrl = getUserData.get(1).get("userLinkedinUrl");
				userLocation = getUserData.get(1).get("userLocation");  
				loginStatus = getUserData.get(1).get("loginStatus");
				password = getUserData.get(1).get("password");
				roleIds = getUserData.get(1).get("roleIds");
				status = getUserData.get(1).get("status");
				userLoginEmail = getUserData.get(1).get("userLoginEmail");
				userMiddleName = getUserData.get(1).get("userMiddleName");
				userPhoneNumber = getUserData.get(1).get("userPhoneNumber");
				userPhoneNumber1 = Long.parseLong(userPhoneNumber);
				roleId = getUserData.get(1).get("roleId");
				userRoleStatus = getUserData.get(1).get("userRoleStatus");
				userTimeZone = getUserData.get(1).get("userTimeZone");
				userVisaStatus = getUserData.get(1).get("userVisaStatus");
				
			    requestParams.put("userComments", userComments);
			    requestParams.put("userEduPg", userEduPg); 
			    requestParams.put("userEduUg", userEduUg);
			    requestParams.put("userFirstName", userFirstName); 
			    requestParams.put("userLastName", userLastName);
			    requestParams.put("userLinkedinUrl", userLinkedinUrl); 
			    requestParams.put("userLocation", userLocation);
			    
			    subrequestParams.put("loginStatus", loginStatus);
			    subrequestParams.put("password", password);
			    
			    
			    requestParams.put("userLogin", subrequestParams);
			    
			    requestarray.add(roleIds);
			    subrequestParams.put("roleIds", requestarray);
			    subrequestParams.put("status", status);
			    subrequestParams.put("userLoginEmail", userLoginEmail);
			    
			    requestParams.put("userMiddleName", userMiddleName);
			    requestParams.put("userPhoneNumber", userPhoneNumber1);
			    
			    userrolemaponj.put("roleId", roleId);
			    userrolemaponj.put("userRoleStatus", userRoleStatus);
			    
			    userrolemaparray.add(userrolemaponj);
			    requestParams.put("userRoleMaps", userrolemaparray);
			    
			    requestParams.put("userTimeZone", userTimeZone);
			    requestParams.put("userVisaStatus", userVisaStatus);

		}

		@Given("Admin creates POST request with invalid values in request body")
		public void admin_creates_post_request_with_invalid_values_in_request_body() throws InvalidFormatException, IOException {

			 List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));


				userComments = getUserData.get(2).get("userComments");
				userEduPg = getUserData.get(2).get("userEduPg");
				userEduUg = getUserData.get(2).get("userEduUg");
				userFirstName = getUserData.get(2).get("userFirstName");
				userLastName = getUserData.get(2).get("userLastName");
				userLinkedinUrl = getUserData.get(2).get("userLinkedinUrl");
				userLocation = getUserData.get(2).get("userLocation");  
				loginStatus = getUserData.get(2).get("loginStatus");
				password = getUserData.get(2).get("password");
				roleIds = getUserData.get(2).get("roleIds");
				status = getUserData.get(2).get("status");
				userLoginEmail = getUserData.get(2).get("userLoginEmail");
				userMiddleName = getUserData.get(2).get("userMiddleName");
				userPhoneNumber = getUserData.get(2).get("userPhoneNumber");
				userPhoneNumber1 = Long.parseLong(userPhoneNumber);
				roleId = getUserData.get(2).get("roleId");
				userRoleStatus = getUserData.get(2).get("userRoleStatus");
				userTimeZone = getUserData.get(2).get("userTimeZone");
				userVisaStatus = getUserData.get(2).get("userVisaStatus");
				
			    requestParams.put("userComments", userComments);
			    requestParams.put("userEduPg", userEduPg); 
			    requestParams.put("userEduUg", userEduUg);
			    requestParams.put("userFirstName", userFirstName); 
			    requestParams.put("userLastName", userLastName);
			    requestParams.put("userLinkedinUrl", userLinkedinUrl); 
			    requestParams.put("userLocation", userLocation);
			    
			    subrequestParams.put("loginStatus", loginStatus);
			    subrequestParams.put("password", password);
			    
			    
			    requestParams.put("userLogin", subrequestParams);
			    
			    requestarray.add(roleIds);
			    subrequestParams.put("roleIds", requestarray);
			    subrequestParams.put("status", status);
			    subrequestParams.put("userLoginEmail", userLoginEmail);
			    
			    requestParams.put("userMiddleName", userMiddleName);
			    requestParams.put("userPhoneNumber", userPhoneNumber1);
			    
			    userrolemaponj.put("roleId", roleId);
			    userrolemaponj.put("userRoleStatus", userRoleStatus);
			    
			    userrolemaparray.add(userrolemaponj);
			    requestParams.put("userRoleMaps", userrolemaparray);
			    
			    requestParams.put("userTimeZone", userTimeZone);
			    requestParams.put("userVisaStatus", userVisaStatus);


		}

		@Then("Admin receives {int} Bad Request Status with message and boolean success details")
		public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {

			ValidDataResponse.then().log().all();
		    ValidDataResponse.then().statusCode(400);
		    ValidDataResponse.then().header("Content-Type", "application/json");

		}

		@Given("Admin creates POST request with missing mandatory fields in request body")
		public void admin_creates_post_request_with_missing_mandatory_fields_in_request_body() throws InvalidFormatException, IOException {

			 List<Map<String, String>> getUserData= (UserExcelReader.getData(Endpoint.Excelpath, "LMS_valid_dataFinalUpdate_data1"));


				userComments = getUserData.get(3).get("userComments");
				userEduPg = getUserData.get(3).get("userEduPg");
				userEduUg = getUserData.get(3).get("userEduUg");
				userFirstName = getUserData.get(3).get("userFirstName");
				userLastName = getUserData.get(3).get("userLastName");
				userLinkedinUrl = getUserData.get(3).get("userLinkedinUrl");
				userLocation = getUserData.get(3).get("userLocation");  
				loginStatus = getUserData.get(3).get("loginStatus");
				password = getUserData.get(3).get("password");
				roleIds = getUserData.get(3).get("roleIds");
				status = getUserData.get(3).get("status");
				userLoginEmail = getUserData.get(3).get("userLoginEmail");
				userMiddleName = getUserData.get(3).get("userMiddleName");
				userPhoneNumber = getUserData.get(3).get("userPhoneNumber");
				userPhoneNumber1 = Long.parseLong(userPhoneNumber);
				roleId = getUserData.get(3).get("roleId");
				userRoleStatus = getUserData.get(3).get("userRoleStatus");
				userTimeZone = getUserData.get(3).get("userTimeZone");
				userVisaStatus = getUserData.get(3).get("userVisaStatus");
				
			    requestParams.put("userComments", userComments);
			    requestParams.put("userEduPg", userEduPg); 
			    requestParams.put("userEduUg", userEduUg);
			    requestParams.put("userFirstName", userFirstName); 
			    requestParams.put("userLastName", userLastName);
			    requestParams.put("userLinkedinUrl", userLinkedinUrl); 
			    requestParams.put("userLocation", userLocation);
			    
			    subrequestParams.put("loginStatus", loginStatus);
			    subrequestParams.put("password", password);
			    
			    
			    requestParams.put("userLogin", subrequestParams);
			    
			    requestarray.add(roleIds);
			    subrequestParams.put("roleIds", requestarray);
			    subrequestParams.put("status", status);
			    subrequestParams.put("userLoginEmail", userLoginEmail);
			    
			    requestParams.put("userMiddleName", userMiddleName);
			    requestParams.put("userPhoneNumber", userPhoneNumber1);
			    
			    userrolemaponj.put("roleId", roleId);
			    userrolemaponj.put("userRoleStatus", userRoleStatus);
			    
			    userrolemaparray.add(userrolemaponj);
			    requestParams.put("userRoleMaps", userrolemaparray);
			    
			    requestParams.put("userTimeZone", userTimeZone);
			    requestParams.put("userVisaStatus", userVisaStatus);


		}

		@Then("Admin receives {int} Bad Request Status with error message")
		public void admin_receives_bad_request_status_with_error_message(Integer int1) {

			ValidDataResponse.then().log().all();
		    ValidDataResponse.then().statusCode(400);
		    ValidDataResponse.then().header("Content-Type", "application/json");

		}
		
		@Then("Admin receives status {int} with Unauthorized message")
		public void admin_receives_status_with_unauthorized_message(Integer int1) {
			ValidDataResponse.then().log().all();
		    ValidDataResponse.then().statusCode(401);
		    ValidDataResponse.then().header("Content-Type", "application/json");

		}
		
		
		@Given("Admin creates GET Request")
		public void admin_creates_get_request() {


		}

		@When("Admin sends HTTPS Request with GET All Roles endpoint")
		public void admin_sends_https_request_with_get_all_roles_endpoint() {
			
			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
		    		.spec(LMSReqspec.GetAllRoles())
		    		.when()
			    	.get();


		}

		@Then("Admin receives {int} OK")
		public void admin_receives_ok(Integer int1) {

			ValidDataResponse.then().log().all();
		    ValidDataResponse.then().statusCode(200);
		    ValidDataResponse.then().header("Content-Type", "application/json");

		}	
		
		@When("Admin sends HTTPS Request with endpoint without authorization")
		public void admin_sends_https_request_with_endpoint_without_authorization() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+invalidtoken)
		    		.spec(LMSReqspec.PostValidData()).body(requestParams.toJSONString())
		    		.when()
			    	.post();

		}	
		@When("Admin sends HTTPS Request with GET All Roles endpoint without Authorization")
		public void admin_sends_https_request_with_get_all_roles_endpoint_without_authorization() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+invalidtoken)
		    		.spec(LMSReqspec.GetAllRoles())
		    		.when()
			    	.get();

		}
		
		@When("Admin sends HTTPS Request with invalid endpoint")
		public void admin_sends_https_request_with_invalid_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
		    		.spec(LMSReqspec.GetAllRoles_invalidendpoint())
		    		.when()
			    	.get();

		}

		@Then("Admin receives status {int} with Not Found error message")
		public void admin_receives_status_with_not_found_error_message(Integer int1) {
			ValidDataResponse.then().log().all();
		    ValidDataResponse.then().statusCode(404);
		    ValidDataResponse.then().header("Content-Type", "application/json");

		}
		
		@When("Admin sends HTTPS Request with valid endpoint")
		public void admin_sends_https_request_with_valid_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
		    		.spec(LMSReqspec.GetAllUsers())
		    		.when()
			    	.get();

		}

		@Then("Admin receives {int} OK Status with response body")
		public void admin_receives_ok_status_with_response_body(Integer int1) {
			ValidDataResponse.then().log().all();
		    ValidDataResponse.then().statusCode(200);
		    ValidDataResponse.then().header("Content-Type", "application/json");
		}

		@When("Admin sends HTTPS Request with valid endpoint without Authorization")
		public void admin_sends_https_request_with_valid_endpoint_without_authorization() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+invalidtoken)
		    		.spec(LMSReqspec.GetAllRoles())
		    		.when()
			    	.get();

		}	
		@Given("Admin creates GET Request with valid AdminId")
		public void admin_creates_get_request_with_valid_admin_id() {

		}

		@When("Admin sends HTTPS Request to retrieve a Admin with valid Admin ID with valid endpoint")
		public void admin_sends_https_request_to_retrieve_a_admin_with_valid_admin_id_with_valid_endpoint() {
		    
			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.pathParam("id", getuserid)
		    		.spec(LMSReqspec.GetUserby_Userid())
		    		.when()
			    	.get();

		}	

		@When("Admin sends HTTPS Request to retrieve a Admin with valid Admin ID with invalid endpoint")
		public void admin_sends_https_request_to_retrieve_a_admin_with_valid_admin_id_with_invalid_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.pathParam("id", getuserid)
		    		.spec(LMSReqspec.GetUserby_Userid_invalidendpoint())
		    		.when()
			    	.get();

		}

		@When("Admin sends HTTPS Request to retrieve a Admin with valid Admin ID with valid endpoint without Authorization")
		public void admin_sends_https_request_to_retrieve_a_admin_with_valid_admin_id_with_valid_endpoint_without_authorization() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+invalidtoken)
					.pathParam("id", getuserid)
		    		.spec(LMSReqspec.GetUserby_Userid())
		    		.when()
			    	.get();
			
		}

		@Given("Admin creates GET Request with invalid AdminId")
		public void admin_creates_get_request_with_invalid_admin_id() {

		}

		@When("Admin sends HTTPS Request to retrieve a Admin with invalid Admin ID with valid endpoint")
		public void admin_sends_https_request_to_retrieve_a_admin_with_invalid_admin_id_with_valid_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.pathParam("id", invaliduserid)
		    		.spec(LMSReqspec.GetUserby_Userid())
		    		.when()
			    	.get();

		}
		@When("Admin sends HTTPS Request to retrieve all active Admins with endpoint")
		public void admin_sends_https_request_to_retrieve_all_active_admins_with_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
		    		.spec(LMSReqspec.GetAllUsers_withRoles())
		    		.when()
			    	.get();

		}

		@When("Admin sends HTTPS Request to retrieve all active Admins with endpoint without Authorization")
		public void admin_sends_https_request_to_retrieve_all_active_admins_with_endpoint_without_authorization() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+invalidtoken)
		    		.spec(LMSReqspec.GetAllUsers_withRoles())
		    		.when()
			    	.get();

		}

		@When("Admin sends HTTPS Request to retrieve all active Admins with invalid endpoint")
		public void admin_sends_https_request_to_retrieve_all_active_admins_with_invalid_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
		    		.spec(LMSReqspec.GetAllUsers_withRoles_invalidendpoint())
		    		.when()
			    	.get();
			
		}	
		@When("Admin sends HTTPS Request to get count of active and inactive Admins with endpoint")
		public void admin_sends_https_request_to_get_count_of_active_and_inactive_admins_with_endpoint() {
			
			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.queryParam("id", "all")
		    		.spec(LMSReqspec.Get_Users_RoleStatus())
		    		.when()
			    	.get();

		}	
		@When("Admin sends HTTPS Request to get count of active and inactive Admins with no authorization")
		public void admin_sends_https_request_to_get_count_of_active_and_inactive_admins_with_no_authorization() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+invalidtoken)
					.queryParam("id", "all")
		    		.spec(LMSReqspec.Get_Users_RoleStatus())
		    		.when()
			    	.get();

		}

		@When("Admin sends HTTPS Request to get count of active and inactive Admins with invalid endpoint")
		public void admin_sends_https_request_to_get_count_of_active_and_inactive_admins_with_invalid_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.queryParam("id", "all")
		    		.spec(LMSReqspec.Get_Users_RoleStatus_invalidendpoint())
		    		.when()
			    	.get();

		}

		@Given("Admin creates GET Request with role id")
		public void admin_creates_get_request_with_role_id() {

		}

		@When("Admin sends HTTPS Request to get count of active and inactive Admins by role id with endpoint")
		public void admin_sends_https_request_to_get_count_of_active_and_inactive_admins_by_role_id_with_endpoint() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.queryParam("id", "R01")
		    		.spec(LMSReqspec.Get_Users_RoleStatus())
		    		.when()
			    	.get();

		}

		@Given("Admin creates GET Request with invalid role id")
		public void admin_creates_get_request_with_invalid_role_id() {

		}

		@When("Admin sends HTTPS Request to get count of active and inactive Admins by invalid role ID")
		public void admin_sends_https_request_to_get_count_of_active_and_inactive_admins_by_invalid_role_id() {

			ValidDataResponse = RestAssured
					.given().header("Authorization","Bearer "+retrievedToken)
					.queryParam("id", "R06")
		    		.spec(LMSReqspec.Get_Users_RoleStatus())
		    		.when()
			    	.get();

		}	
}
