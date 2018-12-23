package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet Successful");
		req.getRequestDispatcher("Arbys.html");

		HttpSession session = req.getSession(false);

		if (session.getAttribute("empId") != null) {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			req.getRequestDispatcher("login.html").include(req, res);
			pw.println("<p>Employee Id: " + session.getAttribute("empId") + "</p>");
			pw.println("<p>Employee First Name: " + session.getAttribute("firstname") + "</p>");
			pw.println("<p>Employee Last Name: " + session.getAttribute("lastname") + "</p>");
			pw.println("<p>Employee Position: " + session.getAttribute("position") + "</p>");
//			pw.println("<p>Employee Salary</p>" + session.getAttribute("salary") + "</p>");
			pw.println("<p>Employee Hours: " + session.getAttribute("hours") + "/week</p>");
			pw.println("</div>");
			pw.println("</body></html>");
		} else {
			req.getRequestDispatcher("Arbys.html");
		}
	}

}
