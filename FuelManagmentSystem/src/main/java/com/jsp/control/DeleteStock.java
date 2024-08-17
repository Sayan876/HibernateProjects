package com.jsp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.StockDao;
import com.jsp.dao.StockDeleteDao;
import com.jsp.dto.StockEnt;
@WebServlet("/deletes")
public class DeleteStock extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StockDeleteDao ddao = new StockDeleteDao();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		StockEnt s = ddao.deleteStock(id);
		
		HttpSession session = req.getSession();
		
		if(s!=null) {
			session.setAttribute("sucMsg", "Deleted successfully");
			resp.sendRedirect("home.jsp");
		}else {
			session.setAttribute("errorMsg", "Cannot Delete");
			resp.sendRedirect("home.jsp");
		}
	}

}
