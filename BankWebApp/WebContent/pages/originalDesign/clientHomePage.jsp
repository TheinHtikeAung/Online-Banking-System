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
				<h1 id="retro"><fmt:message key="title"/></h1>
			</div>
			
			<div id="login-info">
				<fmt:message key="login.title"/>
				Thein Htike Aung			
				<a id="right-margin" href="#">
				<fmt:message key="logout"/>
				</a>			
			</div>

		</div>
		
		<div id="content-box1"><p>How to create a account ?</p></div>
		<div id="content-box2"><p>Bank branches</p></div>
		<div id="content-box3"><p>About Us ?</p></div>
		
		<div id="content">
			<div id="content-left">
			
				<div id="menu">
				<ul>
					<li id="menuTitle"><fmt:message key="login"/></li>
					<li><a href="#"><fmt:message key="login.iBanking"/></a></li>					
				</ul>
				</div>
				
			</div>
			
		
		<div id="content-main">
			<table border="1">
				<tr>
					<td rowspan="2"><img src="img\Bank.jpg"></td>
					<td>
						<h1 id="content-main-h1"><fmt:message key="bank.storytitle"/></h1>
					</td>
				</tr>
				<tr>
					<td id="content-main-td">
						<fmt:message key="bank.story"/><br/>
						<a href=""><fmt:message key="bank.readmore"/></a>
					</td>
				</tr>
			</table>				
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