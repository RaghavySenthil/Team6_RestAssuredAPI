package usermodule3_POJO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Json_PayLoad_PUT_UModule {

	public static String createPayload_RoleID(Map<String, String> row) {
		System.out.println("inside create_roleid class");
		PUT_RoleID_UM3_POJO putrequest_userByRoleId= new PUT_RoleID_UM3_POJO();
        String userRoleList=row.get("userRoleList");
        String[] userRoleArray;
        
        if(userRoleList != null && userRoleList.contains(",")) {
        userRoleArray = userRoleList.split(",");
        
        }else {
        	userRoleArray=new String[] {userRoleList};
        }
     // Filter out null elements from userRoleArray to handle null pointer exception for null userrolelist from testdata
        List<String> NonNullUserRoleList = Arrays.stream(userRoleArray)
                .filter(Objects::nonNull) 
                .collect(Collectors.toList());
   	 putrequest_userByRoleId.setUserRoleList(NonNullUserRoleList);
 	System.out.println("the user role id list is"+userRoleArray);
        
		try{
		 ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.writeValueAsString(putrequest_userByRoleId);
		
	}catch (Exception e) {
	    e.printStackTrace();
	
            return null; // Return null if an error occurs during JSON serialization
        }
}
	public static String createPayload_RoleStatus(Map<String, String> row) {
		System.out.println("inside create_rolestatus class");
		PUT_UserRoleStatus_UM3_POJO put_userByRolestatus= new PUT_UserRoleStatus_UM3_POJO();
        String roleId=row.get("roleId");
        String userRoleStatus=row.get("userRoleStatus");
       
        put_userByRolestatus.setRoleId(roleId);
        put_userByRolestatus.setUserRoleStatus(userRoleStatus);
 	
        
		try{
		 ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.writeValueAsString(put_userByRolestatus);
		
	}catch (Exception e) {
	    e.printStackTrace();
	
            return null; // Return null if an error occurs during JSON serialization
        }
}
	public static String createPayload_userloginstatus(Map<String, String> row) {
		System.out.println("inside createPayload_userloginstatus class");
		PUT_UserLoginStatus_UM3_POJO put_userByLoginstatus= new PUT_UserLoginStatus_UM3_POJO();
		// read the values from excel sheet
        String loginStatus=row.get("loginStatus");
        String password=row.get("password");
        String roleIds=row.get("roleIds");
        String[] userRoleIDArray;
        if(roleIds != null && roleIds.contains(",")) {
         userRoleIDArray = roleIds.split(",");
        }else {
        	userRoleIDArray= new String[] {roleIds};
        }
        // Filter out null elements from userRoleIDArray to handle null pointer exception for null userroleIDS from testdata
        List<String> NonNullUserRoleIds = Arrays.stream(userRoleIDArray)
                .filter(Objects::nonNull) 
                .collect(Collectors.toList());
   	
        String status=row.get("status");
        String userLoginEmail=row.get("userLoginEmail");
       // assign the values to POJO
        if(loginStatus != null && !loginStatus.isEmpty()) {
        put_userByLoginstatus.setLoginStatus(loginStatus);
        }
        if( password != null && !password.isEmpty()) {
        put_userByLoginstatus.setPassword(password);}
        
        put_userByLoginstatus.setRoleIds(NonNullUserRoleIds);
        if(status != null && !status.isEmpty()) { 
        put_userByLoginstatus.setStatus(status);}
        if(userLoginEmail != null && !userLoginEmail.isEmpty()) {
        put_userByLoginstatus.setUserLoginEmail(userLoginEmail);
        }
		try{
		 ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.writeValueAsString(put_userByLoginstatus);
		
	}catch (Exception e) {
	    e.printStackTrace();
	
            return null; // Return null if an error occurs during JSON serialization
        }
}
	public static String createPayload_URPBS(Map<String, String> row) {
		  
		System.out.println("inside createPayload_URPBS class");
		PUT_URPBS_UM3_POJO putrequest_userByURPBS= new PUT_URPBS_UM3_POJO();
		
		
        String programIdString=row.get("programId");
        if(programIdString != null ) {
        int programId = Integer.parseInt(programIdString);
        putrequest_userByURPBS.setProgramId(programId);
        }
        String roleId=row.get("roleId");
        putrequest_userByURPBS.setRoleId(roleId);
        
       
 List<UserRoleProgramBatch> userRoleProgramBatches = new ArrayList<>();
        
        UserRoleProgramBatch URPBS= new UserRoleProgramBatch();
        String batchIdstring = row.get("batchId");
        
        if(batchIdstring != null) {
        int batchId = Integer.parseInt(batchIdstring);
         URPBS.setBatchId(batchId);
        }
        
        String status = row.get("userRoleProgramBatchStatus");
        
        if(status != null) {
        URPBS.setUserRoleProgramBatchStatus(status);
        }
        userRoleProgramBatches.add(URPBS);
        putrequest_userByURPBS.setUserRoleProgramBatches(userRoleProgramBatches);
        

       		try{
		 ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.writeValueAsString(putrequest_userByURPBS);
		
	}catch (Exception e) {
	    e.printStackTrace();
	
            return null; 
        }
}
}
