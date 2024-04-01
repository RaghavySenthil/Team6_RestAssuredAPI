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
	//	public static String Get_AllActiveUsers = "/users/activeUsers";

public static RequestSpecification AllActiveusers() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Get_AllActiveUsers);
	req.setContentType(ContentType.JSON);
	return res;
}
//	public static String Get_UserbyProgramBatches = "/users/programBatch/{Id}";

public static RequestSpecification Getuserbyprogrambatches() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Get_UserbyProgramBatches);
	req.setContentType(ContentType.JSON);
	return res;
}
//	public static String Get_UsersforProgram = "/users/programs/{programId}";

public static RequestSpecification Getusersforprogram() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Get_UsersforProgram);
	req.setContentType(ContentType.JSON);
	return res;
}

	//public static String Get_UsersbyroleId  = "/users/roles/{roleId}";

	public static RequestSpecification Getusersbyroleid() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Get_UsersbyroleId);
	req.setContentType(ContentType.JSON);
	return res;
}
	
	//	public static String Get_UsersbyroleId_V2	= "/v2/users";

public static RequestSpecification Getusersbyroleidv2() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.Get_UsersbyroleId_V2);
	req.setContentType(ContentType.JSON);
	return res;
}

//public static String PUT_UpdateUser = "/users/{userId}";

public static RequestSpecification Updateuserbyuserid() {
	
	
	req.setBaseUri(Endpoint.BaseURL);
	RequestSpecification res = req.build();
	req.setBasePath(Endpoint.PUT_UpdateUser);
	req.setContentType(ContentType.JSON);
	return res;
}

	/*private static RequestSpecBuilder req = new RequestSpecBuilder()
            .setBaseUri(Endpoint.BaseURL)
            .setContentType(ContentType.JSON);

    public static RequestSpecification UserLogin() {
        return req.setBasePath(Endpoint.Post_Login).build();
    }*/

    /*public static RequestSpecification InvalidGetAllUser() {
        return req.setBasePath(Endpoint.NegativeGET_AllUsers).build();
    }

    public static RequestSpecification PostValidData() {
        return req.setBasePath(Endpoint.Post_CreateUser).build();
    }

    public static RequestSpecification PostINValidData() {
        return req.setBasePath(Endpoint.Post_CreateUser).build();
    }

    public static RequestSpecification GetUserbyID() {
        return req.setBasePath(Endpoint.GET_userbyUSER_ID).build();
    }

    public static RequestSpecification GET_userbyFN() {
        return req.setBasePath(Endpoint.GET_userbyFN).build();
    }

    public static RequestSpecification DeleteByUserID() {
        return req.setBasePath(Endpoint.Delete_UserByuserID).build();
    }

    public static RequestSpecification DeleteByName() {
        return req.setBasePath(Endpoint.Delete_UserByuserFN).build();
    }

    public static RequestSpecification Putvaliddata() {
        return req.setBasePath(Endpoint.PUT_Updateuser).build();
    }*/
}

