<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<c:if test="${!esitoLogin}">
<div class="alert alert-danger" role="alert">
  Accesso non autorizzato.
</div>
</c:if>

<div class="row">
    <div class="col-12" id="titolo_signUp">
        <h2>BENVENUTO!</h2>
    </div>

    <div class="col-sm-6 col-xs-12" id="cont1">
                       
            <img id="imgSignUp" src="${pageContext.request.contextPath}/static/images/pizza_signup.jpg" style="width:auto; height:auto;" alt="">
        
    </div>

    <div class="col-sm-6 col-xs-12" id="cont2">
        <div id="formSignUp">
            <form:form method="POST" modelAttribute="user" acceptCharset="ISO-8859-1" class="row g-3" >                   
                <form:errors path="*" cssClass="alert alert-danger" element="div" id="generalAlert"/>
                <div class="col-md-12">
                    <label class="form-label">Email</label>
                    <form:input path="username" style="size: 10px;" class="form-control" id="inputEmail" required="required"/>
                    <form:errors path="username" id="usernameSpError" cssClass="text-danger"/>
                </div>
                <div class="col-md-12">
                    <label class="form-label">Password</label>
                    <form:input path="password" class="form-control" id="inputPassword" required="required"/>
                    <form:errors path="password" id="passwordSpError" cssClass="text-danger"/>
                </div>

                 <br/><br/><br/><br/><br/>

                <div class="col-12" id="button_cont">
                    <button type="submit" class="btn btn-primary" id="button_SignUp">Sign In</button>
                </div>
            </form:form>

            <br/><br/>
            

            <div class="col-md-12" >
                <p id="non_account">Non hai un account?</p>
            </div>

            <div class="col-md-12 testo_link ">
                <a href='<spring:url value="/registrazione"/>'  >
                Registrati
                </a>
            </div>
        </div>
    </div>
</div>