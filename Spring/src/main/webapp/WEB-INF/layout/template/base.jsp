<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100">
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet" >
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >

<%-- <link href="${pageContext.request.contextPath}/static/css/miocss.css" rel="stylesheet" /> --%>
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"  />
<link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/funzioni.js"></script>



</head>

<body onLoad="cambia()">

    
    

<div >
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="content"/>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>