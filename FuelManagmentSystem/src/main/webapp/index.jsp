<%@page import="com.Db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<%@include file="./component/allcss.jsp"%>
</head>
<body>
<%@include file="./component/navbar.jsp"%>
     <%-- <%Connection conn = DBConnect.getConn(); out.print(conn); %> --%>
     
     <div id="carouselExample" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item">
      <img src="./image/diesel.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item active">
      <img src="./image/petrol.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="./image/mobil.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="./image/carbattery.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	

</body>
</html>