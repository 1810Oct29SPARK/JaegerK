package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementsDAOImpl;

@WebServlet ("/Submitted")
public class SubmittedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementsDAOImpl reimb = new ReimbursementsDAOImpl();
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		int reimbursement_id = Integer.parseInt(request.getParameter("reimbursement_id"));
		String description = request.getParameter("description");
		int amount = Integer.parseInt(request.getParameter("amount"));
		reimb.submit(employee_id, reimbursement_id, description, amount, null);
		response.setContentType("text/html");
		
		
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("submitted.html").include(request, response);
		pw.print("<p> Your submitted Request Information: </p>");
		pw.println("<p>Employee Id: " + employee_id + "</p>");
		pw.println("<p>Reimbursement Id: " + reimbursement_id + "</p>");
		pw.println("<p>Description: " + description + "</p>");
		pw.println("<p>Amount: $" + amount + "</p>");
		pw.println("<a href=\"Info\">Back to Home</a>");
		pw.println("</div>");
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
