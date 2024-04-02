package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;

import EndPoints.Endpoint;
import TestRequest.ReqResSpecification;
import TestRunner.LMSTestRunner;
import Utilities.UserExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Program_Module extends ReqResSpecification{

	
    private static Logger logger = LogManager.getLogger(Program_Module.class);
	
	//RequestSpecBuilder reqSpeBuilder;
	public RequestSpecification reqSpec;
	public ResponseSpecification resSpec;
	public Response response=null;
	public JSONObject requestBody;
	
	Object objProgId = null;
	Object objProgName=null;
	String strprogId;
	String strprogName;
	int validProgramCount=0;
	
	String dt_programDescription;
	String dt_programName;
	String dt_programStatus;
	
	String excelPath = "C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\LMS_valid_data.xlsx";


// **************************GET REQUEST FOR ALL PROGRAMS************************************//
@Given("Admin creates GET Request for the LMS API")
public void admin_creates_get_request_for_the_lms_api() {
	reqSpec = setReqSpecification("Valid","Valid",null);
	resSpec=setResSpecification(200);
}

@When("Admin sends Get Request with endpoint")
public void admin_sends_Get_request_with_endpoint() {
	 response = 
			RestAssured
 	.given()
 		.spec(reqSpec)
	.when()
		.get(Endpoint.Get_AllProgram)
	.then()
		.spec(resSpec)
		.extract().response();
	
	

}

@Then("Admin receives {int} OK Status with response body")
public void admin_receives_ok_status_with_response_body(Integer int1) {
	System.out.println(response.asString());
	System.out.println(response.getStatusCode());

}

//************************ GET REQUEST By PROGRAM ID(SCHEMA VALIDATION)*************************

@When("Admin sends HTTPS Request with endpoint by programid")
public void admin_sends_https_request_with_endpoint_by_programid() {
	
	objProgId = LMSTestRunner.scenarioContext.getContext("ProgramIdCreated_dt","programId");
    strprogId =String.valueOf(objProgId);
	 response = 
				RestAssured
	 	.given()
	 		.spec(reqSpec)
		.when()
			.get(Endpoint.Get_Program+strprogId)
		.then()
			.spec(resSpec)
			.extract().response();
		
}

@Then("Admin receives {int} OK Status with response body and getschema validation")
public void admin_receives_ok_status_with_response_body_and_getschema_validation(Integer int1) {
	  //response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getClass().getClassLoader().getResourceAsStream("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\GetSchema_ProgramModule.json"))); 
	  response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\GetSchema_ProgramModule.json")));
}



//**************************POST REQUEST(SCHEMA VALIDATION)************************************//
@Given("Admin creates POST Request for the LMS with request body")
public void admin_creates_post_request_for_the_lms_with_request_body(io.cucumber.datatable.DataTable dataTable) {
	
	
	
	List<Map<String,String>> list = dataTable.asMaps(String.class,String.class);
    for(Map<String,String> e: list)
		{
    	
    	dt_programDescription = e.get("programDescription");
    	dt_programName = e.get("programName");
    	dt_programStatus = e.get("programStatus");
    	requestBody = new JSONObject();
    	requestBody.put("programDescription", dt_programDescription);
    	requestBody.put("programName", dt_programName);
    	requestBody.put("programStatus", dt_programStatus);
    	System.out.println(requestBody.toJSONString());
    	
    	 
		}
    
	reqSpec = setReqSpecification("Valid","Valid",requestBody);
	resSpec=setResSpecification(201);}

@When("Admin sends HTTPS Request and  request Body with endpoint")
public void admin_sends_https_request_and_request_body_with_endpoint() {
	
	   response = RestAssured .given() .spec(reqSpec) .when()
			   .post(Endpoint.Post_CreateNewProgram) .then() .spec(resSpec)
	  .extract().response(); 
	  
		
}

@Then("Admin receives {int} CreatedStatus with response body.")
public void admin_receives_createdstatus_with_response_body(Integer int1) {
	  System.out.println(response.asString());
	  System.out.println(response.getStatusCode());	
	  JsonPath respJson = new JsonPath(response.asString());
	  //System.out.println(respJson.getInt("programId"));
	  //System.out.println(respJson.getString("programName"));
	  //System.out.println(respJson.getString("programDescription"));
	  //System.out.println(respJson.getString("programStatus"));
	  
	  LMSTestRunner.scenarioContext.setContext("ProgramIdCreated_dt", respJson.getInt("programId"));

	  assertEquals(dt_programDescription ,respJson.getString("programDescription"));
	  assertEquals( dt_programName,respJson.getString("programName"));
	  assertEquals(dt_programStatus ,respJson.getString("programStatus"));

	  response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\PostSchema_ProgramModule.json")));
	  //response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getClass().getClassLoader().getResourceAsStream("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\PostSchema_ProgramModule.json"))); 
	}

//**************************UPDATE REQUEST(SCHEMA VALIDATION)************************************//@Given("Admin creates UPDATE Request for the LMS with request body")
@Given("Admin creates UPDATE Request for the LMS with request body")

public void admin_creates_update_request_for_the_lms_with_request_body(io.cucumber.datatable.DataTable dataTable) 
{
	List<Map<String,String>> list = dataTable.asMaps(String.class,String.class);
    for(Map<String,String> e: list)
		{
    	
    	dt_programDescription = e.get("programDescription");
    	dt_programName = e.get("programName");
    	dt_programStatus = e.get("programStatus");
    	requestBody = new JSONObject();
    	requestBody.put("programDescription", dt_programDescription);
    	requestBody.put("programName", dt_programName);
    	requestBody.put("programStatus", dt_programStatus);
    	System.out.println(requestBody.toJSONString());
    	
    	 
		}
    
	reqSpec = setReqSpecification("Valid","Valid",requestBody);
	resSpec=setResSpecification(200);


}

@When("Admin sends HTTPS Request and  request Body with valid endpoint")
public void admin_sends_https_request_and_request_body_with_valid_endpoint() {
	 response = RestAssured .given() .spec(reqSpec) .when()
			 .put(Endpoint.Put_Program+dt_programName) .then() .spec(resSpec)
			  .extract().response(); 
}

@Then("Admin receives {int} OK Status with response body and Schema Validation.")
public void admin_receives_ok_status_with_response_body_and_schema_validation(Integer int1) {
	System.out.println(response.asString());
	  System.out.println(response.getStatusCode());	
	  JsonPath respJson = new JsonPath(response.asString());
	  //System.out.println(respJson.getInt("programId"));
	  //System.out.println(respJson.getString("programName"));
	  //System.out.println(respJson.getString("programDescription"));
	  //System.out.println(respJson.getString("programStatus"));
	  assertEquals(dt_programDescription ,respJson.getString("programDescription"));
	  assertEquals( dt_programName,respJson.getString("programName"));
	  assertEquals(dt_programStatus ,respJson.getString("programStatus"));

	  //response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(getClass().getClassLoader().getResourceAsStream("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\PutSchema_ProgramModule.json"))); 
	  response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\Test_Data\\PutSchema_ProgramModule.json")));
}






//#################################################################################
//############## Create Post request using excel########################
@Given("Admin creates POST Request for the LMS with request body from given sheetname {string} and rowNumber <RowNumber> as in testdata")
public void admin_creates_post_request_for_the_lms_with_request_body_from_given_sheetname_and_row_number_row_number_as_in_testdata(String string) throws InvalidFormatException, IOException {

//	String excelPath = "D:\\API_RestAssured_Team6\\Team6_RestAssuredAPI\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\testdata\\testdata.xlsx";
	String sheetName = "POST_ProgramModule";	
	
	  List<Map<String, String>> getUserData=
			  (UserExcelReader.getData(excelPath,sheetName));
	 //System.out.println(getUserData.toString());
	 // Iterate over each row of data 
	 for (Map<String, String> row : getUserData)
	 {
	  String Scenario = row.get("Scenario");
	  System.out.println(Scenario);
	  String Authorization = row.get("Authorization");
	  String endpoint = row.get("endpoint");
	  String request = row.get("request");
	  String baseURI = row.get("baseURI");
	  String programDescription = row.get("programDescription");
	  String programName = row.get("programName");
	  String programStatus = row.get("programStatus");
	  String StatusCode = row.get("StatusCode");
	   int intStatusCode=Integer.parseInt(StatusCode);  
	  
	  requestBody = new JSONObject();
		requestBody.put("programDescription", programDescription);
		requestBody.put("programName", programName);
		requestBody.put("programStatus", programStatus);
		//System.out.println(requestBody.toJSONString());
		System.out.println(requestBody.toJSONString());

		reqSpec = setReqSpecification(baseURI,Authorization,requestBody);
		resSpec=setResSpecification(intStatusCode);
		if(request.equals("POST"))
		{	
		response = RestAssured .given() .spec(reqSpec) .when()
				  .post(endpoint) .then() .spec(resSpec)
				  .extract().response();
		}
		else if(request.equals("GET"))
		{	
		response = RestAssured .given() .spec(reqSpec) .when()
				  .get(endpoint) .then() .spec(resSpec)
				  .extract().response();
		}
		//System.out.println(response.asString());
		  //System.out.println(response.getStatusCode());
		 System.out.println(response.asString());
		  if(intStatusCode==201)
		  {
			  validProgramCount++;
		  JsonPath respJson = new JsonPath(response.asString());
		 // System.out.println(respJson.getInt("programId"));
		  //System.out.println(respJson.getString("programName"));
		  //System.out.println(respJson.getString("programDescription"));
		  //System.out.println(respJson.getString("programStatus"));
		  
		  //To write program Name and Id into scenarioContext class
		  String ProgramName =respJson.getString("programName");
		  int ProgramId =respJson.getInt("programId");

		  LMSTestRunner.scenarioContext.setContext("ProgramNameCreated"+validProgramCount, ProgramName);
		  LMSTestRunner.scenarioContext.setContext("ProgramIdCreated"+validProgramCount, ProgramId);
		  

		  }
	 }
	}

@When("Admin sends HTTPS Request and request Body with endpoint as in testdata")
public void admin_sends_https_request_and_request_body_with_endpoint_as_in_testdata() {
    //response.then().log().all();
	objProgName = LMSTestRunner.scenarioContext.getContext("ProgramNameCreated2","programName");
    strprogName =String.valueOf(objProgName);
    //System.out.println(strprogName);
    objProgId = LMSTestRunner.scenarioContext.getContext("ProgramIdCreated1","programId");
    strprogId =String.valueOf(objProgId);
    //System.out.println(strprogId);
    
    

    
	
}

@Then("Admin receives Status with response body as in testdata")
public void admin_receives_status_with_response_body_as_in_testdata() {
}



//####################################################################################
//############## GET request using excel########################

@Given("Admin creates GET Request for the LMS with request body from given sheetname {string} and rowNumber <RowNumber> as in testdata")
public void admin_creates_get_request_for_the_lms_with_request_body_from_given_sheetname_and_row_number_row_number_as_in_testdata(String string) throws InvalidFormatException, IOException 
{
	//String excelPath = "D:\\API_RestAssured_Team6\\Team6_RestAssuredAPI\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\testdata\\testdata.xlsx";
	String sheetName = "GET_ProgramModule";	
	
	Object objProgId = null;
	String strprogId;
	  List<Map<String, String>> getUserData=
			  (UserExcelReader.getData(excelPath,sheetName));
	 System.out.println(getUserData.toString());
	 // Iterate over each row of data 
	 for (Map<String, String> row : getUserData)
	 {
	  String Scenario = row.get("Scenario");
	  System.out.println(Scenario);
	  String Authorization = row.get("Authorization");
	  String endpoint = row.get("endpoint");
	 
	  if(endpoint.contains("{programId}"))
	  {
		 

		    objProgId = LMSTestRunner.scenarioContext.getContext("ProgramIdCreated1","programId");
		    strprogId =String.valueOf(objProgId);
		    //System.out.println(strprogId);
		    endpoint = endpoint.replace("{programId}", strprogId);
		    //System.out.println(endpoint);

	  }
	  else if (endpoint.contains("{invalidprogramId}"))
	  {
		    endpoint = endpoint.replace("{invalidprogramId}", "1000");

	  }
	  //System.out.println(endpoint);

	  String request = row.get("request");
	  String baseURI = row.get("baseURI");
	  String StatusCode = row.get("StatusCode");
	   int intStatusCode=Integer.parseInt(StatusCode);  
	  
	  
		reqSpec = setReqSpecification(baseURI,Authorization,null);
		resSpec=setResSpecification(intStatusCode);
		if(request.equals("GET"))
		{	
		
		response = RestAssured .given() .spec(reqSpec) .when()
				  .get(endpoint) .then() .spec(resSpec)
				  .extract().response();
		
		}
		else if(request.equals("POST"))
		{	
			response = RestAssured .given() .spec(reqSpec) .when()
					  .post(endpoint) .then() .spec(resSpec)
					  .extract().response();
		}
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());	
		 
	 }
	}




