<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import ="sg.com.issbank.dto.BankAccount"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>
<%@ include file="layout/footer.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellSpacing="10" cellPadding="5">
<tr>
<th>Account ID </th>
<th>Account Type</th>
<th>Balance</th>
</tr>
<c:forEach var="BankAcountList" items="${requestScope.acclist}">
<tr>
<td>${BankAcountList.accountId}</td>
<td>${BankAcountList.accountType}</td>
<td>${BankAcountList.balance}</td>
</tr>
</c:forEach>
</table>

</body>
</html>