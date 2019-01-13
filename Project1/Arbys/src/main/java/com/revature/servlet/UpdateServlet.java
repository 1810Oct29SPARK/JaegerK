package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;

@WebServlet ("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		
		
		
		String ColumnName = request.getParameter("columnname");
		String NewField = request.getParameter("newfield");
		int EmployeeId = Integer.parseInt(request.getParameter("employeeid"));
		
		
		ed.updateEmployee(ColumnName, NewField, EmployeeId);
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("submitted.html").include(request, response);
		pw.print("<p> Your information has been updated. </p>");
		pw.println("<a href=\"InfoServlet\">Back to Home</a>");
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
