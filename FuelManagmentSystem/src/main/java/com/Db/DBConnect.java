package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
   private static Connection conn;
   
   public static Connection getConn() {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FMS", "root", "Sayan@1936");
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   return conn;
   }
}