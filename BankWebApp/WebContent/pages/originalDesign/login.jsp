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
		
		<div id="login">
		<h1 id="welcome"><fmt:message key="login.welcome"/></h1>
			<form method="post" action="./login">
			<table>
				<tr>
					<td><fmt:message key="login.user"/></td>
					<td><input type="text" name="userId" value="" placeholder="User ID"></td>
				</tr>
				<tr>
					<td><fmt:message key="login.password"/></td>
					<td><input type="password" name="password" value="" placeholder="Password"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="loginbutton" class="button white" value="Log in" type="submit">
						<input id="loginbutton" class="button white" name="cancel" value="Cancel" type="button">
					</td>
				</tr>
			
			</table>
			</form>
		</div>
		
		<div id="footer">
			<fmt:message key="footer"/>	
		</div>
		
		<div id="bottom">
			
		</div>
	</div>
</body>
</html>