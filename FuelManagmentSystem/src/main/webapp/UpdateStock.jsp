<%@page import="com.jsp.dto.StockEnt"%>
<%@page import="com.jsp.dao.StockDao"%>
<%@page import="com.Db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>

<br>
<br>
<br>



      <div class="mainform">
       <section>
          <form action="updatest" method="post">
        <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
		<% int id = Integer.parseInt(request.getParameter("id"));
         StockDao dao4 = new StockDao(DBConnect.getConn());
         StockEnt s = dao4.getStockById(id);
      %>
      
        <table>
        
          <tr>
            <td>Id: </td>
            <td><input type="text" name="id" value="<%=s.getId() %>" readonly ></td>
          </tr>
		  <tr>
		  <td>Date: </td>
		  <td><input type="date" placeholder="Enter the date" name="date" value="<%=s.getEntdate()%>"></td>
		  </tr>
		  
		  <tr>
		  <td>FuelType: </td>
		  <td> <input type="text" name="fueltype"  value="<%=s.getFuelType()%>" readonly ></td>
		  </tr>
		  
		  <tr>
		  <td>Opening Stock: </td>
		  <td><input type="text" placeholder="opening stock" name="openingstock" value="<%=s.getOpenstock() %>"  readonly ></td>
		  </tr>
		  
		  
		  
		  <tr>
		  <td>Purchase Quantity: </td>
		  <td><input type="text" placeholder="Purchase quantity" name="purchaseqty" value="<%=s.getPurchaseQty() %>" ></td>
		  </tr>
		  
		  <tr>
		  <td>Purchase Rate: </td>
		  <td> <input type="text" placeholder="Purchase Rate" name="purchaserate" value="<%=s.getPurchaseRate() %>" ></td>
		  </tr>
		  
		  <tr>
		  <td>Total Stock: </td>
		  <td><input type="text" placeholder="Total Stock" name="totalstock" value="<%=s.getTotalStock()%>" readonly ></td>
		  </tr>
		  
		  
		  
		  
		  
		  <tr>
		   <td colspan="2"><button>Submit</button></td>
		   
		  </tr>
		
		</table>
        
        
        
        
       
        
       
        
        
        
        
      
      </form>
       
       </section>
      </div>
     
      
</body>
</html>