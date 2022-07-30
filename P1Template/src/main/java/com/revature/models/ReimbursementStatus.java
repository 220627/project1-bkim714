package com.revature.models;

public class ReimbursementStatus {

	private int status_id;
	private String status;
	
	
	
	public ReimbursementStatus() {
		super();
	}



	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}



	public ReimbursementStatus(int status_id, String status) {
		super();
		this.status_id = status_id;
		this.status = status;
	}



	@Override
	public String toString() {
		return "ReimbursementStatus [status_id=" + status_id + ", status=" + status + "]";
	}



	public int getStatus_id() {
		return status_id;
	}



	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
