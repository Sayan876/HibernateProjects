<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Profile</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>
<br>
<br>
<br>
 <div>
   <section>
      <form action="createuser" method="post">
      <c:if test="${not empty errorMsg}">
			<p class="text-center text-danger fs-3">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>

		<c:if test="${not empty sucMsg}">
			<p class="text-center text-success fs-5">${sucMsg}</p>
			<c:remove var="sucMsg" scope="session" />
		</c:if>
	  <input type="text" placeholder="Enter the fullname" name="fullname">	
      <input type="email" placeholder="Enter the email" name="email">
      <input type="password" placeholder="Enter the password" name="password">
      
      <button>login</button>
  
  </form>
   
   
   </section>
 
 </div>

  

</body>
</html>