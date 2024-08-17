<%@page import="com.jsp.dto.StockSellEnt"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.jsp.dao.SellDaoCounts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales History</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>
  <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
   <table>
     <tr>
                <th>#ID</th>
				<th>Date</th>
				<th>Fuel Type</th>
				<th>Closing Stock</th>
				<th>Sell Rate</th>
				<th>Sell Quantity</th>
				<th>Total Value</th>
				<th>Total Stock</th>
				<th>Closing Value</th>
				<th>Profit & Loss</th>
				<th>Action</th>
				
     </tr>
     <%SellDaoCounts sdao = new SellDaoCounts(DBConnect.getConn()); 
        List<StockSellEnt> list = sdao.getAllSellsHistory();
        for(StockSellEnt s:list)
        {%>
        	<tr>
        	  <td><%=s.getId() %></td>
        	  <td><%=s.getDate() %></td>
        	  <td><%=s.getFuelType() %></td>
        	  <td><%=s.getClosingStock() %></td>
        	  <td><%=s.getSellRate() %></td>
        	  <td><%=s.getSellQty() %></td>
        	  <td><%=s.getTotalValue() %></td>
        	  <td><%=s.getTotalstock() %></td>
        	  <td><%=s.getSellvalue() %></td>
        	  <td><%=s.getpAndl() %></td>
        	  <td><a href="updatesell.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary">Edit</a>
        	  <a href="deletesell?id=<%=s.getId()%>" class="btn btn-sm btn-danger">Delete</a></td>
        	
        	</tr>
        <%}
      %>
     
    
   
   </table>
</body>
</html>