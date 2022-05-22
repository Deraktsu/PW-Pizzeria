<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
PAGINA INDEX

<c:if test="${loggato}">
<form:form method="POST" modelAttribute="user" acceptCharset="ISO-8859-1">
<div class="row">
<input type="submit" value="Logout" class="btn btn-primary btn-lg">
</div>
		</form:form>
		</c:if>
