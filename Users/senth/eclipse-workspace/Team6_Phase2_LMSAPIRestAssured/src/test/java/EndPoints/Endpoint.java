package EndPoints;
import Utilities.ConfigReader;

public class Endpoint extends ConfigReader{
	
	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	/*public static String username = prop.getProperty("username");
	public static String Password = prop.getProperty("Password");*/
	
	//Program Batch Module--Endpoints
	public static String Post_CreateNewBatch = "/batches";
	public static String GET_AllBatches = "/batches";
	public static String NegativeGET_AllBatches = "/batches1";
	public static String GET_BatchbyBatchId = "/batches/batchId/{batchId}";
	public static String GET_BatchbyBatchName = "/batches/batchName/{batchName}";
	public static String GET_BatchbyProgramId = "/batches/program/{programId}";
	public static String PUT_UpdatebyBatch_Id = "/batches/{batchId}";
	public static String Delete_batchbyBatchId = "/batches/{id}";
	
	//User Module--Endpoints
	public static String Post_CreatingUserwithRole= "/users/roleStatus";
	
	
	//User Login--endpoint
	public static String Post_Login= "/login";
		
	public static String Excelpath = ".\\src\\test\\resources\\Test_Data\\LMS_valid_data.xlsx";
	}
//C:\Users\senth\eclipse-workspace\Team6_Phase2_LMSAPIRestAssured\src\test\resources\Test_Data\LMS_valid_data.xlsx
