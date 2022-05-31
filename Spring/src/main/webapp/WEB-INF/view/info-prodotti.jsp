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
                        <div class="col-xs-5 col-sm-3 col-md-3 text-center align-self-center "><strong>${prodotto.nome}</strong></div>
                        <div class="col-xs-3 col-sm-4 col-md-2 text-center align-self-center " id="descr"><strong>DESCRIZIONE</strong></div>
                        <div class="col-xs-1 col-sm-1 col-md-1 text-center align-self-center " id="prez"><strong>PREZZO</strong></div>
                        <div class="col-xs-2 col-sm-2 col-md-2 text-center align-self-center "></div>
                        <div class="col-xs-1 col-sm-2 col-md-2 text-center align-self-center "></div>
                        <div class="col-xs-1 col-sm-2 col-md-2 text-center align-self-center "></div>
               </div>
               <div class="row">
                        <div class="col-xs-6 col-sm-3 col-md-3 text-center align-self-center btnDistanzaDiv"><img class="img1" style=" width: 90%; height: 100%; padding: 2px; margin: auto; text-align: center;"  src="<c:url value="/static/pizze/${prodotto.id_prodotto}.png" />"></div>
                        					<div class="col-xs-3 col-sm-2 text-center align-self-center btnDistanzaDiv" id="descrNo"><strong>DESCRIZIONE</strong></div>
                        <div class="col-xs-1 col-sm-4 col-md-2 text-center align-self-center btnDistanzaDiv">${prodotto.descrizione}</div>
                        					<div class="col-xs-1 col-sm-1 text-center align-self-center btnDistanzaDiv" id="prezNo"><strong>PREZZO</strong></div>
                        <div class="col-xs-1 col-sm-1 col-md-1 text-center align-self-center btnDistanzaDiv">${prodotto.prezzo}&nbsp;€</div>
                        <div class="col-xs-2 col-sm-2 col-md-3 text-center align-self-center btnDistanzaDiv">
                            <a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}" />' class="btn btn-primary admin2" >
                                Aggiungi al carrello
                            </a>
                        </div>
                        <div class="col-xs-2 col-sm-2 col-md-3 text-center align-self-center btnDistanzaDiv" >
                            <a href="/pizzeria/home#menu" class="btn btn-primary admin2">
                                    Torna indietro
                            </a>
                        </div>
                        
              </div>
                    
                           
                        
                </div>
            </div>
        </div>
   
</div>
