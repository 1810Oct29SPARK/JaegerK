package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	private static final String filename = "connection.properties";

	@Override
	public List<Reimbursements> view(int id) {
		List<Reimbursements> reimb = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
//			System.out.println("Connection successful");
			String sql = "SELECT *" + "FROM REIMBURSEMENTS " + "WHERE EMPLOYEE_ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int ReimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String ReimbursementDescription = rs.getString("REIMBURSEMENT_DESCRIPTION");
				double ReimbursementAmount = rs.getDouble("REIMBURSEMENT_AMOUNT");
//				Blob ReimbursementImage = rs.getBlob("REIMBURSEMENT_IMAGE");
				String ReimbursementStatus = rs.getString("REIMBURSEMENT_STATUS");
				Reimbursements r = new Reimbursements(ReimbursementId, ReimbursementDescription, ReimbursementAmount,
						ReimbursementStatus);
				reimb.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("Reimbursement List: " + reimb);
		return reimb;

	}

	@Override
	public void submit(int emplid, int reimbid, String description, double amount, String status) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
//			System.out.println("Connection successful");
			String sql = "INSERT INTO REIMBURSEMENTS VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emplid);
			pstmt.setInt(2, reimbid);
			pstmt.setString(3, description);
			pstmt.setDouble(4, amount);
			pstmt.setString(5, null);
			pstmt.setString(6, status);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void approve(int id) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
//			System.out.println("Connection successful");
			String sql = "UPDATE REIMBURSEMENTS SET REIMBURSEMENT_STATUS = 'APPROVED' WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reimbursements> viewAll() {
		List<Reimbursements> reimb = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
//			System.out.println("Connection successful");
			String sql = "SELECT *" + "FROM REIMBURSEMENTS ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int ReimbursementId = rs.getInt("REIMBURSEMENT_ID");
				String ReimbursementDescription = rs.getString("REIMBURSEMENT_DESCRIPTION");
				double ReimbursementAmount = rs.getDouble("REIMBURSEMENT_AMOUNT");
//				Blob ReimbursementImage = rs.getBlob("REIMBURSEMENT_IMAGE");
				String ReimbursementStatus = rs.getString("REIMBURSEMENT_STATUS");
				Reimbursements r = new Reimbursements(ReimbursementId, ReimbursementDescription, ReimbursementAmount,
						ReimbursementStatus);
				reimb.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("Reimbursement List: " + reimb);
		return reimb;

	}

}
