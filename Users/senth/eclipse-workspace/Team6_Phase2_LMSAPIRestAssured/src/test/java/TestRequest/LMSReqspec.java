package TestRequest;
import java.util.Properties;

import EndPoints.Endpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LMSReqspec {
	static RequestSpecBuilder req = new RequestSpecBuilder();
    static Properties prop;
	
	public static RequestSpecification UserLogin() {
	
		
		req.setBaseUri(Endpoint.BaseURL);
		RequestSpecification res = req.build();
		req.setBasePath(Endpoint.Post_Login);
		req.setContentType(ContentType.JSON);
	
		return res;
	}
	
public static RequestSpecification PostValidData() {
		
		
		req.setBaseUri(Endpoint.BaseURL);
		RequestSpecification res = req.build();
		req.setBasePath(Endpoint.Post_CreatingUserwithRole);
		req.setContentType(ContentType.JSON);
		return res;
	}
public static RequestSpecification BatchModulePostValidData() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Post_CreateNewBatch);
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification Batchmoduleexistingdata() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Post_CreateNewBatch);
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification Invalidendpoint_Batches() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Invalidendpoint_Batches);
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification GetAllbatch() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.GET_AllBatches);
	req.setContentType(ContentType.JSON);
	return res;
}

public static RequestSpecification getInvalidendpoint_Batches() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Invalidendpoint_Batches);
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification GET_BatchbyBatchId() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.GET_BatchbyBatchId);
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification Delete_BatchbyBatchId() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Delete_batchbyBatchId);
	req.setContentType(ContentType.JSON);
	return res;
}

public static RequestSpecification Delete_InvalidBatchbyBatchId() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Delete_InvalidBatchbyBatchId);
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification Delete_InvalidBatchId() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Delete_InvalidBatchId);
	req.setContentType(ContentType.JSON);
	return res;
}

public static RequestSpecification GET_BatchbyBatchName() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.GET_BatchbyBatchName);
	
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification GET_BatchbyPgmID() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.GET_BatchbyProgramId);
	
	req.setContentType(ContentType.JSON);
	return res;
}
public static RequestSpecification Put_batchID() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.PUT_UpdatebyBatch_Id);
	
	req.setContentType(ContentType.JSON);
	return res;
}







}