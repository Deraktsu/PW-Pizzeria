<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



    <div  id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<c:url value="/static/images/slideshow-1.jpg" />" class="d-block w-100" alt="...">
                <div class="carousel-caption" >
                    <h2 style="color: lime; background-color: rgba(0, 0, 0, 0.5);">Provate il nostro Take Away!</h2>
                    <p style="font-size:20px ; color: lime; background-color: rgba(0, 0, 0, 0.5);">Veniteci a trovare nel nostro locale a Torino</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value="/static/images/slideshow-2.jpg" />" class="d-block w-100" alt="...">
                <div class="carousel-caption">
                    <h2 style="color: white; background-color: rgba(0, 0, 0, 0.5);">Provate il nostro Take Away!</h2>
                    <p style="font-size:20px ; color: white; background-color: rgba(0, 0, 0, 0.5);">Scopri le nostre nuove offerte</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value="/static/images/slideshow-3.jpg" />" class="d-block w-100" alt="...">
                <div class="carousel-caption">
                    <h2 style="color: rgb(255,205,57);; background-color: rgba(0, 0, 0, 0.5);">Provate il nostro Take Away!</h2>
                    <p style="font-size:20px ; color: rgb(255,205,57);; background-color: rgba(0, 0, 0, 0.5);">Raccontateci la vostra esperienza con il nostro servizio</p>
                </div>
            </div>

        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- row, senza essere contenuta in un altro container oltre a quello principale(container-fluid) occupa tutto lo spazio della pagina -->
    <div class="row" style="margin-top: 30px">
        <div class="col-6"><img src="<c:url value="/static/images/locale.jpg" />" style=" width: 100%;" alt="Julia Roberts"></div>
        <div class="col-6" id="benvenuto">
            <b><i>Benvenuti alla Pizzeria 5uaglioni</i> !</b>
            <p>
                La <strong>Pizzeria 5uaglioni</strong> è un locale ricco di tradizione, dove
                il profumo del basilico appena colto e la bontà dei nostri ingredienti saranno per voi un'esperienza da ricordare.
            </p>
            <p>
                Per scoprirli, effettuate un'ordinazione sul nostro sito, vi stupiremo con il nostro efficiente servizio di take away!
            </p>
        </div>
    </div>
    
    
    
    
     <div class="container-fluid" id="index">
    <div class="col-xs-12 col-sm-12 col-md-12" id="menu">
  <div id="flip"><a> MENU' <br/> Clicca qui per espandere o per ridurre </a></div>
    <div id="panel1">
      <div class="col-xs-12 col-sm-12 col-md-12">
        <div class="row">
          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4 ">
            <div class="trigger col-12">
              <a href="#trigger1" id="trigger1" ><h1>PIZZE</h1></a>
            </div>
            <div class="col-12">
              <div class="panel1" id="info1">
                <div id="prodotti1">
                  <table>
                  <tbody>
                      <c:forEach items="${prodotti}" var="prodotto">
                                    <c:if test="${prodotto.categoria == 'Pizza' }">
                                    <tr class="cella1">
                                        <td>${prodotto.nome}</td>
                                        <td> ${prodotto.prezzo}&nbsp;€</td>
                                        <td class="bottoni">
                                            <a href='<spring:url value="/home/infoProdotto?id=${prodotto.id_prodotto}"/>' class="btn"> <!-- href='<spring:url value="/bookcard?id=${book.id }" />' -->
                                                <i class="bi bi-info-square" title="Più dettagli"></i>
                                            </a>
                                        </td>
                                        <td class="bottoni">
                                           <a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}"/>' class="btn " >
                                           		<i class="bi bi-cart-plus" title="Aggiungi al carrello"></i>
                                           </a>
                                     </td>
                                    </tr>
                                    </c:if>
							</c:forEach>
							</tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4 ">
            <div class="trigger col-12">
              <a href="#trigger2" id="trigger2" ><h1>CALZONI</h1></a>
            </div>
            <div class="col-12">
              <div class="panel1" id="info2">
                <div id="prodotti2">
                  <table>
                      <c:forEach items="${prodotti}" var="prodotto">
                                    <c:if test="${prodotto.categoria == 'Calzone' }">
                                    <tr class="cella1">
                                        <td>${prodotto.nome}</td>
                                        <td> ${prodotto.prezzo}&nbsp;€</td>
                                       
                                        <td class="bottoni">
                                            <a href='<spring:url value="/home/infoProdotto?id=${prodotto.id_prodotto}"/>' class="btn"> <!-- href='<spring:url value="/bookcard?id=${book.id }" />' -->
                                                <i class="bi bi-info-square" title="Più dettagli"></i>
                                            </a>
                                        </td>
                                        <td class="bottoni">
                                           <a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}"/>' class="btn " >
                                           		<i class="bi bi-cart-plus" title="Aggiungi al carrello"></i>
                                           </a>
                                     </td>
                                    </tr>
                                    </c:if>
							</c:forEach>
                  </table>
                </div>
              </div>
            </div>
          </div>

          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4 ">
            <div class="trigger col-12">
              <a href="#trigger3" id="trigger3" ><h1>BEVANDE</h1></a>
            </div>
            <div class="col-12">
              <div class="panel1" id="info3">
                <div id="prodotti3">
                  <table>
				   <c:forEach items="${prodotti}" var="prodotto">
                                    <c:if test="${prodotto.categoria == 'Bevanda' }">
                                    <tr class="cella1">
                                        <td>${prodotto.nome}</td>
                                        <td> ${prodotto.prezzo}&nbsp;€</td>
                                       
                                        <td class="bottoni">
                                            <a href='<spring:url value="/home/infoProdotto?id=${prodotto.id_prodotto}"/>' class="btn"> <!-- href='<spring:url value="/bookcard?id=${book.id }" />' -->
                                                <i class="bi bi-info-square" title="Più dettagli"></i>
                                            </a>
                                        </td>
                                        <td class="bottoni">
                                           <a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}"/>' class="btn " >
                                           		<i class="bi bi-cart-plus" title="Aggiungi al carrello"></i>
                                           </a>
                                     </td>
                                    </tr>
                                    </c:if>
							</c:forEach>
                  </table>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
<div class="container">
  <a class="btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo" aria-controls="offcanvasRight">
    Toggle Right Offcanvas
  </a>
</div>


 
    <div class="offcanvas offcanvas-end" id="demo">
  <div class="offcanvas-header">
    <h1 class="offcanvas-title">CARRELLO</h1>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas"></button>
  </div>
  <div class="offcanvas-body">
   <c:if test="${aggiunto}">
           <div class="col-xs-6 col-md-8" id="">
            
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
                <c:forEach items="${listaCarrello}" var="carrello">
                <tr>
                    <td>${carrello.nome}</td>
                    <td></td>
                    <td>${carrello.quantita}</td>
                    <td>${carrello.prezzo}€</td>
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
				<a href="/pizzeria/carrello" class="btn " >
                    <i class="bi bi-cart" title="Carrello">Vai al Carrello</i>
                </a>
				</div>
				
	</c:if>	

  </div>
</div>
   
   
   <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">   <div class="offcanvas-header">     <h5 id="offcanvasRightLabel">Il tuo carrello</h5>     <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>   </div>   <div class="offcanvas-body" id="offcanvas-corpo">    </div> </div>
    <!-------------------------------------------contact Section-------------->
    
                
           
		</div>