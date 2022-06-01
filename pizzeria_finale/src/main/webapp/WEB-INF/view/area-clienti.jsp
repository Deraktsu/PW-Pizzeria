<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <div class="container">
    <div class="row ">
	<div class="col-6">
	<c:if test="${!esitoUpdate}">
<div class="alert alert-danger" role="alert">
  Impossibile registrare: username già in uso.
</div>
</c:if>

	
		<form:form method="POST" modelAttribute="areaClientiForm" acceptCharset="ISO-8859-1">
			<div class="row" style="margin-top:20px;">
				<div class="col-6">
					<label for="nome">Nome:</label>
					<form:input path="nome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="nome" id="nameError" cssClass="text-danger"/>
				</div>
			</div>
			<div class="row" style="margin-top:20px;">
				<div class="col-6" >
					<label for="cognome">Cognome:</label>
					<form:input path="cognome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="cognome" id="nameError" cssClass="text-danger"/>
				</div>
			</div>
			
			<div class="row" style="margin-top:20px;">
				<div class="col-6">
					<label for="telefono">telefono</label>
					<form:input path="telefono" id="mail" type="mail" cssClass="form-control" required="required" />
					<form:errors path="telefono" id="mailError" cssClass="text-danger"/>
				</div>
				
			</div>
			<div class="row" style="margin-top:20px;">
				<div class="col-6">
					<label for="email">Email</label>
					<form:input path="email" id="cap" type="text" cssClass="form-control" required="required" />
					<form:errors path="email" id="capError" cssClass="text-danger"/>
				</div>
				<div class="col-6">
					<label for="password">Password</label>
					<form:input path="password" type="password" id="town"  cssClass="form-control" required="required" />
					<form:errors path="password" id="townError" cssClass="text-danger"/>
				</div>
			</div>
			<div class="row mt-4">
				<div class="col-12 text-center">

					<input type="submit" value="Aggiorna Dati" class="btn btn-primary admin2">
				</div>
			</div>
		</form:form>
	</div>
	
	<div class="col-6 " style="overflow:visible;">
		<h2>Storico degli ordini</h2>
		<c:forEach items="${ordini}" var="ordine">
		<table class="table table-striped" >
                
             	<thead>
             	<tr>
                	<th>DETTAGLI ORDINE ${ordine.id_ordine}</th>    
                </tr>
                </thead>	         
                <tbody >
                <tr>
                	<th>DATA</th>
                    <td class="text-end">${ordine.dataOrdine}</td>
                    
                </tr>
                    <tr>
                    <th>ORARIO</th>
					<td class="text-end">${ordine.orarioRitiro}</td>
					
					
				</tr>
				<tr>
					<th>TOTALE</th>
					<td class="text-end">${ordine.prezzoTotale}&nbsp;€</td>
					
				</tr>
				<tr >
					<th>PRODOTTI</th>
					<th class="text-end">PREZZO</th>
					
					<c:forEach items="${ordine.prodotti}" var="prodotto">
								<tr>
									<td>${prodotto.nome}</td>
									<td class="text-end">${prodotto.prezzo} €</td>
								</tr>
					</c:forEach>
					
					</tr>
				</tbody>
				
				</table>
				<br>
			</c:forEach>
</div>
</div>
</div>
    