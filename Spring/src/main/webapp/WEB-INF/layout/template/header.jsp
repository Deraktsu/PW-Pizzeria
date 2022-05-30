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
    