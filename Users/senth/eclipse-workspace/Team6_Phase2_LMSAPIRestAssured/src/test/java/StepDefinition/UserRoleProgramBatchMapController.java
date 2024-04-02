package StepDefinition;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;

import EndPoints.Endpoint;
import TestRequest.ReqResSpecification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UserRoleProgramBatchMapController extends ReqResSpecification {
	
	public RequestSpecification reqSpec;
	public ResponseSpecification resSpec;
	public Response response=null;
	public JSONObject requestBody;
	
	@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches")
	public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches() {
		reqSpec = setReqSpecification("Valid","Valid",null);
		resSpec=setResSpecification(200);
	}

	@When("Admin sends HTTPS Request map")
	public void admin_sends_https_request_map() {
		 response = 
					RestAssured
		 	.given()
		 		.spec(reqSpec)
			.when()
				//.get("/userRoleProgramBatchMap")
			.get(Endpoint.Get_all_program_users)
			.then()
				.spec(resSpec)
				.extract().response();
			
	}

	@Then("Admin receives {int} OK map")
	public void admin_receives_ok_map(Integer int1) {
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());

	}
	@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches without authorization")
	public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches_without_authorization() {
		reqSpec = setReqSpecification("Valid","NoAuth",null);
		resSpec=setResSpecification(401);
	}

	@When("Admin sends HTTPS Request without authorization")
	public void admin_sends_https_request_without_authorization() {
		 response = 
					RestAssured
		 	.given()
		 		.spec(reqSpec)
			.when()
				//.get("/userRoleProgramBatchMap")
			.get(Endpoint.Get_all_program_users)
			.then()
				.spec(resSpec)
				.extract().response();
		
	}

	@Then("Admin receives status {int} with Unauthorized message map")
	public void admin_receives_status_with_unauthorized_message_map(Integer int1) {
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
	}
	@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches for ProgramBatchMap")
	public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches_for_program_batch_map() {
		reqSpec = setReqSpecification("Valid","Valid",null);
		resSpec=setResSpecification(404);
	}

	@When("Admin sends HTTPS Request with invalid endpoint for ProgramBatchMap")
	public void admin_sends_https_request_with_invalid_endpoint_for_program_batch_map() {
		response = 
				RestAssured
	 	.given()
	 		.spec(reqSpec)
		.when()
			//.get("/userRoleProgramBatchMap")
		.get(Endpoint.Invalid_Get_all_program_users)
		.then()
			.spec(resSpec)
			.extract().response();
		

	}

	@Then("Admin receives status map {int}")
	public void admin_receives_status_map(Integer int1) {
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
	}
	@Given("Admin creates GET Request to retrieve Admin assigned to Program\\/Batch by AdminId")
	public void admin_creates_get_request_to_retrieve_admin_assigned_to_program_batch_by_admin_id() {
		reqSpec = setReqSpecification("Valid","Valid",null);
		//resSpec=setResSpecification(200);
	}

	@When("Admin sends HTTPS Request to get assigned program by adminId {string} endpoint")
	public void admin_sends_https_request_to_get_assigned_program_by_admin_id_endpoint(String userId) {
		String gnEndPoint = Endpoint.Get_all_program_user_by_ID;
		String end_point = gnEndPoint.replace("{userId}", userId);
		System.out.println(end_point);
		response = 
					RestAssured
		 	.given()
		 		.spec(reqSpec)
			.when()
			.get(end_point)
			.then()
				
				.extract().response();
	   
	}

	@Then("Admin receives {int} in response body map")
	public void admin_receives_in_response_body_map(Integer status) {
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statuscode=response.getStatusCode();

		assertEquals(status, statuscode);
	}


	@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by valid AdminId and no auth")
	public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_valid_admin_id_and_no_auth() {
		reqSpec = setReqSpecification("Valid","NoAuth",null);

	}

	@When("Admin sends HTTPS Request to delete endpoint  by {string}")
	public void admin_sends_https_request_to_delete_endpoint_by(String userId) {
		String gnEndPoint = Endpoint.Delete_all_programs_by_ID;
		String end_point = gnEndPoint.replace("{userId}", userId);
		System.out.println(end_point);
		response = 
					RestAssured
		 	.given()
		 		.spec(reqSpec)
			.when()
			.delete(end_point)
			.then()
				
				.extract().response();

	}

	@Then("Admin receives status {int} with Unauthorized map1")
	public void admin_receives_status_with_unauthorized_map1(Integer status) {
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statuscode=response.getStatusCode();

		assertEquals(status, statuscode);

	}

	@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by AdminId")
	public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_admin_id() {
		reqSpec = setReqSpecification("Valid","Valid",null);
	  
	}



}