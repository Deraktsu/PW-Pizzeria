<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-xs-4 col-md-4" id="sinistra" style="margin-left:auto; margin-right:auto;border:2px solid black;margin-top:20px;">
	<h1>Riepilogo Ordine</h1>
	<table class="table table-striped" >
                
             	<thead>

                </thead>	         
                <tbody >
                <tr>
                	<th style="text-align:left;">DATA</th>
                    <td style="text-align:left;"><fmt:formatDate value="${dataRiepilogo}" pattern="dd-MM-yyyy"/></td>
                    
                </tr>
                    <tr>
                    <th style="text-align:left;">ORARIO</th>
					<td style="text-align:left;">${orarioRiepilogo}</td>
				</tr>
				
				<tr >
					<th>PRODOTTI</th>
					<th style="text-align:left;">PREZZO</th>
					
					<c:forEach items="${listaRiepilogo}" var="prodotto">
								<tr>
									<td>${prodotto.nome}</td>
									<td style="text-align:left;">${prodotto.prezzo} €</td>
								</tr>
					</c:forEach>
					</tr>
					<tr>
					<th style="text-align:left;">TOTALE</th>
					<td style="text-align:left;"><b>${totaleRiepilogo}&nbsp;€</b></td>
					
				</tr>
				</tbody>
				
				</table>



            </div>
            

