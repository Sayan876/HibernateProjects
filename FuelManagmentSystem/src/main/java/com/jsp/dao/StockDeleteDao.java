package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.StockEnt;

public class StockDeleteDao {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	
	public StockEnt deleteStock(int id) {
		EntityTransaction transaction = manager.getTransaction();
		StockEnt dbstock = manager.find(StockEnt.class, id);{
			if(dbstock!=null) {
				manager.remove(dbstock);
				transaction.begin();
				transaction.commit();
				return dbstock;
			}return null;
		}
	}
}
