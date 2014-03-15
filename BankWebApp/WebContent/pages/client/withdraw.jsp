<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>

	<div id="content-admin-main" align="center">
	
	<h1 id="admin-title">Withdraw</h1>
	
	<form method=post action="./wsuccess">
	<table>
		<tr>
			<td>AccountID :</td>
			<td>${Bank.accountId}
			<input type="hidden" name="accountId" value="${Bank.accountId}"/>
		</td>
		</tr>
		<tr>
			<td>AccountType :</td>
			<td>${Bank.accountType}</td>
			<input type="hidden" value="${Bank.accountType}" name="accountType"/>
		</tr>
		<tr>
			<td>Balance :</td>
			<td>${Bank.balance}</td>
		</tr>
		
		<tr>
			<td>Withdraw Amount :</td>
			<td><input name="amount" type="text" /></td>
		</tr>
		<tr>
			<td>PIN :</td>
			<td><input name="pin" type="password" /></td>
		</tr>
		<tr align="center">
			<td colspan="2" align="center"><input class="button grey" type="submit" value="Submit" /></td>
		</tr>
		
	</table>
	</form>
		
	<h3>${error}</h3></center>
	</div>
	
	</div>

<%@ include file="layout/footer.jsp" %>