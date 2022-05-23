<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
PAGINA INDEX

<c:if test="${logUtente}">
<form:form method="POST" modelAttribute="user" acceptCharset="ISO-8859-1">
<div class="row">
<input type="submit" value="Logout" class="btn btn-primary btn-lg">
</div>
		</form:form>
		</c:if>
		
		<c:if test="${logAdmin}">
<form:form method="POST" modelAttribute="user" acceptCharset="ISO-8859-1">
<div class="row">
<input type="submit" value="Logout" class="btn btn-primary btn-lg">
</div>
		</form:form>
		</c:if>
		
		
		<br>
		-------------------------------------<br>
		GUIDA:<br>
		login      &emsp;  &emsp; &emsp; = false -> SESSION LV0<br>
		Login&emsp; &emsp; &emsp;  = true  -> SESSION LV1<br>
		LoginAdmin&emsp;= true  -> SESSION LV2<br><br>
		SESSION:<br>
		Boolean logUtente<br>
		Boolean logAdmin<br>
		List ProdottoNelCarrello listaCarrello<br>
		Utente utente
		-------------------------------------
		<br>
		<fmt:formatDate value="${data}" pattern="dd-MM-yyyy"/>
		<br>
		STATUS:<br>
		login = ${logUtente}
		<br>
		loginAdmin = ${logAdmin}
		
	
		<br><br>
		VISIBLE = LV0, LV1, LV2
		<br>
		<a href='<spring:url value="/prodotti" />' class="btn btn-primary btn-sm ">
		prodotti
		</a>
		
	<a href='<spring:url value="/prodotti/infoProdotto" />' class="btn btn-primary btn-sm ">
	infoProdotto
	</a>
	
	<a href='<spring:url value="/carrello" />' class="btn btn-primary btn-sm ">
		carrello
		</a>
		
		<br><br>
		VISIBLE: LV0&emsp; |&emsp; HIDDEN: LV1, LV2
		<br>
	<a href='<spring:url value="/registrazione" />' class="btn btn-primary btn-sm ">
	registrazione
	</a>
	<a href='<spring:url value="/registrazione/login" />' class="btn btn-primary btn-sm ">
		login
		</a>
		<br><br>
		VISIBLE: LV1&emsp;  |&emsp; HIDDEN: LV0, LV2
		<br>
		<a href='<spring:url value="/areaClienti" />' class="btn btn-primary btn-sm ">
	areaClienti
	</a>
	<br><br>
	VISIBLE: LV2&emsp;  |&emsp; HIDDEN: LV0, LV1
	<br>
	<a href='<spring:url value="/admin-prodotti" />' class="btn btn-primary btn-sm ">
		admin-prodotti
		</a>
	
	<a href='<spring:url value="/adminUtenti" />' class="btn btn-primary btn-sm ">
	adminUtenti
	</a>
	<br><br>
	FORM = LV0&emsp;  |&emsp; ADMIN = LV2&emsp;  |&emsp; HIDDEN = LV1
	<br>
	<a href='<spring:url value="/loginAdmin" />' class="btn btn-primary btn-sm ">
	loginAdmin
	</a>