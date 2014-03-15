<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<c:url value='/css/style.css'/>" rel="stylesheet" media="screen">
	
	<fmt:setBundle basename="sg.com.issbank.language/messages" />
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="title"/></title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
		
			<div id="logo-box" style="border: 0px;">
			<img class="displayed" align="middle" src="<c:url value='/img/BankLogo.jpg'/>" alt="ISS Bank">
			</div>
			
			<div id="logo-label" style="border: 0px;">
				<h1 id="letterpress"><fmt:message key="title.admin"/></h1>
			</div>
		</div>
		
	