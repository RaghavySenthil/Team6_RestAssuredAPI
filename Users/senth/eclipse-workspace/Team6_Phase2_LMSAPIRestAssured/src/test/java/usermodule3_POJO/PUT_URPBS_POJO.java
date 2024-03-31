package usermodule3_POJO;

import java.util.List;

public class PUT_URPBS_POJO {

	private int programId;
	private String roleId;
	private List<UserRoleProgramBatch> userRoleProgramBatches;


	public int getProgramId() {
		return programId;
	}


	public void setProgramId(int programId) {
		this.programId = programId;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	 public List<UserRoleProgramBatch> getUserRoleProgramBatches() {
	        return userRoleProgramBatches;
	    }
	 public void setUserRoleProgramBatches(List<UserRoleProgramBatch> userRoleProgramBatches) {
	        this.userRoleProgramBatches = userRoleProgramBatches;
	    }
}

	class UserRoleProgramBatch{
		
		private int batchId;
		private String userRoleProgramBatchStatus;
		
		public int getBatchId() {
	        return batchId;
	    }

	    public void setBatchId(int batchId) {
	        this.batchId = batchId;
	    }

	    public String getUserRoleProgramBatchStatus() {
	        return userRoleProgramBatchStatus;
	    }

	    public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
	        this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	    }
		
	}
	
	

