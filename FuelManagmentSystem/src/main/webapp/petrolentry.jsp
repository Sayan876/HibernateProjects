<%@page import="com.Db.DBConnect"%>
<%@page import="com.jsp.dao.SellDaoCounts"%>
<%@page import="com.jsp.dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entry Fuel</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>
<br>
<br>
<br>

<% StockDao st = new StockDao(DBConnect.getConn()); 
    SellDaoCounts scou = new SellDaoCounts(DBConnect.getConn());
    double power = scou.getAddedPower() - scou.getsoldPower();
    double diesel = scou.getAddedDiesel() - scou.getsoldDiesel();
    double petrol = scou.getAddedPetrol() - scou.getsoldPetrol();
    double mobil = scou.getAddedMobil() - scou.getsoldMobil();
    
 %>
  <div class="mainform">
  <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
    <section>
      <form action="Enterthestock" method="post">
		<table>
		
		<div class="dropdown">
						<button class="btn  dropdown-toggle btn-success" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">Select
							Fueltype</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="petrolentry.jsp">Petrol</a></li>
                            <li><a class="dropdown-item" href="mobilentry.jsp">Mobil</a></li>
                            <li><a class="dropdown-item" href="powerentry.jsp">Power</a></li>
                            <li><a class="dropdown-item" href="dieselentry.jsp">Diesel</a></li>
						</ul>
					</div>
		  <tr>
		  <td>Date: </td>
		  <td><input type="date" placeholder="Enter the date" name="date" required></td>
		  </tr>
		  
		  <tr>
		  <td>FuelType: </td>
		  <td><input type="text" value= "Petrol" name="fueltype"readonly required></td>
		  </tr>
		  
		  <tr>
		  <td>Opening Stock: </td>
		  <td><input type="text" placeholder="opening stock" name="openingstock" required value="<%=petrol%>" readonly></td>
		  </tr>
		  
		  
		  
		  <tr>
		  <td>Purchase Quantity: </td>
		  <td><input type="text" placeholder="Purchase quantity" name="purchaseqty" required></td>
		  </tr>
		  
		  <tr>
		  <td>Purchase Rate: </td>
		  <td> <input type="text" placeholder="Purchase Rate" name="purchaserate" required></td>
		  </tr>
		  
		  <tr>
		  <td>Total Stock: </td>
		  <td><input type="text" placeholder="Total Stock" name="totalstock" value="<%=petrol%>" readonly></td>
		  </tr>
		  
		  
		  
		  
		  
		  <tr>
		   <td colspan="2"><button>Submit</button></td>
		   
		  </tr>
		
		</table>

		    
			
			
		
	</form>
    
    </section>
  
  </div>
	<br>
<br>
<br>

</body>
</html>