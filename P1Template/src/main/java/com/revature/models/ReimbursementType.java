package com.revature.models;

public class ReimbursementType {

	private int type_id;
	private String type;
	
	
	
	public ReimbursementType() {
		super();
	}

	public ReimbursementType(String type) {
		super();
		this.type = type;
	}

	public ReimbursementType(int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [type_id=" + type_id + ", type=" + type + "]";
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
