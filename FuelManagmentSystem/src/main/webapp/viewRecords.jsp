<%@page import="com.jsp.dao.SellDaoCounts"%>
<%@page import="com.jsp.dao.StockSellDao"%>
<%@page import="com.jsp.dto.StockEnt"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.jsp.dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Entry History</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>
 <% StockDao st = new StockDao(DBConnect.getConn()); 
    SellDaoCounts scou = new SellDaoCounts(DBConnect.getConn());
    
 %>
 
 <br>
 <br>
 <br>
 
 <div class="box">
   <div style="background-color: #03fcdb;"><h1><i class="fa-solid fa-car-battery"></i><%=scou.getAllPowerSell() %></h1></div>
   <div style="background-color: #befc03;"><h1><i class="fa-solid fa-oil-can"></i><%=scou.getAllDieselSell() %></h1></div>
   <div style="background-color: #fc7703;"><h1><i class="fa-solid fa-gas-pump"></i><%=scou.getAllPetrolSell() %></h1></div>
   <div style="background-color: #ba03fc;"><h1><i class="fa-solid fa-bottle-droplet"></i><%=scou.getAllMobilSell() %></h1></div>
 
 </div>
 
 
    
    <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>


	<table border="1">
		<thead>
			<tr>
				<th>#ID</th>
				<th>Date</th>
				<th>Fuel Type</th>
				<th>Opening Stock</th>
				<th>Opening Value</th>
				<th>Purchase Quantity</th>
				<th>Purchase Rate</th>
				<th>Purchase Value</th>
				<th>Total Stock</th>
				<th>Total Value</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
			<%StockDao ddao = new StockDao(DBConnect.getConn());
			List<StockEnt> list2 = ddao.getAllRecords();
			for(StockEnt s:list2)
			{%>
			<tr>
			
			    <td><%=s.getId()%></td>
				<td><%=s.getEntdate()%></td>
				<td><%=s.getFuelType()%></td>
				<td><%=s.getOpenstock()%></td>
				<td><%=s.getOpenvalue()%></td>
				<td><%=s.getPurchaseQty()%></td>
				<td><%=s.getPurchaseRate()%></td>
				<td><%=s.getPurchaseValue()%></td>
				<td><%=s.getTotalStock()%></td>
				<td><%=s.getTotalValue() %></td>
				<td><a href="UpdateStock.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary">Edit</a>
				<a href="deletes?id=<%=s.getId()%>" class="btn btn-sm btn-danger">Delete</a></td>
			
			</tr>
				
				
			<%}
			%>
		</tbody>
	</table>
	
	<br>
	<br>
	<br>
</body>
</html>