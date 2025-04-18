package testexam.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import testexam.service.DatabaseService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		DatabaseService ds = new DatabaseService();
		int res = ds.add(username, password);
		if(res != 0) {
			System.out.println("Data saved");
		}
		
		int upwd = ds.fetch(username, password);
		if(upwd != 0) {
			HttpSession session = req.getSession();
			session.setAttribute("user", username);
			session.setAttribute("pswd", password);
			resp.sendRedirect("logout.html");
		}
		
//		if(username.equals("pabitra") && password.equals(upwd)) {
//			RequestDispatcher dispatcher = req.getRequestDispatcher("logout.html");
//			dispatcher.forward(req, resp);
//		}
	}
}
