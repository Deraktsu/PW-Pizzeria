<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<header class="headb">
<a >
<img style="width:175px;" src="<c:url value="/static/images/4.png" />" id="logo" alt="logo 5uaglioni">
</a>
<c:if test="${!logAdmin}">
<nav class="navbar">

<a href="#benvenuto">CHI SIAMO</a>
<a href="#menu">MENU'</a>

<a href="/pizzeria/home/doveSiamo">DOVE SIAMO</a>

</nav>
</c:if>
<div class="side-bar">

<c:if test="${logAdmin || !logUtente}">
<a  href="/pizzeria/loginAdmin"><i class="fas fa-regular fa-wrench" title="Area amministratore"></i></a>
</c:if>
<c:if test="${!logAdmin}">
<a href="/pizzeria/areaClienti"><i class="fas fa-user" id="user" title="Area riservata"></i></a>
</c:if>
<c:if test="${!logAdmin}">
<a href="/pizzeria/carrello"><i class="fas fa-regular fa-cart-shopping" id="cart" title="Vai al carrello" ></i></a>
</c:if>
<c:if test="${logUtente || logAdmin}">
<a href="/pizzeria/test/logout"><i class="fas fa-regular fa-arrow-right-from-bracket"  title="Logout"></i></a>
    </c:if>
    
    </div>
</header>
    
    


       <%--  <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
          <a class="nav-link" href='<spring:url value="/prodotti"/>'>Prodotti</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/carrello"/>'>Carrello</a>
        </li>
        <c:if test="${!logUtente}">
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/registrazione"/>'>Registrazione</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/registrazione/login"/>'>Login</a>
        </li>
        
      
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/loginAdmin"/>'>Login Admin</a>
        </li>
        </c:if>
        <c:if test="${logUtente}">
        <li class="nav-item">
          <a class="nav-link" href='<spring:url value="/areaClienti"/>'>Area Clienti</a>
        </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<div class="card bg-light text-white">

  <div class="card-img-overlay">
    
  </div>
</div> --%>