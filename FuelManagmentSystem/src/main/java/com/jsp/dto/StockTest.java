package com.jsp.dto;


import javax.persistence.*;
public class StockTest {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		System.out.println(factory);
		
	}

}