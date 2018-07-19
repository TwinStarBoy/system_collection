package crm_mgr_test.com.apis.permission;

import java.util.List;
import java.util.UUID;

import crm_mgr_test.com.apis.permission.PermissionStatus.GetAllUserNameEnum;
import crm_mgr_test.domain.Manager;

public class MGetAllUsersAns {
	private String messageid;
	private UUID requestid;
	
	private List<Manager> managers;
	
	private GetAllUserNameEnum status;

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public UUID getRequestid() {
		return requestid;
	}

	public void setRequestid(UUID requestid) {
		this.requestid = requestid;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public GetAllUserNameEnum getStatus() {
		return status;
	}

	public void setStatus(GetAllUserNameEnum status) {
		this.status = status;
	}
	
	
}
