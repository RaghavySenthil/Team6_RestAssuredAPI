package TestRequest;

import java.util.Properties;

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
}
