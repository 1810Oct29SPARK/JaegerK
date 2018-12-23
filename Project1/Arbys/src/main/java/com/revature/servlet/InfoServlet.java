package com.revature.servlet;

import java.io.IOException;
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
			req.getRequestDispatcher("login.html").forward(req, res);
		} else {
			req.getRequestDispatcher("Arbys.html");
		}
	}

}
