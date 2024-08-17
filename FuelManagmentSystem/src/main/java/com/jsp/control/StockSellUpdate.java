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
@WebServlet("/updatesell")
public class StockSellUpdate extends HttpServlet{
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int id = Integer.parseInt(req.getParameter("id"));
	    String date = req.getParameter("date");
		String fueltype = req.getParameter("fueltype");
		double sellqty = Double.parseDouble(req.getParameter("sellqty"));
		double sellrate = Double.parseDouble(req.getParameter("sellrate"));
		double sellvalue = sellrate*sellqty;
		double totalstock = Double.parseDouble(req.getParameter("totalStock"));
		double totalvalue = totalstock*sellrate;
		double closingstock = totalstock- sellqty;
		double profitandloss = sellrate*sellqty;

		StockSellDao sdao = new StockSellDao();

		StockSellEnt sse = new StockSellEnt();
        sse.setId(id);
		sse.setClosingStock(closingstock);
		sse.setDate(date);
		sse.setFuelType(fueltype);
		sse.setpAndl(profitandloss);
		sse.setSellQty(sellqty);
		sse.setSellRate(sellrate);
		sse.setSellvalue(sellvalue);
		sse.setTotalstock(totalstock);
		sse.setTotalValue(totalvalue);

		sse = sdao.updateSellEnt(sse);

		HttpSession session = req.getSession();

		if (sse != null) {
			session.setAttribute("sucMsg", "Updated successfully");
			resp.sendRedirect("home.jsp");
		} else {
			session.setAttribute("errorMsg", "Server Error");
			resp.sendRedirect("home.jsp");
		}
	}



}
