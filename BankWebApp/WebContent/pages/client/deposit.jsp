<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>

	<div id="content-admin-main" align="center">
	
	<h1 id="admin-title">Deposit</h1>
	
	<c:if test="${!empty error}">
		<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
	</c:if>
	
	<form id="deposit-content" method="post" action="${pageContext.request.contextPath}/deposit">
	
		<table>
			<tr>
				<td>Enter the amount to deposit:</td> 
				<td> <input type="text" name="amount"/></td>
			</tr>
			<tr>
				<td>Enter Pin:</td>
				<td> <input type="password" name="pin"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2"> 
					<input class="button grey" type="submit" value="Deposit"/>
				</td>
			</tr>
		</table>
	
	</form>
	
	</div>
	
	</div>

<%@ include file="layout/footer.jsp" %>