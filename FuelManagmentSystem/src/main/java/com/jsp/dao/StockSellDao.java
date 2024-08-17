package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.StockSellEnt;

public class StockSellDao {
  EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
  
  public StockSellEnt saveSellEnt(StockSellEnt ss) {
	  EntityTransaction transaction = manager.getTransaction();
	  transaction.begin();
	  manager.persist(ss);
	  transaction.commit();
	  return ss;
  }
  
  public StockSellEnt updateSellEnt(StockSellEnt stockSell) {
	  EntityTransaction transaction = manager.getTransaction();
	  StockSellEnt dbsell = manager.find(StockSellEnt.class, stockSell.getId());
	  if(dbsell!=null) {
		  dbsell.setDate(stockSell.getDate());
		  dbsell.setFuelType(stockSell.getFuelType());
		  dbsell.setSellQty(stockSell.getSellQty());
		  dbsell.setSellRate(stockSell.getSellRate());
		  dbsell.setTotalstock(stockSell.getTotalstock());
		  dbsell.setClosingStock(stockSell.getClosingStock());
		  dbsell.setTotalValue(stockSell.getTotalValue());
		  dbsell.setpAndl(stockSell.getpAndl());
		  dbsell.setSellvalue(stockSell.getSellvalue());
		  transaction.begin();
		  transaction.commit();
		  return stockSell;
	  }return null;
  }
  
  
  public StockSellEnt deleteSell(int id) {
	  EntityTransaction transaction = manager.getTransaction();
	  StockSellEnt dbsell = manager.find(StockSellEnt.class, id);
	  if(dbsell!=null) {
		  manager.remove(dbsell);
		  transaction.begin();
		  transaction.commit();
		  return dbsell;
	  }return null;
  }
}
