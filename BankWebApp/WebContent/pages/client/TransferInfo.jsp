<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>

	<div id="content-admin-main" class="formatView-table">
	
	<h1 id="admin-title"><fmt:message key="title.transfer.info"/></h1>
	
	<form method="post" action="${pageContext.request.contextPath }/transferInfoController">
	
	<table>
		<tr>
			<td><fmt:message key="transfer.account.type"/> :</td>
		    <td>
		    	<select id="accountType111" name="accountType111">
				<option value="" selected>-----select-----</option>
				<option value="Checking Account">Checking Account</option>
				<option value="Saving Account">Saving Account</option>
				</select>
		    </td>
		<tr>
			<td><fmt:message key="transfer.branch"/> :</td>
			<td>
				<select id="branch" name ="branch">
				<c:forEach items="${sessionScope.bankBranchName}" var="bball">
					<option value="${bball.name }">${bball.name}</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<%
		String st=request.getParameter("Account Type");
		if(st!=null){
		    out.println("You have selected: "+st);
		}
		%>
		<tr>
			<td><fmt:message key="transfer.name"/> :</td>
			<td><INPUT TYPE="TEXT" NAME="name"></td>
		</tr>
		<%-- <tr>
			<td><fmt:message key="transfer.from.acc"/> :</td>
			<td><INPUT TYPE="TEXT" NAME="fromAcc"></td>
		</tr> --%>
		<tr>
			<td><fmt:message key="transfer.to.acc"/> :</td>
			<td><INPUT TYPE="TEXT" NAME="toAcc"></td>
		</tr>
		<tr>
			<td><fmt:message key="transfer.email"/> :</td>
			<td><INPUT TYPE="TEXT" NAME="email"></td>
		</tr>
		<tr>
			<td><fmt:message key="transfer.amount"/> :</td>
			<td><INPUT TYPE="TEXT" NAME="amount"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input class="button grey" TYPE="SUBMIT" value="Next"></td>
		</tr>

	</table>
	</FORM>
	
	</div>
</div>
	
<%@ include file="layout/footer.jsp" %>
	