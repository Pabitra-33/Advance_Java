package testexam.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getting the session
		HttpSession session = req.getSession();
		Object o1 = session.getAttribute("user");
		System.out.println(o1);
		
		if(session != null) {
			resp.sendRedirect("login.html");
			session.invalidate();//Destroying the session
			System.out.println(o1);//session deleted
		}
	}
}