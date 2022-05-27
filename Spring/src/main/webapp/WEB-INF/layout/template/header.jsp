<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
        // impostare file con tutti gli script
        let actImm = 0;
        let limite = 4;

        function cambia() {
            if (actImm === limite)
                actImm = 0;
           
            document.getElementById('logo').src="${pageContext.request.contextPath}/static/images/"
            document.getElementById('logo').src+=++actImm+".png"
            setTimeout('cambia()', 1000)
        }

        //si poteva omettere (document).ready (che in JS corrisponderebbe al body.onload) in quanto
        //il codice è posto al termine della pagina e non verrà eseguito prima del caricamento della page
        $(document).ready(function(){
            $("#flip").click(function(){
                $("#panel1").slideToggle("slow");
            });
        });
    </script>

<header class="headb">

        <a onclick="cambia()">
            <img style="width:175px;" src="<c:url value="/static/images/4.png" />" id="logo" alt="logo 5uaglioni">
        </a>
        <nav class="navbar">
            <a href="#benvenuto">CHI SIAMO</a>
            <a href="#menu">MENU'</a>
            <a href="#contatti">CONTATTI</a>
        </nav>
        <div class="side-bar">
            <a href="/pizzeria/loginAdmin"><i class="fas fa-user-secret" title="Area amministratore"></i></a>
            <a href="/pizzeria/areaClienti"><i class="fas fa-user" id="user" title="Area riservata"></i></a>
            <a href="/pizzeria/registrazione"><i class="fas fa-user" id="user" title="Registrazione"></i></a>
            
            <!-- solo se loggati -->
            <a href="/pizzeria/carrello"><i class="fas fa-regular fa-cart-shopping" id="cart" title="Vai al carrello" ></i></a>
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