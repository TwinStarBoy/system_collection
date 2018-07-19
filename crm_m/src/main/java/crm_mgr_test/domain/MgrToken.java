package crm_mgr_test.domain;

import java.io.Serializable;
import java.util.UUID;

public class MgrToken implements Serializable{

	private int managerid;
	private UUID token;
	
	
	public MgrToken(int managerid, UUID token) {
		this.managerid = managerid;
		this.token = token;
	}
	
	public int getManagerid() {
		return managerid;
	}
	
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	
	public UUID getToken() {
		return token;
	}
	
	public void setToken(UUID token) {
		this.token = token;
	}
	
}
