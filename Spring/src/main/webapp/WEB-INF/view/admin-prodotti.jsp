<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    		
<c:if test="${!esitoRegistrazione}">
<div class="alert alert-danger" role="alert">
  Impossibile modificare: Il prodotto fa parte di un ordine in corso.
</div>
</c:if>
    <div class="row">
	<div class="col-5">
	<br><br><br>
	<a href='<spring:url value="/adminProdotti/creaProdotto?id=${prodotto.id_prodotto}"/>' class="btn btn-primary btn-sm ">
								crea Prodotto
							</a>
		<table class="table table-striped table-responsive">
			<thead>
			</thead>
			<tbody>
				<c:forEach items="${prodotti}" var="prodotto">
					<tr>
					<td class="text-left">
								${prodotto.id_prodotto}
							</td>
						<td class="text-left">
								${prodotto.nome}
							</td>
							<td class="text-left">
							${articolo.id}
								${prodotto.prezzo}€
							</td>
							<td class="text-left">
							<a href='<spring:url value="/adminProdotti/modificaProdotto?id=${prodotto.id_prodotto}"/>' class="btn btn-primary btn-sm ">
								Modifica prodotto
							</a>
						</td>
						
						
						<td class="text-left" >
							<a href='<spring:url value="/adminProdotti/eliminaProdotto?id=${prodotto.id_prodotto}"/>' class="btn btn-primary btn-sm ">
								Elimina prodotto
							</a>
						</td>
						
							

					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>