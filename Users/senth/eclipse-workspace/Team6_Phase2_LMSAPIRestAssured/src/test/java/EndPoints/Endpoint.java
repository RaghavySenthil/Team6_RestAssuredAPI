package EndPoints;

public final class Endpoint {

	public static final String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static final String PUT_USER_ROLE_STATUS= BaseURL +"/users/roleStatus/{userID}";
	public static final String PUT_USER_ROLEID= BaseURL +"/users/roleId/{userID}";
	public static final String PUT_URPBS= BaseURL + "/users/roleProgramBatchStatus/{userId}";
	public static final String PUT_LOGIN_STATUS = BaseURL + "/users/userLogin/{userId}";
	public static final String DELETE_USER_BYID= BaseURL + "/users/{userID} ";
	public static final String PUT_USER_ROLEID_INVALID_ENDPOINT= BaseURL +"/users/roleId///{userID}";
	public static final String PUT_USER_ROLE_STATUS_INVALID_ENDPOINT= BaseURL +"/users/roleStatus///{userID}";
	public static final String PUT_LOGIN_STATUS_INVALID_ENDPOINT = BaseURL + "/users/userLogin///{userId}";
	//User Login--endpoint
		public static String Post_Login= "/login";
		//User Module--Endpoints
		public static String Post_CreatingUserwithRole= "/users/roleStatus";
		public static String Excelpath = ".\\src\\test\\resources\\Test_Data\\LMS_valid_data.xlsx";
}
