package com.blackjade.crm.apis.customer;

public class CSendVerifyEmailAns {
	private String requestid;
	private String messageid;
	private int clientid;
	
	private Enum<?> status;

	public CSendVerifyEmailAns (){
		this.messageid = "0x0024";
	}
	
	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public Enum<?> getStatus() {
		return status;
	}

	public void setStatus(Enum<?> status) {
		this.status = status;
	}
	
	
}