//#################################################################################

//############## DELETE request using excel########################
@Given("Admin creates DELETE Request for the LMS with request body from given sheetname {string} and rowNumber <RowNumber> as in testdata")
public void admin_creates_delete_request_for_the_lms_with_request_body_from_given_sheetname_and_row_number_row_number_as_in_testdata(String string) throws InvalidFormatException, IOException 
{
	//String excelPath = "D:\\API_RestAssured_Team6\\Team6_RestAssuredAPI\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\testdata\\testdata.xlsx";
	String sheetName = "DELETE_ProgramModule";	
	
	List<Map<String, String>> getUserData=
			  (UserExcelReader.getData(excelPath,sheetName));
	 System.out.println(getUserData.toString());
	 // Iterate over each row of data 
	 for (Map<String, String> row : getUserData)
	 {
	  String Scenario = row.get("Scenario");
	  System.out.println(Scenario);
	  String Authorization = row.get("Authorization");
	  String endpoint = row.get("endpoint");
	 
	  if(endpoint.contains("{programId}"))
	  {
		  
		    objProgId = LMSTestRunner.scenarioContext.getContext("ProgramIdCreated1","programId");
		    strprogId =String.valueOf(objProgId);
		    //System.out.println(strprogId);
		    endpoint = endpoint.replace("{programId}", strprogId);
		    //System.out.println(endpoint);

	  }
	  else if (endpoint.contains("{invalidprogramId}"))
	  {
		    endpoint = endpoint.replace("{invalidprogramId}", "1000");

	  }
	  if(endpoint.contains("{programName}"))
	  {
		 
		    objProgName = LMSTestRunner.scenarioContext.getContext("ProgramNameCreated2","programName");
		    System.out.println(objProgName);
		    strprogName =String.valueOf(objProgName);
		    //System.out.println(strprogName);
		    endpoint = endpoint.replace("{programName}", strprogName);
		    //System.out.println(endpoint);

	  }
	  else if (endpoint.contains("{invalidprogramName}"))
	  {
		    endpoint = endpoint.replace("{invalidprogramName}", "Invalid");

	  }

	  //System.out.println(endpoint);

	  String request = row.get("request");
	  String baseURI = row.get("baseURI");
	  String StatusCode = row.get("StatusCode");
	   int intStatusCode=Integer.parseInt(StatusCode);  
	  
	  
		reqSpec = setReqSpecification(baseURI,Authorization,null);
		resSpec=setResSpecification(intStatusCode);
		
		response = RestAssured .given() .spec(reqSpec) .when()
				  .delete(endpoint) .then() .spec(resSpec)
				  .extract().response();
		
		
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());	
		 
	 }
	}

