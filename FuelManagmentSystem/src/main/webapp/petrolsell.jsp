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
<title>Power form</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body style="background-image: url('./image/petrol.jpg');background-repeat: no-repeat;background-attachment: fixed;background-size: cover">
<%@include file="./component/navbar.jsp"%>

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
 
 
 
 <div class="mainform">
   <section>
      <form action="stocksell" method="post">
      <h3>Petrol</h3>
      <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
      
       <table>
       
       <div class="dropdown">
						<button class="btn  dropdown-toggle btn-danger" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">Select
							Fueltype</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="petrolsell.jsp">Petrol</a></li>
							<li><a class="dropdown-item" href="mobilsell.jsp">Mobil</a></li>
							<li><a class="dropdown-item" href="powersell.jsp">Power</a></li>
							<li><a class="dropdown-item" href="diesel.jsp">Diesel</a></li>
						</ul>
					</div>
         <tr>
           <td>Date: </td>
           <td><input type="date" placeholder="Enter the date" name="date"  required></td>
         </tr> 
         
         <tr>
            <td>Average Purchase rate: </td>
            <td><input type="text" name="purate" value="<%=scou.getAvgPetrol()%>" readonly></td>
         </tr>
         
         <tr>
           <td>Fuel Type: </td>
           <td><input type="text" value="Petrol" readonly name="fueltype" required readonly></td>
         </tr> 
         
         <tr>
           <td>Sell Quantity: </td>
           <td> <input type="text" placeholder="Sell quantity" name="sellqty" required class="sq"></td>
         </tr> 
         
         <tr>
           <td>Sell Rate: </td>
           <td><input type="text" placeholder="Sell Rate" name="sellrate" required></td>
         </tr> 
         
         
         
         <tr>
           <td>Total Stock: </td>
           <td><input type="text" placeholder="" name="totalStock" value="<%=petrol%>" required readonly class="ts"></td>
         </tr> 
         
         
         
         
         
         
         
         <tr>
           
           <td colspan="2"> <button onmouseover="hox()">Submit</button></td>
         </tr> 
       
       </table>
  
     
     
    
     
     
     
     
     
     
    
  </form>
   
   </section>
 
 </div>
 <br>
 <br>
 <br>
 
 <script src="fun.js"></script>

</body>
</html>