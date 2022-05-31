<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${!esitoLoginAdmin}">
		<div class="alert alert-danger" role="alert">
  			Accesso non autorizzato.
		</div>
	</c:if>

<div class="container" style="text-align: center; margin-top: 20px">
    <div class="row" style="text-align: center">

	
	
	<c:if test="${!logAdmin}">
        <div class="col-12">
            <h2>Login Admin</h2>
        </div>
        <form:form method="POST" modelAttribute="admin" acceptCharset="ISO-8859-1" >
            <div class="container">
                <div class="row" style="text-align: center; margin-top: 20px">
                    <div class="col-md-6">
                        <label for="inputEmail4" class="form-label">Username</label>
                      
                        <form:input path="username" id="usernameSp" type="text" cssClass="form-control" required="required" />
						<form:errors path="username" id="usernameSpError" cssClass="text-danger"/>
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Password</label>
                        <form:input path="password" id="passwordSp" type="password" cssClass="form-control" required="required" />
						<form:errors path="password" id="passwordSpError" cssClass="text-danger"/>
                        
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary" id="button_form" style="margin-top: 20px; width: 20%">Login</button>
                    </div>
                </div>
            </div>
        </form:form>
        </c:if>
        
        <c:if test="${logAdmin}">
		<div class="container-fluid" style="margin-top:200px">
			<div class="row">
			<div class="col-4">
				<a href='<spring:url value="/adminProdotti" />' class="btn btn-primary admin1">
								Gestisci PRODOTTI
				</a>
			</div>
			<div class="col-4">
				<a href='<spring:url value="adminUtenti" />' class="btn btn-primary admin1">
								Gestisci UTENTI
				</a>
			</div>
			<div class="col-4" >
				<a href='<spring:url value="adminOrdini" />' class="btn btn-primary admin1">
								Gestisci ORDINI
				</a>
				</div>
			</div>
		</div>
</c:if>	
       
        
    </div>
    
    </div>