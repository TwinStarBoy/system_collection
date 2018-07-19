package crm_mgr_test.domain;

public class Permission {
	private int id;
	private int userId;
	private long permissionCode;

	private int scanAllCustomers;
	private int scanCustomerPosition;
	private int createCustomer;
	private int updateCustomer;
	private int limitCustomerTrade;
	private int limitCustomerDepositWithdraw;
	private int updateCustomerOrders;
	private int createOrder;
	private int deleteOrder;
	private int scanOpratorLog;
	//除了admin之外，所有人都是0。数据库表字段某认是0。使用mybatis操作数据库记录时，不能用这个字段。但是计算权限的时候必须使用这个字段
	private int manageUser;
	private String loginname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(long permissionCode) {
		this.permissionCode = permissionCode;
	}

	public int getScanAllCustomers() {
		return scanAllCustomers;
	}

	public void setScanAllCustomers(int scanAllCustomers) {
		this.scanAllCustomers = scanAllCustomers;
	}

	public int getScanCustomerPosition() {
		return scanCustomerPosition;
	}

	public void setScanCustomerPosition(int scanCustomerPosition) {
		this.scanCustomerPosition = scanCustomerPosition;
	}

	public int getCreateCustomer() {
		return createCustomer;
	}

	public void setCreateCustomer(int createCustomer) {
		this.createCustomer = createCustomer;
	}

	public int getUpdateCustomer() {
		return updateCustomer;
	}

	public void setUpdateCustomer(int updateCustomer) {
		this.updateCustomer = updateCustomer;
	}

	public int getLimitCustomerTrade() {
		return limitCustomerTrade;
	}

	public void setLimitCustomerTrade(int limitCustomerTrade) {
		this.limitCustomerTrade = limitCustomerTrade;
	}

	public int getLimitCustomerDepositWithdraw() {
		return limitCustomerDepositWithdraw;
	}

	public void setLimitCustomerDepositWithdraw(int limitCustomerDepositWithdraw) {
		this.limitCustomerDepositWithdraw = limitCustomerDepositWithdraw;
	}

	public int getUpdateCustomerOrders() {
		return updateCustomerOrders;
	}

	public void setUpdateCustomerOrders(int updateCustomerOrders) {
		this.updateCustomerOrders = updateCustomerOrders;
	}

	public int getCreateOrder() {
		return createOrder;
	}

	public void setCreateOrder(int createOrder) {
		this.createOrder = createOrder;
	}

	public int getDeleteOrder() {
		return deleteOrder;
	}

	public void setDeleteOrder(int deleteOrder) {
		this.deleteOrder = deleteOrder;
	}

	public int getScanOpratorLog() {
		return scanOpratorLog;
	}

	public void setScanOpratorLog(int scanOpratorLog) {
		this.scanOpratorLog = scanOpratorLog;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public int getManageUser() {
		return manageUser;
	}

	public void setManageUser(int manageUser) {
		this.manageUser = manageUser;
	}

}
