<%@page import="com.jsp.dto.StockSellEnt"%>
<%@page import="com.jsp.dto.StockEnt"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.dao.SellDaoCounts"%>
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
<title>Record page</title>
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
 <br>
 <br>
 <br>
 
 <div class="box">
   <div style="background-color: #03fcdb;"><h1><i class="fa-solid fa-car-battery"></i><%=power %></h1></div>
   <div style="background-color: #befc03;"><h1><i class="fa-solid fa-oil-can"></i><%=diesel%></h1></div>
   <div style="background-color: #fc7703;"><h1><i class="fa-solid fa-gas-pump"></i><%=petrol%></h1></div>
   <div style="background-color: #ba03fc;"><h1><i class="fa-solid fa-bottle-droplet"></i><%=mobil%></h1></div>
 
 </div>
 
 <br>
 <br>
 <br>
 
 <h2 style="text-align: center;text-decoration: underline;">Stock Entry Records</h2>
  <main>
    <section>
    <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>


	<table border="1" id="sells">
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
				
			
			</tr>
				
				
			<%}
			%>
		</tbody>
	</table>
    
    </section>
    
    
    <section>
    <h1></h1>
    <br>
    <br>
    <br>
    <h2 style="text-align: center;text-decoration: underline;">Sale Records</h2>
	<c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
   <table id="sells">
     <tr>
                <th>#ID</th>
				<th>Date</th>
				<th>Fuel Type</th>
				<th>Closing Stock</th>
				<th>Sell Rate</th>
				<th>Sell Quantity</th>
				<th>Total Value</th>
				<th>Total Stock</th>
				<th>Sell Value</th>
				<th>Profit & Loss</th>
				
				
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
        	  <td id="pl"><%=s.getpAndl() %></td>
        	  
        	
        	</tr>
        <%}
      %>
     
    
   
   </table>
    
    </section>
  
  </main>
    
	
	
	<br>
	<br>
	<br>
	
	<script>
        let v = document.querySelectorAll("#pl")
        console.log(typeof(v))

        console.log(Array.isArray(v))
        
        let pure = Array.from(v);
        console.log(Array.isArray(pure))

        pure.forEach((elem)=>{
            if(elem.innerText>=0){
                elem.style.color="blue"
            }else{
                elem.style.color="red"
            }
            
        })
        
        

    </script>

</body>
</html>