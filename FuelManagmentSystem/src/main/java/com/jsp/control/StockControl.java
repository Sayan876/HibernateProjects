package com.jsp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.UpdateStock;
import com.jsp.dto.StockEnt;

@WebServlet("/Enterthestock")
public class StockControl extends HttpServlet {
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
UpdateStock udao = new UpdateStock();
	   
	   StockEnt s = new StockEnt();
	   
	   String date = req.getParameter("date");
	   String fueltype=req.getParameter("fueltype");
	   double openstock = Double.parseDouble(req.getParameter("openingstock"));
	   double purchaserate = Double.parseDouble(req.getParameter("purchaserate"));
	   double openingvalue = openstock*purchaserate;//
	   double purchaseqty = Double.parseDouble(req.getParameter("purchaseqty"));
	   double purchasevalue = purchaserate*purchaseqty;//
	   double totalStock = purchaseqty + Double.parseDouble(req.getParameter("totalstock"));
	   double totalValue= totalStock*purchaserate;
	   
	   s.setEntdate(date);
	   s.setFuelType(fueltype);
	   s.setOpenstock(openstock);
	   s.setOpenvalue(openingvalue);
	   s.setPurchaseQty(purchaseqty);
	   s.setPurchaseRate(purchaserate);
	   s.setPurchaseValue(purchasevalue);
	   s.setTotalStock(totalStock);
	   s.setTotalValue(totalValue);
	   
	   s = udao.enterStock(s);
	   
	   HttpSession session = req.getSession();
	   
	   if(s!=null) {
		   session.setAttribute("sucMsg", "Stock Entered");
		   resp.sendRedirect("records.jsp");
	   }else {
		   session.setAttribute("errorMsg", "failed");
		   resp.sendRedirect("records.jsp");
	   }
		
	}


}
