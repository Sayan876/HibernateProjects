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

@WebServlet("/updatest")
public class StockUpdate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		 String date = req.getParameter("date");
		   String fueltype=req.getParameter("fueltype");
		   double openstock = Double.parseDouble(req.getParameter("openingstock"));
		   double purchaserate = Double.parseDouble(req.getParameter("purchaserate"));
		   double openingvalue = openstock*purchaserate;//
		   double purchaseqty = Double.parseDouble(req.getParameter("purchaseqty"));
		   double purchasevalue = purchaserate*purchaseqty;//
		   //double totalStock = openstock + Double.parseDouble(req.getParameter("totalstock"));
		   double totalStock = openstock + purchaseqty;
		   double totalValue= totalStock*purchaserate;
		
		
		
		UpdateStock u = new UpdateStock();

		System.out.println("Start entering the details");
		StockEnt s = new StockEnt();
		System.out.println("Enter the id");
		s.setId(id);
		s.setEntdate(date);
		   s.setFuelType(fueltype);
		   s.setOpenstock(openstock);
		   s.setOpenvalue(openingvalue);
		   s.setPurchaseQty(purchaseqty);
		   s.setPurchaseRate(purchaserate);
		   s.setPurchaseValue(purchasevalue);
		   s.setTotalStock(totalStock);
		   s.setTotalValue(totalValue);

		s = u.updateStock(s);
		
		HttpSession session = req.getSession();

		if (s != null) {
			session.setAttribute("sucMsg", "Updated successfully");
			resp.sendRedirect("home.jsp");
		} else {
			session.setAttribute("errorMsg", "Something's wrong");
			resp.sendRedirect("home.jsp");
		}
	}

}
