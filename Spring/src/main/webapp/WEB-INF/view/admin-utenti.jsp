<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br><br><br>
<c:if test="${!esitoRegistrazione}">
<div class="alert alert-danger" role="alert">
  Impossibile modificare: L'ordine non è stato ancora evaso.
</div>
</c:if>
    <div class="row">
	<div class="col-5">
		<table class="table table-striped table-responsive">
			<thead>
			</thead>
			<tbody>
			<tr>
			<td class="text-left" >ID</td>
			<td class="text-left" >NOME</td>
			<td class="text-left" >COGNOME</td>
			<td class="text-left" >TELEFONO</td>
			<td class="text-left" >USERNAME</td>
			<td class="text-left" >PASSWORD</td>
			<td></td>
			</tr>
				<c:forEach items="${utenti}" var="utente">
					<tr>
							<td class="text-left" >
							${utente.id_utente}
							</td>
							<td class="text-left" >
							${utente.nome}
							</td>
							<td class="text-left" >
							${utente.cognome}
							</td>
							<td class="text-left" >
							${utente.telefono}
							</td>
							<td class="text-left" >
							${utente.username}
							</td>
							<td class="text-left" >
							${utente.password}
							</td>
							
			
						
						
						<td class="text-left" >
							<a href='<spring:url value="/adminUtenti/eliminaUtente?id=${utente.id_utente}" />' class="btn btn-primary btn-sm ">
								Elimina
							</a>
						</td>
	
							

					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>