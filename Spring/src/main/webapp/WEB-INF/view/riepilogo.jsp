<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-xs-6 col-md-8" id="sinistra">
<table class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>                   
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaRiepilogo}" var="prodotto">
                <tr>
                    <td>${prodotto.nome}</td>

                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                <td>
                ${dataRiepilogo}
                </td>
                </tr>
                <tr>
                <td>
                ${orarioRiepilogo}
                </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <th>Totale:</th>
                    <td><fmt:formatNumber 
			value="${totaleRiepilogo}" 
			type="currency" 
			currencyCode="EUR" 
			currencySymbol="€" 
			maxFractionDigits="2" 
			minFractionDigits="2"
		/></td>
                </tr>
                
                </tfoot>
            </table>
            </div>

