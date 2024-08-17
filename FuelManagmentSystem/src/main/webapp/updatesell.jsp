<%@page import="com.jsp.dao.SellDaoCounts"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.jsp.dto.StockSellEnt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Sales form</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>

 <br>
 <br>
 <br>
 
 
  <div class="mainform">
    <section>
       <form action="updatesell" method="post">
  <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
		<% int id = Integer.parseInt(request.getParameter("id"));
		   SellDaoCounts dao = new SellDaoCounts(DBConnect.getConn());
		   StockSellEnt s = dao.getSellById(id);
		%>
		
		<table>
		 <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
		  <tr>
		   <td>Id: </td>
		   <td><input type="text" readonly value=<%=s.getId() %>  name="id"></td>
		  </tr>
		  
		  <tr>
		   <td>Date: </td>
		   <td><input type="date" placeholder="Enter the date" name="date"  required value="<%=s.getDate()%>"></td>
		  </tr>
		  
		  <tr>
		   <td>Sell Quantity: </td>
		   <td><input type="text" value="<%=s.getSellQty() %>" placeholder="Sell quantity" name="sellqty" required></td>
		  </tr>
		  
		  <tr>
           <td>Date: </td>
           <td><input type="date" placeholder="Enter the date" name="date"  value="<%=s.getDate() %>"  required></td>
         </tr> 
         
         <tr>
           <td>Fuel Type: </td>
           <td><input type="text"  readonly name="fueltype"  value="<%=s.getFuelType() %>" required readonly></td>
         </tr> 
         
         <tr>
           <td>Sell Rate: </td>
           <td><input type="text" placeholder="Sell Rate" name="sellrate" value="<%=s.getSellRate() %>" required></td>
         </tr> 
         
         
         
         <tr>
           <td>Total Stock: </td>
           <td><input type="text" placeholder="" name="totalStock" value="<%=s.getTotalstock()%>" required readonly></td>
         </tr> 
         
         <tr>
           
           <td colspan="2"> <button>Update</button></td>
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