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



}
