package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	private static final String filename = "connection.properties";

	@Override
	public Reimbursements view(int id) {
		Reimbursements reimb = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			System.out.println("Connection successful");
			String sql = "SELECT *" + "FROM REIMBURSEMENTS" + "WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int ReimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String ReimbursementDescription = rs.getString("REIMBURSEMENT_DESCRIPTION");
				double ReimbursementAmount = rs.getDouble("REIMBURSEMENT_AMOUNT");
				Blob ReimbursementImage = rs.getBlob("REIMBURSEMENT_IMG");
				String ReimbursementStatus = rs.getString("REIMBURSEMENT_STATUS");
				reimb = new Reimbursements(ReimbursementId, ReimbursementDescription, ReimbursementAmount,
						ReimbursementImage, ReimbursementStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reimb;

	}

	@Override
	public void submit(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean approve(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addImage(int id) {
		
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENTS SET REIMBURSEMENT_IMAGE = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			File blob = new File("C:\\Users\\kjaeger123\\sweaterKaleigh.jpg");
			FileInputStream fileBlob = new FileInputStream(blob); 
			pstmt.setBinaryStream(1, fileBlob);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate(); 
			System.out.println("Successfully uploaded image");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
