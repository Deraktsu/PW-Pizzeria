<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<c:url value="/static/images/slideshow-1.jpg" />" class="d-block w-100" alt="...">
                <div class="carousel-caption">
                    <h2>First slide label</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value="/static/images/slideshow-2.jpg" />" class="d-block w-100" alt="...">
                <div class="carousel-caption">
                    <h2>Second slide label</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value="/static/images/slideshow-3.jpg" />" class="d-block w-100" alt="...">
                <div class="carousel-caption">
                    <h2>Third slide label</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
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
            <b><i>Benvenuti</i> !</b>
            <p>
                La <strong>Pizzeria 5uaglioni</strong> è un locale ricco di tradizione, dove
                il profumo del basilico appena colto e la bontà dei nostri ingredienti saranno per voi un'esperienza da ricordare.
            </p>
            <p>
                Per scoprirli, effettuate un'ordinazione sul nostro sito, vi stupiremo con il nostro efficiente servizio di take away!
            </p>
        </div>
    </div>
    <div class="row" style="margin-top: 10px;" id="menu">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <div id="flip"><a> MENU' <br/> Clicca qui per espandere o per ridurre </a></div>
            <div id="panel1">
                <div class="row">
                    <div class="trigger col-xs-4 col-md-4 col-sm-4"><a href="#trigger1" id="trigger1" ><h1>PIZZE</h1></a></div>
                    <div class="trigger col-xs-4 col-md-4 col-sm-4"><a href="#trigger2" id="trigger2" ><h1>CALZONI</h1></a></div>
                    <div class="trigger col-xs-4 col-md-4 col-sm-4"><a href="#trigger3" id="trigger3" ><h1>BEVANDE</h1></a></div>
                </div>
                <div class="row">
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <div class="panel1" id="info1">
                            <div class="abbonato" id="abbonato1">
                                <table>
                                <!-- FOR EACH -->
                                <c:forEach items="${prodotti}" var="prodotto">
                                    <tr>
                                        <td class="cella">${prodotto.nome}</td>
                                        <td class="cella"> ${prodotto.prezzo}&nbsp;€</td>
                                       
                                        <td class="text-end">
                                            <a href='<spring:url value="/prodotti/infoProdotto?id=${prodotto.id_prodotto}"/>' class="btn  btn-lg"> <!-- href='<spring:url value="/bookcard?id=${book.id }" />' -->
                                                Più dettagli
                                            </a>
                                        </td>
                                        <td class="text-end">
                                            <a href='<spring:url value="/carrello/prodottoInOrdine?id=${prodotto.id_prodotto}"/>' class="btn  btn-lg"> <!-- href='<spring:url value="/bookcard?id=${book.id }" />' -->
                                                Aggiungi al carrello
                                            </a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    $(document).ready(function(){
                        $("#trigger1").on('click', function(){
                            $("#info1 ").slideToggle();
                        });
                        $("#trigger2").on('click', function(){
                            $("#info2 ").slideToggle();
                        });
                        $("#trigger3").on('click', function(){
                            $("#info3 ").slideToggle();
                        });
                    });
                </script>

                <hr> <!--fine prima riga pizze !-->
         <!--    </div>
        </div>
    </div> -->

    <!-------------------------------------------contact Section-------------->
    <footer class="contact" id="contatti">
        <div class="container">
            <div class="row">
                <div id="" class="col-4">
                    <div class="">
                        <div class="">
                            <div class="">
                                <div class="logo-footer">
                                    <a href="#" title="">
                                        <img style="width:100px;" src="image/logo.jpg">
                                    </a>
                                    <p>Più di 100 anni di storia e bontà, nel rispetto della tradizione</p>
                                    <br>
                                    <div class="social-footer">
                                        <h2>Seguici su</h2>
                                        <a href="https://www.facebook.com/DonAntonioStarita/" title="Pizzeria Facebook"><img src="<c:url value="/static/images/facebook.png" />"/></a>
                                        <a href="https://www.instagram.com/pizzeriestarita/" title="Pizzeria Instagram"><img src="<c:url value="/static/images/instagram.png" />"/></a>
                                    </div>														
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="">
                        <div class="">
                            <h2 class="">Orari di apertura</h2>
                            <div class="">
                                <div class="">
                                    <h6><a href="" title="">Napoli</a></h6>
                                    <p>12-15.30 e 19-24</p>
                                    <small>Non si effettuano prenotazioni</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="">
                        <div class="">
                            <h2 class="">Recensioni</h2>
                            <div class="">
                                <div class="">
                                    <h6><a href="" title="">Compila la tua recensione</a></h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>