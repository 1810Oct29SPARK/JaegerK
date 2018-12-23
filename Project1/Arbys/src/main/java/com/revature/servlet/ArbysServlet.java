package com.revature.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.revature.beans.Login;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;
 
@WebServlet ("/Arbys")
public class ArbysServlet extends HttpServlet {

	private static final long serialVersionUID = 817105812389880890L;
	AuthenticationService authService = new AuthenticationService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet Successful");
		req.getRequestDispatcher("Arbys.html").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("handling the request..");
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		Login log = new Login(req.getParameter("username"),req.getParameter("password"));
		System.out.println("Log: " + log);
		System.out.println("New login created");
		Employee e = authService.isValidUser(log);
		System.out.println("New Employee Created: " + e);
		
		if (e != null) {
          session.setAttribute("empId", e.getId());
          session.setAttribute("firstname", e.getFirstname());
          session.setAttribute("lastname", e.getLastname());
          session.setAttribute("position", e.getPosition());
          session.setAttribute("salary", e.getSalary());
          session.setAttribute("hours", e.getHours());
          //redirect user to profile page if authenticated
          res.sendRedirect("InfoServlet");
          System.out.println("profile page is authenticated");
      } else {
          session.setAttribute("problem", "invalid credentials");
          System.out.println("profile page is not authenticated");
          //redirect user to login page if authentication fails
          res.sendRedirect("Arbys");
      }
	}
}