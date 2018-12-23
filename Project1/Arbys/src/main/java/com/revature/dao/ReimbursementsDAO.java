package com.revature.dao;

import com.revature.beans.Reimbursements;

public interface ReimbursementsDAO {
	Reimbursements view(int id);
	void submit(int id);
	void update(int id);
	boolean approve(int id);
	void addImage(int id);
}
