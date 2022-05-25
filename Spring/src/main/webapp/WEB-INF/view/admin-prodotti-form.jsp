<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>




	<form:form method="POST" modelAttribute="aggiornaProdottoForm" acceptCharset="ISO-8859-1">

			<div class="row">
				<div class="col-6">
					<label for="nome">Nome:</label>
					<form:input path="nome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="nome" id="nameError" cssClass="text-danger"/>
				</div>
				<div class="col-6">
					<label for="descrizione">Descrizione:</label>
					<form:input path="descrizione" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="descrizione" id="nameError" cssClass="text-danger"/>
				</div>

			</div>
			<div class="row">
				<div class="col-6">
					<label for="prezzo">Prezzo</label>
					<form:input path="prezzo" id="mail" type="mail" cssClass="form-control" required="required" />
					<form:errors path="prezzo" id="mailError" cssClass="text-danger"/>
				</div>
				
			</div>
			
			<div class="row mt-4">
				<div class="col-12 text-center">
					<a href='<spring:url value="/adminProdotti" />' class="btn btn-secondary btn-lg">Torna alla lista Prodotti</a>&emsp;
					<input type="submit" value="Aggiorna Prodotto" class="btn btn-primary btn-lg">
				</div>
			</div>
		</form:form>


