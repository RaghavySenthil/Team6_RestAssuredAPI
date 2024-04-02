package TestRequest;

import org.json.simple.JSONObject;

import StepDefinition.UserLoginController;
import TestRunner.LMSTestRunner;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecification {
	RequestSpecBuilder reqSpeBuilder;
	public RequestSpecification reqSpec;
	public ResponseSpecification responseSpecification;
	//String retrievedToken=UserLoginController.token;

	//String token; 
	//Object retrievedToken =LMSTestRunner.scenarioContext.getContext("Token", token);
	//String RetrievedToken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJudW1weW5pbmphQGdtYWlsLmNvbSIsImlhdCI6MTcxMTk3OTk1NSwiZXhwIjoxNzEyMDA4NzU1fQ.piNH5Max6v3ZHZa04EOzu1FisbdD3jezT58jkPWMUqNAxff0MyULTEfTFuZmLYaTYtRXjG-cAfaVBYEUVQ7j3g";
	String RetrievedToken=UserLoginController.token;
	String validURI="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	String invalidURI="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/ls";
	
	public RequestSpecification setReqSpecification(String baseURI,String auth,JSONObject requestBody) {
		reqSpeBuilder = new RequestSpecBuilder();
		reqSpeBuilder.setContentType("application/json");
		//BaseURI
		if(baseURI.equals("Valid"))
			reqSpeBuilder.setBaseUri(validURI);
		else if (baseURI.equals("Invalid"))
			reqSpeBuilder.setBaseUri(invalidURI);

		//Authorization
		if(auth.equals("Valid"))
		reqSpeBuilder.setAuth(RestAssured.oauth2(RetrievedToken));
		
		else if (auth.equals("NoAuth"))
		
			reqSpeBuilder.setAuth(RestAssured.DEFAULT_AUTH);
		
		else
			System.out.println("Proper authorization is not specified.....");
		//RequestBody
		if(requestBody!=null)
			reqSpeBuilder.setBody(requestBody);	

		reqSpec = reqSpeBuilder.build();
		//System.out.println(reqSpec.toString());
		
		return reqSpec;
		}
	public ResponseSpecification setResSpecification(int statusCode) {
				// Create a ResponseSpecification 
				responseSpecification=  RestAssured.expect();
				//responseSpecification.contentType(ContentType.JSON);
				return responseSpecification.statusCode(statusCode);
				

	}
}

