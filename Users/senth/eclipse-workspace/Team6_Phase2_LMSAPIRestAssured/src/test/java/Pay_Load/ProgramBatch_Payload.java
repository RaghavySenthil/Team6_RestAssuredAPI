package Pay_Load;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.fasterxml.jackson.databind.ObjectMapper;

import EndPoints.Endpoint;
import Pojo_Class.ProgramBatch_Pojo;
import StepDefinition.Program_Module;
import Utilities.UserExcelReader;

public class ProgramBatch_Payload {
	int programId= Program_Module.createdprogramID;
	String programName=Program_Module.createdprogramName;
	public static String Data() throws Exception {
	ProgramBatch_Pojo Data = new ProgramBatch_Pojo(); 
	
	List<Map<String, String>> getUserData;

		getUserData = (UserExcelReader.getData(Endpoint.Excelpath, "Batchmodule_validData"));
	
	// Iterate over each row of data
	 for (Map<String, String> row : getUserData){
		String batchDescription = row.get("batchDescription");
		String batchName = row.get("batchName");
		String batchNoOfClasses = row.get("batchNoOfClasses");
		long batchNoOfClasses1 =Long.parseLong(batchNoOfClasses);
		String batchStatus = row.get("batchStatus");
		String programId = row.get("programId");
		long programId1 =Long.parseLong(programId);
		String programName = row.get("programName");

		Data.setBatchDescription(batchDescription);
		Data.setBatchName(batchName);
		Data.setBatchNoOfClasses(batchNoOfClasses1);
		Data.setBatchStatus(batchStatus);
		Data.setProgramId(programId1);
		Data.setProgramName(programName);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(Data);
		System.out.println("Payload:"+json);
		return json ;
		
	 }
	 return null;
}
	}