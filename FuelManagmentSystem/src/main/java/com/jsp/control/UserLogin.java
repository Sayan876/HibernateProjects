package com.jsp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.UserDao;
import com.jsp.dto.User;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDao udao = new UserDao();

		User u = new User();

		u = udao.loginUser(email, password);
		HttpSession session = req.getSession();

		if (u != null) {
			session.setAttribute("userObj", u);
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "Failed to login");
			resp.sendRedirect("userlogin.jsp");
		}
	}
}
