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

@WebServlet("/updateuser")

public class UserUpdate extends HttpServlet {
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	  int id = Integer.parseInt(req.getParameter("id"));
	  String fullname = req.getParameter("fullname");
	  String password = req.getParameter("password");
	  String email = req.getParameter("email");
		// TODO Auto-generated method stub
	  User u = new User();
		
		u.setId(id);
		u.setFullname(fullname);
		u.setEmail(email);
		u.setPassword(password);
		
		UserDao udao = new UserDao();
		
		u = udao.updateUser(u);
		HttpSession session = req.getSession();
		
		if(u!=null) {
			session.setAttribute("sucMsg", "Profile Updated");
			resp.sendRedirect("editprofile.jsp");
			
		}else {
			session.setAttribute("errorMsg", "Failed to edit");
			resp.sendRedirect("editprofile.jsp");
		}
	}


}
