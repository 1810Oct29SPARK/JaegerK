package com.revature.dao;

import java.sql.SQLException;

public interface LoginDAO {
	int login(String username, String password) throws SQLException;
	void signout(String username, String password) throws SQLException;
	void updatePassword(int id, String password) throws SQLException;
}
