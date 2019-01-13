package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursements;

public interface ReimbursementsDAO {
	List <Reimbursements> view(int id);
	List <Reimbursements> viewAll();
	void submit(int emplid, int reimbid, String description, double amount, String status);
	void update(int id);
	void approve(int id);
	void addImage(int id);
}
