<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:if test="${!esitoRegistrazione}"> <div class="alert alert-danger" role="alert"> ERRORE NELLA REGISTRAZIONE </div> </c:if>

	<div class="row">
        <div class="col-12" id="titolo_signUp">
            <h2>REGISTRATI</h2>
        </div>

        <div class="col-sm-6 col-lg-12" id="cont1">
                           
                <img id="imgSignUp" src="${pageContext.request.contextPath}/static/images/pizza_signup.jpg" alt="">
            
        </div>

        <div class="col-sm-6 col-lg-12" id="cont2">
            <div id="formSignUp">
                <form:form class="row g-3"  method="POST" modelAttribute="utente" acceptCharset="ISO-8859-1">

                    <div class="col-md-6">
                        <label class="form-label">Nome: </label>
                        <form:input path="nome" class="form-control" id="nomeSigIn" required="required" placeholder=""/>
                        <form:errors path="nome" id="nameError" cssClass="text-danger"/>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Cognome: </label>
                        <form:input path="cognome" id="name" class="form-control" required="required" placeholder=""/>
                        <form:errors path="cognome" id="nameError" cssClass="text-danger"/>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Email</label>
                        <form:input path="username" id="cap" class="form-control" required="required"/>
                        <form:errors path="username" id="capError" cssClass="text-danger"/>
                    </div>
 
					<div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Password</label>
                        <form:password path="password" id="password" class="form-control" required="required"/>
                        <form:errors path="password" id="townError" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Telefono: </label>
                        <form:input path="telefono" class="form-control" id="telefSigIn" required="required" placeholder=""/>
                    </div>
                    <%-- <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Conferma Password</label>
                        <form:input path="password" id="password2" class="form-control" required="required"/>
                        <form:errors path="password" id="townError" cssClass="text-danger"/>
                    </div> --%>
                    
                    <br/><br/><br/>

                    <div class="col-12">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="privacy">
                            <label class="form-check-label">
                                Accetto i Termini e le Condizioni
                            </label>
                        </div>
                    </div>
                    <div class="col-12">
                        <button type="submit" disabled="true" class="btn btn-primary" id="button_form">Sign up</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <script>
        let casella = document.getElementById("privacy");
        casella.addEventListener("click",controlla);

        function controlla() {
            if (casella.checked) { //checked funciona como un true 
                document.getElementById("button_form").disabled=false;
            }
            else {
                document.getElementById("button_form").disabled=true;
            }
        }     
    </script>
    
