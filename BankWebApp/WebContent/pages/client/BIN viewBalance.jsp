%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="layout/header.jsp" %>
<%@ include file="layout/footer.jsp" %>
<%@ include file="layout/menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Account Balance</title>
</head>
<body>
<table>
		<tr>
			<td>AccountID : </td><td>	 </td>
			<td>${Bank.accountId}</td>
		</tr>
		<tr>
			<td>AccountType : </td><td>	 </td>
			<td>${Bank.accountType}</td>
		</tr>
		<tr>
			<td>Balance : </td><td>	 </td>
			<td>${Bank.balance}</td>
		</tr>
	</table>
</body>
</html>