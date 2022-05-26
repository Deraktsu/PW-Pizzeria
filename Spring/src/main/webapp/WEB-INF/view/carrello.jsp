<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="row">
        <div class="col-xs-6 col-md-8" id="sinistra">
            <h2>Riassunto ordinazione </h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Prodotti</th>
                    <th>Modifiche</th>
                    <th>Quantità</th>
                    <th>Prezzo</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaCarello}" var="carrello">
                <tr>
                    <td>${carrello.nome}</td>
                    <td></td>
                    <td>${carrello.quantita}</td>
                    <td>${carrello.prezzo}€</td>
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
								Elimina ogni ${carrello.nome} dal carrello
							</a>
						</td>
						<td></td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <th>Totale:</th>
                    <td><fmt:formatNumber 
			value="${totale}" 
			type="currency" 
			currencyCode="EUR" 
			currencySymbol="€" 
			maxFractionDigits="2" 
			minFractionDigits="2"
		/></td>
                </tr>
                </tfoot>
            </table>
            <div class="text-left" >
							<c:if test="${logUtente}">
							<a href='<spring:url value="/carrello/riepilogo" />' class="btn btn-primary btn-sm ">
								Concludi l'acquisto
							</a>
							</c:if>
							</div>
                <button type="button" id="pulsante" onclick="recuperaData()">Invia ordine</button>
            
        </div>

        <div class="col-xs-6 col-md-6" id="destra">
            <form id="selezionaOrario" action="#" method="post">
					
            </form>
        </div>
    </div>
</div>



