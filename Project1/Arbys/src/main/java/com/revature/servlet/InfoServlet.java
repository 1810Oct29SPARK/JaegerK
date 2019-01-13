package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursements;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementsDAOImpl;

@WebServlet("/Info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("Arbys.html");

		HttpSession session = req.getSession(false);

		// Employee Information
		if (session.getAttribute("empId") != null) {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			req.getRequestDispatcher("login.html").include(req, res);
			pw.println("<br>");
			pw.println("<p>Employee Id: " + session.getAttribute("empId") + "</p>");
			pw.println(
					"<p>Name: " + session.getAttribute("firstname") + " " + session.getAttribute("lastname") + "</p>");
			pw.println("<p>Position: " + session.getAttribute("position") + "</p>");
			pw.println("<p>Hours: " + session.getAttribute("hours") + "/week</p>");
			if (session.getAttribute("manager") != null) {
				pw.println("<p>Manager: " + session.getAttribute("manager") + "</p>");
			}
			pw.println("</div>");
			pw.println("<br><br>");

			ReimbursementsDAOImpl reimb = new ReimbursementsDAOImpl();
			EmployeeDaoImpl empdai = new EmployeeDaoImpl();

			List<Reimbursements> r = reimb.view((int) session.getAttribute("empId"));
			List<Employee> emp = empdai.listEmployees((String) session.getAttribute("firstname"));
			List<Employee> empandman = empdai.listAll();

			String position = session.getAttribute("position").toString();
			if (position.equals("MANAGER") || position.equals("CEO")) {
				// List the Employees who report to the given employee
				pw.println("<h3 class=\"text-center align-middle\"> Employees Who Report to You* </h3>");
				pw.println("<div class=\"loginInfo column\">");
				pw.println("<br>");
				pw.println("<table id=\"table1\">");
				pw.println("<tr>");
				pw.println("<th> Employee Id </th>");
				pw.println("<th> Name </th>");
				pw.println("<th> Position </th>");
				pw.println("<th> Hours </th>");
				pw.println("</tr>");
				for (Employee e : emp) {
					pw.println("<tr>");
					pw.println("<td>" + e.getId() + "</td>");
					pw.println("<td>" + e.getFirstname() + " " + e.getLastname() + "</td>");
					pw.println("<td>" + e.getPosition() + "</td>");
					pw.println("<td>" + e.getHours() + "/week</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				pw.println("<br>");
				pw.println("</div>");

				
				// List all employees and their managers
				pw.println("<h3 class=\"text-center align-middle\"> All Employees and Respective Managers* </h3>");
				pw.println("<div class=\"loginInfo\">");
				pw.println("<br>");
				pw.println("<table>");
				pw.println("<tr>");
				pw.println("<th> Employee Name </th>");
				pw.println("<th> Manager </th>");
				pw.println("</tr>");
				for (Employee e : empandman) {
					if (e.getReportsto() != null) {
						pw.println("<tr>");
						pw.println("<td>" + e.getFirstname() + " " + e.getLastname() + "</td>");
						pw.println("<td>" + e.getReportsto() + "</td>");
						pw.println("</tr>");
					}

				}
				pw.println("</table>");
				pw.println("<br>");
				pw.println("</div>");
			}

			if (r != null) {
				// Reimbursements
				pw.println("<h3 class=\"text-center align-middle\"> Your Reimbursements </h3>");
				pw.println("<div class=\"button\">\r\n" + "            <br>\r\n"
						+ "        <form action=\"Reimbursement\" method=\"POST\">\r\n"
						+ "            <input type=\"submit\" value=\"Submit Reimbursement\"/>\r\n"
						+ "        </form>\r\n" + "    </div>\r\n" + "    \r\n");
				pw.println("<div class=\"loginInfo\">");
				pw.println("<div class=\"col\">");
				pw.println("<br>");
				pw.println("<h2> Approved Reimbursements </h2>");
				pw.println("<br> <br>");
				if (r.size() > 0) {
					for (Reimbursements i : r) {
						if (i.getStatus() != null) {
							pw.println("<p> Reimbursement Id: " + i.getId() + "</p>");
							pw.println("<p> Description: " + i.getDescription() + "</p>");
							pw.println("<p> Amount: $" + i.getAmount() + "</p>");
							pw.println("<p> Status: " + i.getStatus() + "</p>");
							pw.println("<br>");
						}
					}
				} else {
					pw.println("<p> No reimbursements to show </p>");
					pw.println("<br> <br>");
				}
				pw.println("</div");
				pw.println("<div class=\"col\">");
				pw.println("<h2> Pending Reimbursements </h2>");
				pw.println("<br> <br>");
				if (r.size() > 0) {
					for (Reimbursements i : r) {
						if (i.getStatus() == null) {
							pw.println("<p> Reimbursement Id: " + i.getId() + "</p>");
							pw.println("<p> Description: " + i.getDescription() + "</p>");
							pw.println("<p> Amount: $" + i.getAmount() + "</p>");
							String pending = "Pending";
							pw.println("<p> Status: " + pending + "</p>");
							pw.println("<br>");
						}
					}
				} else {
					pw.println("<p> No reimbursements to show </p>");
					pw.println("<br> <br>");
				}
				pw.println("</div");
				pw.println("</div>");
			} else {
				pw.println("<h3 class=\"text-center align-middle\"> Reimbursements </h3>");
				pw.println("<div class=\"button\">\r\n" + "            <br>\r\n"
						+ "        <form action=\"Reimbursement\" method=\"POST\">\r\n"
						+ "            <input type=\"submit\" value=\"Submit Reimbursement\"/>\r\n"
						+ "        </form>\r\n" + "    </div>\r\n" + "    \r\n");
				pw.println("<div class=\"loginInfo\">");
				pw.println("<p> No Reimbursements to show. </p>");
				pw.println("</div>");
				pw.println(" </div>");
			}

			// Only Managers can see pending reimbursements
			if (position.equals("MANAGER") || position.equals("CEO")) {
				pw.println("<h3 class=\"text-center align-middle\"> Reimbursements Waiting for Your Approval* </h3>");
				pw.println("<div class=\"button\">\r\n" + "            <br>\r\n"
						+ "        <form action=\"Approve\" method=\"POST\">\r\n"
						+ "			<input type=\"number\" required=\"true\" name=\"reimbursement_id\" placeholder=\"Reimbursement ID\"/>\r\n"
						+ "            <input type=\"submit\" value=\"Approve Reimbursement\"/>\r\n"
						+ "        </form>\r\n" + "    </div>\r\n" + "    \r\n");
				pw.println("<div class=\"loginInfo col\">");
				for (Employee e : emp) {
					List<Reimbursements> rl = reimb.view(e.getId());
					for (Reimbursements i : rl) {
						if (i.getStatus() == null) {
							pw.println("<br> <br>");
							pw.println("<p> Reimbursement Id: " + i.getId() + "</p>");
							pw.println("<p> Employee: " + e.getFirstname() + " " + e.getLastname() + "</p>");
							pw.println("<p> Description: " + i.getDescription() + "</p>");
							pw.println("<p> Amount: $" + i.getAmount() + "</p>");
							String pending = "Pending";
							pw.println("<p> Status: " + pending + "</p>");
							pw.println("<br>");
						}
					}
				}
				pw.println("</div>");

			}

			if (position.equals("MANAGER") || position.equals("CEO")) {
				pw.println(
						"<p class=\"text-center align-middle\"> * = Denotes information only available to Managers & CEO </p>");
			}

			pw.println("</div>");
			pw.println("    <div class=\"button\">\r\n" + "            <br>\r\n"
					+ "        <form action=\"Logout\" method=\"POST\">\r\n"
					+ "            <input type=\"submit\" value=\"Logout\"/>\r\n" + "        </form>\r\n"
					+ "    </div>");
			pw.println("<br> <br>");
			pw.println("</div> </body></html>");
		} else {
			req.getRequestDispatcher("Arbys.html");
		}
	}

}