//#################################################################################

//############## PUT request using excel########################

@Given("Admin creates PUT Request for the LMS with request body from given sheetname {string} and rowNumber <RowNumber> as in testdata")
public void admin_creates_put_request_for_the_lms_with_request_body_from_given_sheetname_and_row_number_row_number_as_in_testdata(String string) throws InvalidFormatException, IOException {

	//String excelPath = "D:\\API_RestAssured_Team6\\Team6_RestAssuredAPI\\Users\\senth\\eclipse-workspace\\Team6_Phase2_LMSAPIRestAssured\\src\\test\\resources\\testdata\\testdata.xlsx";
	String sheetName = "PUT_ProgramModule";	
	

	  List<Map<String, String>> getUserData=
			  (UserExcelReader.getData(excelPath,sheetName));
	 //System.out.println(getUserData.toString());
	 // Iterate over each row of data 
	 for (Map<String, String> row : getUserData)
	 {
	  String Scenario = row.get("Scenario");
	  System.out.println(Scenario);
	  String Authorization = row.get("Authorization");
	  String endpoint = row.get("endpoint");
	  if(endpoint.contains("{programId}"))
	  {
		  
		    objProgId = LMSTestRunner.scenarioContext.getContext("ProgramIdCreated1","programId");
		    strprogId =String.valueOf(objProgId);
		    System.out.println(strprogId);
		    endpoint = endpoint.replace("{programId}", strprogId);
		    //System.out.println(endpoint);

	  }
	  else if (endpoint.contains("{invalidprogramId}"))
	  {
		    endpoint = endpoint.replace("{invalidprogramId}", "1000");

	  }
	  if(endpoint.contains("{programName}"))
	  {
		 //Delete below line
		  //LMSTestRunner.scenarioContext.setContext("ProgramIdCreated", 16798);

		    objProgName = LMSTestRunner.scenarioContext.getContext("ProgramNameCreated2","programName");
		    System.out.println(objProgName);
		    strprogName =String.valueOf(objProgName);
		    System.out.println(strprogName);
		    endpoint = endpoint.replace("{programName}", strprogName);
		   // System.out.println(endpoint);

	  }
	  else if (endpoint.contains("{invalidprogramName}"))
	  {
		    endpoint = endpoint.replace("{invalidprogramName}", "Invalid");

	  }

	  String request = row.get("request");
	  String baseURI = row.get("baseURI");
	  String programDescription = row.get("programDescription");
	  String programName = row.get("programName");
	  String programStatus = row.get("programStatus");
	  String StatusCode = row.get("StatusCode");
	   int intStatusCode=Integer.parseInt(StatusCode);  
	   
	 String RequestBody = row.get("RequestBody"); 
	 if(RequestBody.equals("Valid"))
	 {	 
	  requestBody = new JSONObject();
		requestBody.put("programDescription", programDescription);
		if(programName.contains("{programId}"))
		{	
			Object objName=LMSTestRunner.scenarioContext.getContext("ProgramNameCreated1","programName1");	
			programName=String.valueOf(objName);
		}
		else if (programName.contains("{programName}"))
		{
			Object objName=LMSTestRunner.scenarioContext.getContext("ProgramNameCreated2","programName");
			programName=String.valueOf(objName);

		}
		else if (programName.contains("{invalidprogramId}"))
		{
			programName="invalid";
		}
		else if (programName.contains("{invalidprogramName}"))
		{
			programName ="invalid";
		}
		requestBody.put("programName", programName);	
		requestBody.put("programStatus", programStatus);
		//System.out.println(requestBody.toJSONString());
		//LOG.info(requestBody.toJSONString());
		reqSpec = setReqSpecification(baseURI,Authorization,requestBody);

	 }
	 else 
	 {	 
			reqSpec = setReqSpecification(baseURI,Authorization,null);
	 }
	 System.out.println(requestBody);
	 	//System.out.println(reqSpec);
		resSpec=setResSpecification(intStatusCode);
		if(request.equals("PUT"))
		{	
		response = RestAssured .given() .spec(reqSpec) .when()
				  .put(endpoint) .then() .spec(resSpec)
				  .extract().response();
		}
		else if(request.equals("POST"))
		{	
		response = RestAssured .given() .spec(reqSpec) .when()
				  .post(endpoint) .then() .spec(resSpec)
				  .extract().response();
		}
		System.out.println(response.asString());
		//LOG.info(response.asString());
		  System.out.println(response.getStatusCode());	
		  if(intStatusCode==200)
		  {
		  JsonPath respJson = new JsonPath(response.asString());
		  //System.out.println(respJson.getInt("programId"));
		  //System.out.println(respJson.getString("programName"));
		  //System.out.println(respJson.getString("programDescription"));
		  //System.out.println(respJson.getString("programStatus"));
		  
		  }
	 }

}



}


