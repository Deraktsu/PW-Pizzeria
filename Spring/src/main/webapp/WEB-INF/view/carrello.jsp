<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container">
    <div class="row">
        <div class="col-xs-6 col-md-6" id="sinistra">
            <h2>Riassunto ordinazione </h2>
            <table class="table table-striped" style="width:10%;">
                <thead>
                <tr>
                    <th>Prodotti</th>
                    <th>Modifiche</th>
                    <th>Quantità</th>
                    <th>Prezzo</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaCarrello}" var="carrello">
                <tr>
                    <td>${carrello.nome}</td>
                    <td></td>
                    <td>${carrello.quantita}</td>
                    <td>${carrello.prezzo} €</td>
                	<td title="Dimunisci quantita di 1" class="text-left">
							<a href='<spring:url  value="/carrello/diminuisciQuantita?id=${carrello.id_prodotto}" />' class="btn">
								<i class="fas fa-regular fa-circle-minus"></i>
							</a>
						</td>
						<td class="text-left" title="Aumenta quantita di 1">
							<a href='<spring:url value="/carrello/aumentaQuantita?id=${carrello.id_prodotto}" />' class="btn">
								<i class="fas fa-regular fa-circle-plus"></i>
							</a>
						</td>
						<td class="text-left" title="Elimina tutte le ${carrello.nome}">
							<a href='<spring:url value="/carrello/eliminaDalCarrello?id=${carrello.id_prodotto}" />' class="btn ">
								<i class="fas fa-regular fa-trash-can"></i>
							</a>
						</td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    
                    <th>Totale:</th>
                    <td><fmt:formatNumber 
			value="${totale}" 
			type="currency" 
			currencyCode="EUR" 
			currencySymbol="€" 
			maxFractionDigits="2" 
			minFractionDigits="2"
		/></td>
		<td></td>
                    <td></td>
                </tr>
                
                </tfoot>
            </table>
            <c:if test="${!carrelloVuoto}">
            <form name="modulo" action="#" method="post">
                <button type="button" id="pulsante" onclick="recuperaData()">Seleziona orario di ritiro</button>
            </form>
            </c:if>
        </div>

        <div class="col-xs-6 col-md-6" id="destra">

            <form name="form_data" id="seleziona" action="" method="post">
                <!-- sempre prima il form e poi i div su cui operiamo in Javascript -->
                <div class="row" style="padding: 10px;">
                    <div class="col-12" id="titoloFormSeleziona">
                    </div>
                </div>
                <div class="row d-flex align-items-center">
                    <div class="col-6" id="divGiorno" style=""></div>
                    <div class="col-6" id="divOrario" style=""></div>
                </div>
            </form>
        </div>
        <div id="orario_finale" style=" font-size:16px;   background-color: rgb(255,205,57);">

        </div>


    </div>
</div>


