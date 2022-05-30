<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-xs-6 col-md-8" id="sinistra">
<table class="table table-striped">
                
             	<thead>
             	<tr>  
                	
                </tr>
                </thead>	         
                <tbody>
                
               
                <tr>
                	<th>DATA</th>
                    <td>${dataRiepilogo}</td>
                	<td></td>
                	
                </tr>
                
                    <tr>
                    <th>ORARIO</th>
					<td>${orarioRiepilogo}</td>
					
				</tr>
				<tr>
					<th>PREZZO</th>
					<td>${totaleRiepilogo}</td>
					
				</tr>
				<tr>
				</tr>
				<tr>
					<th>PRODOTTI:</th>
					
					<c:forEach items="${listaRiepilogo}" var="prodotto">
					<tr>
					<td>${prodotto.nome}</td>
					</tr>
					</c:forEach>
					
					</tr>
				</tbody>
				
				</table>




            </div>
            

