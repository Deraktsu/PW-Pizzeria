<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row mt-4">
	<div class="col-10 text-center">
	</div>
	
	<div class="container">
    
        <div class="col-12" >
            <div class="contenitore">
                <div class="row">
                    <div class="d-flex justify-content-around">
                        <div class="col-xs-5 col-sm-3 text-center align-self-center"><strong>${prodotto.nome}</strong></div>
                        <div class="col-xs-3 col-sm-2 text-center align-self-center"><strong>DESCRIZIONE</strong></div>
                        <div class="col-xs-1 col-sm-1 text-center align-self-center"><strong>PREZZO</strong></div>
                        <div class="col-xs-2 col-sm-2 text-center align-self-center"></div>
                        <div class="col-xs-1 col-sm-2 text-center align-self-center"></div>
                        <div class="col-xs-1 col-sm-2 text-center align-self-center"></div>
                    </div>
                    <div class="d-flex">
                        <div class="col-xs-6 col-sm-3 text-center align-self-center"><img class="img1" style=" width: 90%; height: 100%; padding: 2px; margin: auto; text-align: center;"  src="<c:url value="/static/pizze/${prodotto.id_prodotto}.png" />">
                        </div>
                        <div class="col-xs-1 col-sm-2 text-center align-self-center">${prodotto.descrizione}
                        </div>
                        <div class="col-xs-1 col-sm-1 text-center align-self-center">${prodotto.prezzo} €</div>
                       
                        
                    </div>
                    <div class="row" style="margin-left: 2px">
                            <div class="col-xs-2 col-sm-6 text-center align-self-center">
                                <a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}" />' class="btn btn-primary">
                                    Aggiungi al carrello
                                </a>
                            </div>
                            <div class="col-xs-2 col-sm-6 text-center align-self-center" >
                                <a href="/pizzeria/home#menu" class="btn btn-primary" style="height: 60px;">
                                    Torna indietro
                                </a>
                            </div>
                        </div>
                </div>
            </div>
        </div>
   
</div>
	
</div>
<%-- <div class="row">
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
</div> --%>