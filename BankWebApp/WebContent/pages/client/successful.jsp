<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>

	<div id="content-admin-main" class="formatView-table">
	
	<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="success">
		Successfully Update your account balance!
	</div>
	
		<h4>Your New Balance.....</h4>
		<table>
			<tr>
				<td>AccountID : </td>
				<td>${Bank.accountId}</td>
			</tr>
			<tr>
				<td>AccountType : </td>
				<td>${Bank.accountType}</td>
			</tr>
			<tr>
				<td>Balance : </td>
				<td>${Bank.balance}</td>
			</tr>
		</table>
	
	</div>
</div>

<%@ include file="layout/footer.jsp" %>