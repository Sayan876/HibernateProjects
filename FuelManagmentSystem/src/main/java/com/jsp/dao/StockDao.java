package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.StockEnt;
import com.mysql.cj.protocol.Resultset;

public class StockDao {
	
	private Connection conn;
	
	

	public StockDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	public List<StockEnt> getAllRecords(){
	
		List<StockEnt> list = new ArrayList<StockEnt>();
		StockEnt s = null;
		
		try {
			String sql = "select * from stockent order by entdate";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new StockEnt();
				s.setId(rs.getInt(1));
				s.setEntdate(rs.getString(2));
				s.setFuelType(rs.getString(3));
				s.setOpenstock(rs.getDouble(4));
				s.setOpenvalue(rs.getDouble(5));
				s.setPurchaseQty(rs.getDouble(6));
				s.setPurchaseRate(rs.getDouble(7));
				s.setPurchaseValue(rs.getDouble(8));
				s.setTotalStock(rs.getDouble(9));
				s.setTotalValue(rs.getDouble(10));
				
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	public StockEnt getStockById(int id) {
		StockEnt s = null;
		try {
			String sql = "select * from stockent where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				s = new StockEnt();
				s.setId(rs.getInt(1));
				s.setEntdate(rs.getString(2));
				s.setFuelType(rs.getString(3));
				s.setOpenstock(rs.getDouble(4));
				s.setOpenvalue(rs.getDouble(5));
				s.setPurchaseQty(rs.getDouble(6));
				s.setPurchaseRate(rs.getDouble(7));
				s.setPurchaseValue(rs.getDouble(8));
				s.setTotalStock(rs.getDouble(9) - rs.getDouble(4));
				s.setTotalValue(rs.getDouble(10));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	
	public int getPowerTotalStock() {
		int i=0;
		
		try {
			String sql = "SELECT sum(totalStock) FROM fms.stockent where fuelType='power'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}else {
				i=0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int getPetrolTotalStock() {
		int i=0;
		
		try {
			String sql = "SELECT sum(totalStock) FROM fms.stockent where fuelType='petrol'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}else {
				i=0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int getDieselTotalStock() {
		int i=0;
		
		try {
			String sql = "SELECT sum(totalStock) FROM fms.stockent where fuelType='diesel'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}else {
				i=0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int getMobilTotalStock() {
		int i=0;
		
		try {
			String sql = "SELECT sum(totalStock) FROM fms.stockent where fuelType='mobil'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}else {
				i=0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	

}
