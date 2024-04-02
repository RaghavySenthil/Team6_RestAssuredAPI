package TestRequest;
import EndPoints.Endpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LMSReqspec {

    private static RequestSpecBuilder req = new RequestSpecBuilder()
            .setBaseUri(Endpoint.BaseURL)
            .setContentType(ContentType.JSON);

    public static RequestSpecification update_UserRoleStatus() {
        return req.setBasePath(Endpoint.PUT_USER_ROLE_STATUS).build();
    }
    public static RequestSpecification update_URPBS () {
        return req.setBasePath(Endpoint.PUT_URPBS).build();
    }
    public static RequestSpecification Update_UserLoginStatus() {
        return req.setBasePath(Endpoint.PUT_LOGIN_STATUS).build();
    }
    public static RequestSpecification Update_UserRoleID () {
        return req.setBasePath(Endpoint.PUT_USER_ROLEID).build();
    }

    public static RequestSpecification DeleteByUserID() {
        return req.setBasePath(Endpoint.DELETE_USER_BYID).build();
    }
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


public static RequestSpecification UserLogin_invalidendpoint() {

	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Post_Login_invalidendpoint);
	req.setContentType(ContentType.JSON);

	return res;
}


public static RequestSpecification GetAllRoles() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_AllRoles);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetAllRoles_invalidendpoint() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_AllRoles_invalid);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetAllUsers() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_AllUsers);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetAllUsers_invalidendpoint() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_AllUsers_invalid);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetUserby_Userid() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_Userby_Userid);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetUserby_Userid_invalidendpoint() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_Userby_Userid_invalid);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetAllUsers_withRoles() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_AllUsers_withRoles);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification GetAllUsers_withRoles_invalidendpoint() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_AllUsers_withRoles_invalid);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification Get_Users_RoleStatus() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_Users_RoleStatus);
req.setContentType(ContentType.JSON);
return res;
}

public static RequestSpecification Get_Users_RoleStatus_invalidendpoint() {


req.setBaseUri(Endpoint.BaseURL);
RequestSpecification res = req.build();
req.setBasePath(Endpoint.Get_Users_RoleStatus_invalid);
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
public static RequestSpecification User_logout() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.User_logout);
	req.setContentType(ContentType.JSON);
	return res;
}

public static RequestSpecification User_logout_invalidendpoint() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.User_logout_invalid);
	req.setContentType(ContentType.JSON);
	return res;
}


}