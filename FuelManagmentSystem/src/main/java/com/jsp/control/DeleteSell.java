package com.jsp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.StockSellDao;
import com.jsp.dto.StockSellEnt;
@WebServlet("/deletesell")
public class DeleteSell extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StockSellDao ssd = new StockSellDao();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
	    StockSellEnt s = ssd.deleteSell(id);
	    
	    HttpSession session = req.getSession();
	    
	    if(s!=null) {
	    	session.setAttribute("sucMsg", "Deleted");
	    	resp.sendRedirect("home.jsp");
	    }else {
	    	session.setAttribute("errorMsg", "Server Error");
	    	resp.sendRedirect("home.jsp");
	    }
	}

}
