package com.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockSellEnt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private String FuelType;
	@Column(nullable = false)
	private double totalstock;
	@Column(nullable = false)
	private double sellQty;
	@Column(nullable = false)
	private double sellRate;
	@Column(nullable = false)
	private double totalValue;
	@Column(nullable = false)
	private double sellvalue;
	@Column(nullable = false)
	private double closingStock;
	@Column(nullable = false)
	private double pAndl;
	
	
	
	
	public StockSellEnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public StockSellEnt(int id, String date, String fuelType, double totalstock, double sellQty, double sellRate,
			double totalValue, double sellvalue, double closingStock, double pAndl) {
		super();
		this.id = id;
		this.date = date;
		FuelType = fuelType;
		this.totalstock = totalstock;
		this.sellQty = sellQty;
		this.sellRate = sellRate;
		this.totalValue = totalValue;
		this.sellvalue = sellvalue;
		this.closingStock = closingStock;
		this.pAndl = pAndl;
	}



	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public double getSellvalue() {
		return sellvalue;
	}
	public void setSellvalue(double sellvalue) {
		this.sellvalue = sellvalue;
	}
	public double getClosingStock() {
		return closingStock;
	}
	public void setClosingStock(double closingStock) {
		this.closingStock = closingStock;
	}
	public double getpAndl() {
		return pAndl;
	}
	public void setpAndl(double pAndl) {
		this.pAndl = pAndl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFuelType() {
		return FuelType;
	}
	public void setFuelType(String fuelType) {
		FuelType = fuelType;
	}
	public double getTotalstock() {
		return totalstock;
	}
	public void setTotalstock(double totalstock) {
		this.totalstock = totalstock;
	}
	public double getSellQty() {
		return sellQty;
	}
	public void setSellQty(double sellQty) {
		this.sellQty = sellQty;
	}
	public double getSellRate() {
		return sellRate;
	}
	public void setSellRate(double sellRate) {
		this.sellRate = sellRate;
	}

	

}
