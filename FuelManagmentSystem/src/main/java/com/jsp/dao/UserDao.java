package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.StockEnt;
import com.jsp.dto.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	   
	   public User createUser(User user) {
		   EntityTransaction transaction = manager.getTransaction();
		   transaction.begin();
		   manager.persist(user);
		   transaction.commit();
		   return user;
	   }
	   
	   public User updateUser(User user) {
		   EntityTransaction transaction = manager.getTransaction();
		   User dbuser = manager.find(User.class, user.getId());
		   if(dbuser!=null) {
			   dbuser.setFullname(user.getFullname());
			   dbuser.setEmail(user.getEmail());
			   dbuser.setPassword(user.getPassword());
			   transaction.begin();
			   transaction.commit();
			   return user;
		   }return null;
	   }
	   
	   public User loginUser(String email, String password) {
		   Query query = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");;
		   query.setParameter(1, email);
		   query.setParameter(2, password);
		   try {
			   return (User) query.getSingleResult();
		   }catch(NoResultException e) {
			   return null;
		   }
	   }
  
}
