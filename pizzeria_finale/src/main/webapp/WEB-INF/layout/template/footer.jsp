<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${!logAdmin}">
<br><br>
<footer class="contact" id="contatti">
        <div class="container">
            <div class="row">
                <div id="" class="col-4">
                    <div class="">
                        <div class="">
                            <div class="">
                                <div class="logo-footer">
                                    
                                    
                                    <div class="social-footer">
                                        <h2>Seguici su</h2>
                                        <a href="https://www.facebook.com/DonAntonioStarita/" title="Pizzeria Facebook" target="_blank"><img src="${pageContext.request.contextPath}/static/images/facebook.png" /></a>
                                        <a href="https://www.instagram.com/pizzeriestarita/" title="Pizzeria Instagram" target="_blank"><img src="${pageContext.request.contextPath}/static/images/instagram.png" /></a>
                                    </div>														
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="">
                        <div class="">
                            <h2 class="">Contatti</h2>
                            <div class="">
                                <div class="">
                                    <p>Lunedi - Sabato | 11.00 - 22.00</p>
                                    <p>Via Claudio Luigi Berthollet, 20, 10125 Torino TO</p>
                                   <p>partita IVA 86334519757</p>
                                    <h6><a href="https://goo.gl/maps/Q8CNf4mEYus5caW19" target="_blank" >Torino</a></h6>
                                    <br><br>
                                    <a href="tel: 0171 0987656" target="_blank" ><i class="fas fa-solid fa-phone"></i>&nbsp; 0171 0987656</a>
                                    <br><br>
                                    <a href="mailto: info@5uaglioni.it?subject=Richiesta%20informazioni%20" target="_blank"><i class="fas fa-solid fa-envelope"></i>&nbsp;info@5uaglioni.it</a>
                                    
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
                                    <h6><a href="https://www.tripadvisor.it/Restaurant_Review-g187855-d19695315-Reviews-UAO_Pizza-Turin_Province_of_Turin_Piedmont.html" title="" target="_blank">Compila la tua recensione</a></h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" style="text-align: center">
        <a href="/pizzeria/home" title="">
                                    
                                        <img style="width:100px;" src="${pageContext.request.contextPath}/static/images/4.png" />
                                    </a>
                                    </div>
    </footer>
</c:if>