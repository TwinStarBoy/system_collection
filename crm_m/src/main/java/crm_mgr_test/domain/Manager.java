package crm_mgr_test.domain;

public class Manager {

	private int	managerid;
	private String loginname;
	private String password;
	private String email;
	private String privillege;
	
	private Long permissionCode;
	
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrivillege() {
		return privillege;
	}
	public void setPrivillege(String privillege) {
		this.privillege = privillege;
	}
	public Long getPermissionCode() {
		return permissionCode;
	}
	public void setPermissionCode(Long permissionCode) {
		this.permissionCode = permissionCode;
	}
	
	
}
