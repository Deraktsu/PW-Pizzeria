<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row mt-4">
	<div class="col-10 text-center">
	</div>
	
</div>

<div class="row">
	<div class="col-4">
		<table class="table table-striped table-responsive">
			<thead>
				<tr class="table-primary">
					<th>CARRELLO</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaCarello}" var="carrello">
					<tr>
					
						<td>${carrello.nome}</td>
						<td>${carrello.prezzo}€</td>
						<td>${carrello.quantita}</td>
						<td class="text-left" >
							<a href='<spring:url value="/carrello/diminuisciQuantita?id=${carrello.id_prodotto}" />' class="btn btn-primary btn-sm ">
								-
							</a>
						</td>
						<td class="text-left" >
							<a href='<spring:url value="/carrello/aumentaQuantita?id=${carrello.id_prodotto}" />' class="btn btn-primary btn-sm ">
								+
							</a>
						</td>
						<td class="text-left" >
							<a href='<spring:url value="/carrello/eliminaDalCarrello?id=${carrello.id_prodotto}" />' class="btn btn-primary btn-sm ">
								Elimina tutte le ${carrello.nome} dal carrello
							</a>
						</td>
						<td></td>
					</tr>
				</c:forEach>
				<tr>
				<td>Totale: 
				<fmt:formatNumber 
			value="${totale}" 
			type="currency" 
			currencyCode="EUR" 
			currencySymbol="€" 
			maxFractionDigits="2" 
			minFractionDigits="2"
		/>
		</td>
		<td class="text-left" >
							<a href='<spring:url value="/prodotti/" />' class="btn btn-primary btn-sm ">
								Ritorna al menu
							</a>
							</td>
							
							<td class="text-left" >
							<c:if test="${logUtente}">
							<a href='<spring:url value="/carrello/riepilogo" />' class="btn btn-primary btn-sm ">
								Concludi l'acquisto
							</a>
							</c:if>
							</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>