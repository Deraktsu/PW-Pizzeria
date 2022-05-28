<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row mt-4">
	<div class="col-10 text-center">
	</div>
	<br><br><br><br>
</div>
<div class="row">
	<div class="col-5">
		<table class="table table-striped table-responsive">
			<thead>
			</thead>
			<tbody>
					<tr>
					<td>
					<img class="img-thumbnail" style="width: 180px; height: 250px;max-width: 180px; max-height: 250px;" 
							alt="Prodotto" src="<c:url value="/static/pizze/${prodotto.id_prodotto}.png" />">
					</td>
					<td class="text-left" >
								${prodotto.descrizione}
							</td>
						<td class="text-left" >
								${prodotto.prezzo}€
							</td>
							<td class="text-left" >
							<a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}" />' class="btn btn-primary btn-sm ">
								Acquista subito
							</a>
						</td>
				</tr>
			</tbody>
		</table>		
		
	</div>
</div>