package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.StockEnt;

public class UpdateStock {
   EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
   
   public StockEnt enterStock(StockEnt st) {
	   EntityTransaction transaction = manager.getTransaction();
	   transaction.begin();
	   manager.persist(st);
	   transaction.commit();
	   return st;
   }
   
   public StockEnt updateStock(StockEnt st) {
	   EntityTransaction transaction = manager.getTransaction();
	   StockEnt dbstock = manager.find(StockEnt.class, st.getId());
	   if(dbstock!=null) {
		   dbstock.setEntdate(st.getEntdate());
		   dbstock.setFuelType(st.getFuelType());
		   dbstock.setOpenstock(st.getOpenstock());
		   dbstock.setOpenvalue(st.getOpenvalue());
		   dbstock.setPurchaseQty(st.getPurchaseQty());
		   dbstock.setPurchaseRate(st.getPurchaseRate());
		   dbstock.setPurchaseValue(st.getPurchaseValue());
		   dbstock.setTotalStock(st.getTotalStock());
		   dbstock.setTotalValue(st.getTotalValue());
		   transaction.begin();
		   transaction.commit();
		   return st;
	   }
	   return null;
   }
}
