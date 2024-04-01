package EndPoints;

public final class Endpoint {

	public static final String BaseURL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static final String PUT_USER_ROLE_STATUS = BaseURL + "/users/roleStatus/{userID}";
	public static final String PUT_USER_ROLEID = BaseURL + "/users/roleId/{userID}";
	public static final String PUT_URPBS = BaseURL + "/users/roleProgramBatchStatus/{userId}";
	public static final String PUT_LOGIN_STATUS = BaseURL + "/users/userLogin/{userId}";
	public static final String DELETE_USER_BYID = BaseURL + "/users/{userID} ";
	public static final String PUT_USER_ROLEID_INVALID_ENDPOINT = BaseURL + "/users/roleId///{userID}";
	public static final String PUT_USER_ROLE_STATUS_INVALID_ENDPOINT = BaseURL + "/users/roleStatus///{userID}";
	public static final String PUT_LOGIN_STATUS_INVALID_ENDPOINT = BaseURL + "/users/userLogin///{userId}";
	public static final String PUT_URPBS_INVALID_ENDPOINT = BaseURL + "/users/roleProgramBatchStatus///{userId}";
	// User Login--endpoint
	public static String Post_Login = "/login";
	public static String Post_CreatingUserwithRole = "/users/roleStatus";
	public static String Post_Login_invalidendpoint = "/loginpage";
	public static String Excelpath = ".\\src\\test\\resources\\Test_Data\\LMS_valid_data.xlsx";
	public static String Get_AllRoles = "/users/roles";
	public static String Get_AllRoles_invalid = "/usersrolesinvalid";
	public static String Get_AllUsers = "/users";
	public static String Get_AllUsers_invalid = "/usersinvalid";
	public static String Get_Userby_Userid = "/users/{id}";
	public static String Get_Userby_Userid_invalid = "/usersinvalid/{id}";
	public static String Get_AllUsers_withRoles = "/roles";
	public static String Get_AllUsers_withRoles_invalid = "/rolesinvalid";
	public static String Get_Users_RoleStatus = "/users/byStatus/";
	public static String Get_Users_RoleStatus_invalid = "/users/Status/";
}
