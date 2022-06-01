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
				<div class="row">
				<div class="col-6">
					<label for="descrizione">Descrizione:</label>
					<form:input path="descrizione" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="descrizione" id="nameError" cssClass="text-danger"/>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="prezzo">Prezzo</label>
					<form:input path="prezzo" id="mail" type="mail" cssClass="form-control" required="required" />
					<form:errors path="prezzo" id="mailError" cssClass="text-danger"/>
				</div>
				
			</div>
			<div class="row">
				<div class="col-6">
					<label for="categoria">Categoria</label>
					<form:radiobutton path="categoria" class="categoria" value="Pizza" checked="checked"/>PIZZA |
					<form:radiobutton path="categoria" class="categoria" value="Calzone" />CALZONE |
					<form:radiobutton path="categoria" class="categoria" value="Bevanda" />BEVANDA
					
				</div>
				
			</div>
			<div class="col-2"></div>
	
			
			<div class="row mt-4">
				<div class="col-12 text-center">
					<a href='<spring:url value="/adminProdotti" />' class="btn btn-secondary btn-lg">Torna alla lista Prodotti</a>&emsp;
					<input type="submit" value="Aggiorna Prodotto" class="btn btn-primary btn-lg">
				</div>
			</div>
		</form:form>
		
		
		<div class="col-4">
		<div class="row mt-4">
			<div class="col-12 text-center">
				<form action="upload"  method="POST" enctype="multipart/form-data">
					<h6>Seleziona e salva copertina</h6>
					<input type="hidden" id="fileName" name="fileName" value="${prodottoId}" required="required" >
					<input type="file" class="form-control mt-2" id="image" name="image" required="required">
					<input type="submit" class="btn btn-primary mt-3" value="Salva Immagine">
				</form>
			</div>
		</div>
		<div class="row mt-4">
			<div class="col-12 text-center ms-2">
				<c:choose>
					<c:when test="${hasImage}">
						<img class="img-thumbnail" style="width: 180px; height: 250px;max-width: 180px; max-height: 250px;" 
							alt="Book Image" src="<c:url value="/static/pizze/${prodottoId}.png" />">
					</c:when>
					<c:otherwise>
						<img class="img-thumbnail" style="width: 180px; height: 250px;max-width: 180px; max-height: 250px;" 
							alt="Book Image" src="<c:url value="/static/pizze/markerImage.png" />">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<div class="row mt-4">
			<div class="col-12 text-center">
				<a href='<spring:url value="/adminProdotti/cancellaImmagine?name=${prodottoId}"></spring:url>'>
					<img class="img-thumbnail ms-4" alt="Delete" src="<c:url value="/static/pizze/deleteIcon.png" />">
				</a>
			</div>
		</div>
	</div>
		
		

		