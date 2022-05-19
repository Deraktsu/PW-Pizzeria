<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar
    	
    	</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/home"/>'>Home</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/cart"/>'>Carrello</a>
        </li>
        
      </ul>
      <c:if test="${isArticoli}">
			
      <form class="d-flex" action="home" method="GET">
        <input class="form-control me-2" type="search" placeholder="cerca per ID" name="searchText" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Cerca</button>
      </form>
       

      </c:if>
    </div>
  </div>
</nav>

<div class="card bg-light text-white">

  <div class="card-img-overlay">
    
  </div>
</div>