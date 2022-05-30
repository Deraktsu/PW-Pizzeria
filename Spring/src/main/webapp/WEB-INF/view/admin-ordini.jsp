<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${!esitoRegistrazione}">
<div class="alert alert-danger" role="alert">
  Impossibile modificare: L'ordine non è stato ancora evaso.
</div>
</c:if>

    <div class="row">
	<div class="col-12">
		<table class="table table-striped table-responsive">
			<thead>
			</thead>
			<tbody>
			<tr>
			<td class="text-left" >ID</td>
			<td class="text-left" >DATA ORDINE</td>
			<td class="text-left" >ORARIO RITIRO</td>
			<td class="text-left" >PREZZO TOTALE</td>
			<td class="text-left" >ID UTENTE</td>
			<td></td>
			</tr>
				<c:forEach items="${ordini}" var="ordine">
					<tr>
							
							<td class="text-left" >
							${ordine.id_ordine}
							</td>
							
							<td class="text-left" >
							${ordine.dataOrdine}
							</td>
							<td class="text-left" >
							${ordine.orarioRitiro}
							</td>
							<td class="text-left" >
							${ordine.prezzoTotale}
							</td>
							<td class="text-left" >
							${ordine.utente}
							</td>

						<td class="text-left" >
							<a href='<spring:url value="/adminOrdini/eliminaOrdine?id=${ordine.id_ordine}" />' class="btn btn-primary btn-sm ">
								Elimina
							</a>
						</td>
	
							

					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>