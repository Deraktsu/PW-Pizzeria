<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row justify-content-center">
	<div class="col-6">
	
		<%-- <form:form method="POST" modelAttribute="utente" acceptCharset="ISO-8859-1">
			<div class="row">
				<div class="col-6">
					<label for="nome">Data ritiro:</label>
					<form:input path="nome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="nome" id="nameError" cssClass="text-danger"/>
				</div>
				<div class="col-6">
					<label for="cognome">Orario ritiro:</label>
					<form:input path="cognome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="cognome" id="nameError" cssClass="text-danger"/>
				</div>

			</div>
			<div class="row">
				<div class="col-6">
					<label for="telefono">Metodo di pagamento:</label>
					<form:input path="telefono" id="mail" type="mail" cssClass="form-control" required="required" />
					<form:errors path="telefono" id="mailError" cssClass="text-danger"/>
				</div>
				
			</div>
			
			<div class="row mt-4">
				<div class="col-12 text-center">
					<a href='<spring:url value="/prodotti" />' class="btn btn-secondary btn-lg">Torna a Prodotti</a>&emsp;
					<input type="submit" value="Registra Cliente" class="btn btn-primary btn-lg">
				</div>
			</div>
		</form:form> --%>
	</div>
</div>