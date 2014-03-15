<%@ include file="layout/header.jsp" %>
<div id="login">
<h1 id="welcome"><fmt:message key="title.account.selection"/></h1>
	<table>
		<tr>
			<td>NRIC :</td>
			<td><input type="text" name="NRIC"
				value=${ sessionScope.aidlist[0].nric} readonly></td>
		</tr>
		<tr>
			<td style="margin-bottom: 10px;">AccountList : </td>
			<td align="center">
			
			<c:forEach var="list" items="${ sessionScope.aidlist }">
				<a href="${pageContext.request.contextPath }/login?accountId=${list.accountId}">${ list.accountId }</a><br/>
			</c:forEach>
			
			</td>
		</tr>
	</table>
</div>

<%@ include file="layout/footer.jsp" %>