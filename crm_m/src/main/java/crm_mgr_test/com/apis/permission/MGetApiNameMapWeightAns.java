package crm_mgr_test.com.apis.permission;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import crm_mgr_test.com.apis.permission.PermissionStatus.GetApiNameMapWeightEnum;

public class MGetApiNameMapWeightAns {
	private String messageid;
	private UUID requestid;
	private List<Map<String,Long>> list;
	
	private GetApiNameMapWeightEnum status;

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

	public List<Map<String, Long>> getList() {
		return list;
	}

	public void setList(List<Map<String, Long>> list) {
		this.list = list;
	}

	public GetApiNameMapWeightEnum getStatus() {
		return status;
	}

	public void setStatus(GetApiNameMapWeightEnum status) {
		this.status = status;
	}
	
}
