package com.jsp.dto;
import javax.persistence.*;
@Entity
public class StockEnt {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private int id;
	@Column(nullable=false)
	private String entdate;
	@Column(nullable=false)
	private String fuelType;
	@Column(nullable=false)
	private double openstock;
	@Column(nullable=false)
	private double purchaseRate;
	@Column(nullable=false)
	private double purchaseQty;
	@Column(nullable=false)
	private double purchaseValue;
	@Column(nullable=false)
    private double totalStock;
	@Column(nullable=false)
	private double openvalue;
	@Column(nullable=false)
	private double totalValue;
	
	
	
	
	public StockEnt() {
		super();
		// TODO Auto-generated constructor stub
	}




	public StockEnt(String entdate, String fuelType, double openstock, double purchaseRate, double purchaseQty,
			double purchaseValue, double totalStock, double openvalue, double totalValue) {
		super();
		this.entdate = entdate;
		this.fuelType = fuelType;
		this.openstock = openstock;
		this.purchaseRate = purchaseRate;
		this.purchaseQty = purchaseQty;
		this.purchaseValue = purchaseValue;
		this.totalStock = totalStock;
		this.openvalue = openvalue;
		this.totalValue = totalValue;
	}




	public StockEnt(int id, String entdate, String fuelType, double openstock, double purchaseRate, double purchaseQty,
			double purchaseValue, double totalStock, double openvalue, double totalValue) {
		super();
		this.id = id;
		this.entdate = entdate;
		this.fuelType = fuelType;
		this.openstock = openstock;
		this.purchaseRate = purchaseRate;
		this.purchaseQty = purchaseQty;
		this.purchaseValue = purchaseValue;
		this.totalStock = totalStock;
		this.openvalue = openvalue;
		this.totalValue = totalValue;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getEntdate() {
		return entdate;
	}




	public void setEntdate(String entdate) {
		this.entdate = entdate;
	}




	public String getFuelType() {
		return fuelType;
	}




	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}




	public double getOpenstock() {
		return openstock;
	}




	public void setOpenstock(double openstock) {
		this.openstock = openstock;
	}




	public double getPurchaseRate() {
		return purchaseRate;
	}




	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}




	public double getPurchaseQty() {
		return purchaseQty;
	}




	public void setPurchaseQty(double purchaseQty) {
		this.purchaseQty = purchaseQty;
	}




	public double getPurchaseValue() {
		return purchaseValue;
	}




	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}




	public double getTotalStock() {
		return totalStock;
	}




	public void setTotalStock(double totalStock) {
		this.totalStock = totalStock;
	}




	public double getOpenvalue() {
		return openvalue;
	}




	public void setOpenvalue(double openvalue) {
		this.openvalue = openvalue;
	}




	public double getTotalValue() {
		return totalValue;
	}




	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}




	
	
	
	
	
	


	
	
    
	

}
