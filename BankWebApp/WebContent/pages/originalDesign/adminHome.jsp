<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/style.css" rel="stylesheet" media="screen">
	<fmt:setBundle basename="sg.com.issbank.language/messages" />
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="title"/></title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
		
			<div id="logo-box">
			<img class="displayed" align="middle" src="img/BankLogo.jpg" alt="ISS Bank">
			</div>
			
			<div id="logo-label">
				<h1 id="letterpress"><fmt:message key="title.admin"/></h1>
			</div>
		
		</div>
		
		<div id="content">
			<div id="content-left">
			
				<div id="menu">
				<ul>
					<li id="menuTitle"><fmt:message key="menu.admin"/></li>
					<li><a href="#"><fmt:message key="menu.customer"/></a></li>					
					<li><a href="#"><fmt:message key="menu.bankbranch"/></a></li>					
					<li><a href="#"><fmt:message key="menu.bankaccount"/></a></li>
					<li><a href="#"><fmt:message key="menu.transaction"/></a></li>					
				</ul>
				
				</div>
			</div>
			
			<div id="content-admin-main">
			<h1 id="admin-title"><fmt:message key="admin.customerpanel"/></h1>
			Testing
				
			</div>
			
		</div>
		
		<div id="footer">
			<fmt:message key="footer"/>	
		</div>
		
		<div id="bottom">
			
		</div>
	</div>
</body>
</html>