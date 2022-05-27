<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-lg-12" id="cont1">
        
            <img id="img_signUp" src="<c:url value="/static/images/julia-roberts-pizza.gif" />" alt="">
        </div>
<c:if test="${!esitoRegistrazione}">
<div class="alert alert-danger" role="alert">
  Impossibile aggiornare: username già in uso.
</div>
</c:if>
        <div class="col-sm-6 col-lg-12" id="cont2">
        <div id="form_SigIn">
        <div class="row g-3">
                <form:form method="POST" modelAttribute="utente" acceptCharset="ISO-8859-1">
                	<div class="col-md-6">
					<label for="nome">Nome:</label>
					<form:input path="nome" id="nomeSigIn" type="text" cssClass="form-control" required="required" />
					<form:errors path="nome" id="nameError" cssClass="text-danger"/>
				</div>
				<div class="col-md-6">
					<label for="cognome">Cognome:</label>
					<form:input path="cognome" id="name" type="text" cssClass="form-control" required="required" />
					<form:errors path="cognome" id="nameError" cssClass="text-danger"/>
				</div>
                <!-- asdasdasdsddasdds -->
                    
				<div class="col-md-6">
					<label for="telefono">telefono</label>
					<form:input path="telefono" id="mail" type="mail" cssClass="form-control" required="required" />
					<form:errors path="telefono" id="mailError" cssClass="text-danger"/>
				</div>
				
			
			
				<div class="col-md-6">
					<label for="email">Email</label>
					<form:input path="email" id="cap" type="text" cssClass="form-control" required="required" />
					<form:errors path="email" id="capError" cssClass="text-danger"/>
				</div>
				<div class="col-md-6">
					<label for="password">Password</label>
					<form:input path="password" id="town" type="text" cssClass="form-control" required="required" />
					<form:errors path="password" id="townError" cssClass="text-danger"/>
				</div>
			

                    <!-- <div class="col-md-4">
                        <label for="inputState" class="form-label">State</label>
                        <select id="inputState" class="form-select">
                            <option selected>Choose...</option>
                            <option>...</option>
                        </select>
                    </div> -->

                   <!--  <div class="col-md-6">
                        <label class="form-label">Genere: </label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                                   id="flexRadioDefault1" value="option1" checked>
                            <label class="form-check-label">
                                Donna
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                                   value="option2">
                            <label class="form-check-label">
                                Uomo
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                                   value="option3">
                            <label class="form-check-label">
                                Altro
                            </label>
                        </div>

                    </div> -->

                    <!-- <div class="col-md-12">
                        <label class="form-label">Carta di credito: </label>
                        <input type="text" class="form-control" id="inputCartaCredito" placeholder="">
                    </div> -->

                    <div class="col-12">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="privacy">
                            <label class="form-check-label" >
                                Accetto i Termini e le Condizioni
                            </label>
                        </div>
                    </div>
                    <div class="col-12 text-center">
					<a href='<spring:url value="/home" />' class="btn btn-secondary btn-lg" id="button_form">Torna alla home</a>&emsp;
					<input type="submit" value="Sign up" class="btn btn-primary btn-lg">
					</div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</div>