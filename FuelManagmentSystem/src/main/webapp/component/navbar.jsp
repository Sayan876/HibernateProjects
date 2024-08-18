<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-secondary bg-body-tertiary nevi">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-house-chimney-medical"></i>Fuel Managment System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="records.jsp">Records</a>
        </li>
        
        
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Stock Entry
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="powerentry.jsp">Power</a></li>
            <li><a class="dropdown-item" href="dieselentry.jsp">Diesel</a></li>
            <li><a class="dropdown-item" href="petrolentry.jsp">Petrol</a></li>
            <li><a class="dropdown-item" href="mobilentry.jsp">Mobil</a></li>
            
          </ul>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            SellEntry
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="powersell.jsp">Power</a></li>
            <li><a class="dropdown-item" href="diesel.jsp">Diesel</a></li>
            <li><a class="dropdown-item" href="petrolsell.jsp">Petrol</a></li>
            <li><a class="dropdown-item" href="mobilsell.jsp">Mobil</a></li>
          </ul>
        </li>
        
        
        
        
        
        <c:if test="${empty userObj}">
			<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            User
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="userlogin.jsp">Login</a></li>
            <li><a class="dropdown-item" href="createuser.jsp">Sign up</a></li>
            
          </ul>
        </li>
		</c:if>
		
		<c:if test="${not empty userObj}">
			<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ${userObj.fullname}
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="editprofile.jsp">Edit Profile</a></li>
            <li><a class="dropdown-item" href="home.jsp">Manage Database</a></li>
            <li><a class="dropdown-item" href="logoutuser">logout</a></li>
            
           
            
          </ul>
        </li>
		</c:if>
        
        
        
      </ul>
      
    </div>
  </div>
</nav>