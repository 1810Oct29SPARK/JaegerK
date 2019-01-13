package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementsDAOImpl;

@WebServlet ("/Approve")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementsDAOImpl reimb = new ReimbursementsDAOImpl();
		
		int reimbursement_id = Integer.parseInt(request.getParameter("reimbursement_id"));
		System.out.println(request.getParameter("reimbursement_id"));
		reimb.approve(reimbursement_id);
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("approved.html").include(request, response);
		pw.print("<p> The reimbursement request with id " + reimbursement_id + " has been approved</p>");
		pw.println("<a href=\"Info\">Back to Home</a>");
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
