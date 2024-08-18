<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body style="background-image: url('./image/animeoffice.jpg');background-repeat: no-repeat;background-attachment: fixed;background-size: cover">
<%@include file="./component/navbar.jsp"%>
<br>
<br>
<br>

 <div class="userform" >
   <section>
      <form action="userlogin" method="post">
      <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
		<h3>User Login</h3>
      <input type="email" placeholder="Enter the email" name="email" required>
      <input type="password" placeholder="Enter the password" name="password" required>
      <button>login</button>
  
  </form>
   
   
   </section>
 
 </div>

  

</body>
</html>