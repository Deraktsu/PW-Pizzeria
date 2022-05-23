<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="row mt-4">
	<div class="col-10 text-center">
	</div>
	
</div>


<div class="row">
	<div class="col-5">
		<table class="table table-striped table-responsive">
			<thead>
			</thead>
			<tbody>
				<c:forEach items="${prodotti}" var="prodotto">
					<tr>
						<td class="text-left">
							${articolo.id}
								${prodotto.nome}
							</td>
							<td class="text-left">
							${articolo.id}
								${prodotto.prezzo}€
							</td>
							<td class="text-left">
							<a href='<spring:url value="/prodotti/infoProdotto?id=${prodotto.id_prodotto}"/>' class="btn btn-primary btn-sm ">
								mostra dettagli
							</a>
						</td>
						
						
						<td class="text-left" >
							<a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}"/>' class="btn btn-primary btn-sm ">
								Acquista subito
							</a>
						</td>
						
							

					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>