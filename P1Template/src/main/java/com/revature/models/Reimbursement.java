package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {

	private int reimb_id;
	private int amount;
	private Timestamp submitted;
	private int author_fk;
	private int resolver_fk;
	private int status_id_fk;
	private int type_id_fk;
	
	
	public Reimbursement(int reimb_id, int amount, Timestamp submitted, int author_fk, int resolver_fk,
			int status_id_fk, int type_id_fk) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.submitted = submitted;
		this.author_fk = author_fk;
		this.resolver_fk = resolver_fk;
		this.status_id_fk = status_id_fk;
		this.type_id_fk = type_id_fk;
	}


	public Reimbursement(int amount, Timestamp submitted, int author_fk, int resolver_fk, int status_id_fk,
			int type_id_fk) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.author_fk = author_fk;
		this.resolver_fk = resolver_fk;
		this.status_id_fk = status_id_fk;
		this.type_id_fk = type_id_fk;
	}
	
	
	public Reimbursement(int amount, Timestamp submitted, int type_id_fk) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.type_id_fk = type_id_fk;
	}


	public Reimbursement(int amount, Timestamp submitted) {
		super();
		this.amount = amount;
		this.submitted = submitted;
	}


//	public Reimbursement(int reimb_id, int amount, Timestamp submitted) {
//		super();
//		this.reimb_id = reimb_id;
//		this.amount = amount;
//		this.submitted = submitted;
//	}


	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", amount=" + amount + ", submitted=" + submitted
				+ ", author_fk=" + author_fk + ", resolver_fk=" + resolver_fk + ", status_id_fk=" + status_id_fk
				+ ", type_id_fk=" + type_id_fk + "]";
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Timestamp getSubmitted() {
		return submitted;
	}


	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}


	public int getAuthor_fk() {
		return author_fk;
	}


	public void setAuthor_fk(int author_fk) {
		this.author_fk = author_fk;
	}


	public int getResolver_fk() {
		return resolver_fk;
	}


	public void setResolver_fk(int resolver_fk) {
		this.resolver_fk = resolver_fk;
	}


	public int getStatus_id_fk() {
		return status_id_fk;
	}


	public void setStatus_id_fk(int status_id_fk) {
		this.status_id_fk = status_id_fk;
	}


	public int getType_id_fk() {
		return type_id_fk;
	}


	public void setType_id_fk(int type_id_fk) {
		this.type_id_fk = type_id_fk;
	}
	
	
	
}
