<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row justify-content-center">
	<div class="col-6">
		<form:form method="POST" modelAttribute="utente" acceptCharset="ISO-8859-1">
			<div class="row">
				<div class="col-6">
					<label for="nome">Nome:</label>
					<form:input path="nome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="nome" id="nameError" cssClass="text-danger"/>
				</div>
				<div class="col-6">
					<label for="cognome">Cognome:</label>
					<form:input path="cognome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="cognome" id="nameError" cssClass="text-danger"/>
				</div>

			</div>
			<div class="row">
				<div class="col-6">
					<label for="telefono">telefono</label>
					<form:input path="telefono" id="mail" type="mail" cssClass="form-control" required="required" />
					<form:errors path="telefono" id="mailError" cssClass="text-danger"/>
				</div>
				
			</div>
			<div class="row">
				<div class="col-4">
					<label for="username">Username</label>
					<form:input path="username" id="cap" type="text" cssClass="form-control" required="required" />
					<form:errors path="username" id="capError" cssClass="text-danger"/>
				</div>
				<div class="col-8">
					<label for="password">Password</label>
					<form:input path="password" id="town" type="text" cssClass="form-control" required="required" />
					<form:errors path="password" id="townError" cssClass="text-danger"/>
				</div>
			</div>
			<div class="row mt-4">
				<div class="col-12 text-center">
					<a href='<spring:url value="/customers" />' class="btn btn-secondary btn-lg">Torna indietro</a>&emsp;
					<input type="submit" value="Registra Cliente" class="btn btn-primary btn-lg">
				</div>
			</div>
		</form:form>
	</div>
</div>
