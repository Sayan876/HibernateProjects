package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DBConnect;
import com.jsp.dao.StockDao;
import com.jsp.dto.StockEnt;
@WebServlet("/updaterec")
public class EditFuel extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			// TODO Auto-generated method stub
			String date = req.getParameter("dt");
			String fueltype = req.getParameter("ftype");
			String ostock = req.getParameter("ostk");
			Double stck = Double.parseDouble(ostock);
			String pvalue = req.getParameter("pval");
			double avalue = Double.parseDouble(pvalue);
			String pquanty = req.getParameter("pqty");
			String perrate = req.getParameter("prate");
			double aperrate = Double.parseDouble(perrate);
			double aquanty = Double.parseDouble(pquanty);
			String totalStock = req.getParameter("tstock");
			double atlStock = Double.parseDouble(totalStock);
			String openvalue=req.getParameter("ovalue");
			double ovalue = Double.parseDouble(openvalue);
			String totalvalue = req.getParameter("tvalue");
			double tovalue = Double.parseDouble(totalvalue);
			
			String xid = req.getParameter("sid");
			int id = Integer.parseInt(xid);
			
			
			StockEnt st = new StockEnt(id, date, fueltype, stck, aperrate, aquanty, avalue,atlStock, ovalue, tovalue);
			StockDao ddao = new StockDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			
			if(ddao.updateStock(st)) {
				session.setAttribute("sucMsg", "Updated successfully");
				resp.sendRedirect("EditRecords.jsp");
			}else {
				session.setAttribute("errorMsg", "Something's wrong");
				resp.sendRedirect("EditRecords.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}


