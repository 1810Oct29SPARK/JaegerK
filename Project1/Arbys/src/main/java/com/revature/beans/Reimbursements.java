package com.revature.beans;

import java.sql.Blob;

public class Reimbursements {

	private int id;
	private String description;
	private double amount;
	private Blob img;
	private String status;
	
	public Reimbursements(int id, String description, double amount, Blob img, String status) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.img = img;
		this.status = status;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Reimbursements [id=" + id + ", description=" + description + ", amount=" + amount + ", img=" + img
				+ ", status=" + status + "]";
	}

}
