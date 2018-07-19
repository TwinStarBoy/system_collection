package crm_mgr_test.com.apis.permission;

import java.util.UUID;

import crm_mgr_test.com.apis.permission.PermissionStatus.UpdatePermissionEnum;

public class MUpdatePermissionAns {
	private String messageid;
	private UUID requestid;
	private int userId;
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
	
	private UpdatePermissionEnum status;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public UpdatePermissionEnum getStatus() {
		return status;
	}

	public void setStatus(UpdatePermissionEnum status) {
		this.status = status;
	}

}
