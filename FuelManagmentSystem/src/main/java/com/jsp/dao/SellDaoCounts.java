package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.StockSellEnt;

public class SellDaoCounts {
	
	private Connection conn;

	public SellDaoCounts(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public int getAllPowerSell() {
		int i=0;
		try {
			String sql = "select (SELECT sum(purchaseQty) FROM fms.stockent where fuelType='power') - (SELECT sum(sellQty) FROM fms.stocksellent where fuelType='power')";
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
	
	public int getAllDieselSell() {
		int i=0;
		try {
			String sql = "select (SELECT sum(purchaseQty) FROM fms.stockent where fuelType='Diesel') - (SELECT sum(sellQty) FROM fms.stocksellent where fuelType='Diesel')";
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
	
	public int getAllPetrolSell() {
		int i=0;
		try {
			String sql = "select (SELECT sum(purchaseQty) FROM fms.stockent where fuelType='Petrol') - (SELECT sum(sellQty) FROM fms.stocksellent where fuelType='Petrol')";
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
	
	
	public int getAllMobilSell() {
		int i=0;
		try {
			String sql = "select (SELECT sum(purchaseQty) FROM fms.stockent where fuelType='Mobil') - (SELECT sum(sellQty) FROM fms.stocksellent where fuelType='Mobil')";
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
	
	
	public List<StockSellEnt> getAllSellsHistory(){
		List<StockSellEnt> list = new ArrayList<StockSellEnt>();
		StockSellEnt s = null;
		try {
			String sql = "select * from stocksellent order by date";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				s = new StockSellEnt();
				s.setId(rs.getInt(1));
				s.setFuelType(rs.getString(2));
				s.setClosingStock(rs.getDouble(3));
				s.setDate(rs.getString(4));
				s.setpAndl(rs.getDouble(5));
				s.setSellQty(rs.getDouble(6));
				s.setSellRate(rs.getDouble(7));
				s.setSellvalue(rs.getDouble(8));
				s.setTotalValue(rs.getDouble(9));
				s.setTotalstock(rs.getDouble(10));
				
				list.add(s);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public StockSellEnt getSellById(int id) {
		StockSellEnt s = null;
		try {
			String sql = "select * from stocksellent where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new StockSellEnt();
				s.setId(rs.getInt(1));
				s.setFuelType(rs.getString(2));
				s.setClosingStock(rs.getDouble(3));
				s.setDate(rs.getString(4));
				s.setpAndl(rs.getDouble(5));
				s.setSellQty(rs.getDouble(6));
				s.setSellRate(rs.getDouble(7));
				s.setSellvalue(rs.getDouble(8));
				s.setTotalValue(rs.getDouble(9));
				s.setTotalstock(rs.getDouble(10));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	public int getAddedPower() {
		int i=0;
		try {
			String sql = "SELECT sum(purchaseQty) FROM fms.stockent where fuelType='power'";
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
	
	
	public int getsoldPower() {
		int i=0;
		try {
			String sql = "SELECT sum(sellQty) FROM fms.stocksellent where fuelType='power'";
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
	
	public int getAddedDiesel() {
		int i=0;
		try {
			String sql = "SELECT sum(purchaseQty) FROM fms.stockent where fuelType='diesel'";
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
	
	public int getsoldDiesel() {
		int i=0;
		try {
			String sql = "SELECT sum(sellQty) FROM fms.stocksellent where fuelType='diesel'";
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
	
	public int getAddedPetrol() {
		int i=0;
		try {
			String sql = "SELECT sum(purchaseQty) FROM fms.stockent where fuelType='petrol'";
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
	
	public int getsoldPetrol() {
		int i=0;
		try {
			String sql = "SELECT sum(sellQty) FROM fms.stocksellent where fuelType='petrol'";
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
	
	public int getAddedMobil() {
		int i=0;
		try {
			String sql = "SELECT sum(purchaseQty) FROM fms.stockent where fuelType='mobil'";
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
	
	public int getsoldMobil() {
		int i=0;
		try {
			String sql = "SELECT sum(sellQty) FROM fms.stocksellent where fuelType='mobil'";
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
	
	public int getAvgPower() {
		int i=0;
		try {
			String sql = "SELECT avg(purchaseRate) from fms.stockent where fueltype='power'";
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
	
	public int getAvgPetrol() {
		int i=0;
		try {
			String sql = "SELECT avg(purchaseRate) from fms.stockent where fueltype='petrol'";
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
	
	public int getAvgDiesel() {
		int i=0;
		try {
			String sql = "SELECT avg(purchaseRate) from fms.stockent where fueltype='diesel'";
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
	
	public int getAvgMobil() {
		int i=0;
		try {
			String sql = "SELECT avg(purchaseRate) from fms.stockent where fueltype='mobil'";
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
