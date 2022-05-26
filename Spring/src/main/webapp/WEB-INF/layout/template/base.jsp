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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"  />

<link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" />


</head>

<body class="d-flex flex-column h-100">

    
    

<div class="container">
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="content"/>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>