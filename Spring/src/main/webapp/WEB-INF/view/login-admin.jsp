<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

FORM LOGIN ADMIN

<c:if test="${!esitoLoginAdmin}">
<div class="alert alert-danger" role="alert">
  Accesso non autorizzato.
</div>
</c:if>
	<c:if test="${!logAdmin}">
	<form:form method="POST" modelAttribute="admin" acceptCharset="ISO-8859-1">
			<form:errors path="*" cssClass="alert alert-danger" element="div" id="generalAlert"/>
			<div class="row">
				<div class="col-6">
					<label for="titleSp">username:</label>
					<form:input path="username" id="usernameSp" type="text" cssClass="form-control" required="required" />
					<form:errors path="username" id="usernameSpError" cssClass="text-danger"/>
				</div>
				<div class="col-6">
					<label for="authorSp">password:</label>
					<form:input path="password" id="passwordSp" type="text" cssClass="form-control" required="required" />
					<form:errors path="password" id="passwordSpError" cssClass="text-danger"/>
				</div>
			</div>
			
			
				<div class="row">
				
				<div class="col-6 text-center">
					<input type="submit" value="Login" class="btn btn-primary mt-4">
				</div>
			</div>
		</form:form>
		</c:if>
		
<c:if test="${logAdmin}">
				<br>
				<br>
				<br>
				<a href='<spring:url value="/adminProdotti" />' class="btn btn-primary btn-sm ">
								Gestisci PRODOTTI
				</a>
				<a href='<spring:url value="adminUtenti" />' class="btn btn-primary btn-sm ">
								Gestisci UTENTI
				</a>
				<a href='<spring:url value="adminOrdini" />' class="btn btn-primary btn-sm ">
								Gestisci ORDINI
				</a>
				
				

</c:if>	
		