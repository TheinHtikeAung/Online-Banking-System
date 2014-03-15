<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>

 		<div id="content-admin-main" class="formatView-table">
 		<form method="post" action="./trans">
 		
 		<h1 id="admin-title"><fmt:message key="title.transaction.enquiry"/></h1> 		
			<c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
			
			<table style="border:1px outset black;" cellpadding="10">
				<th>#</th>
				<%-- <th align="left"><fmt:message key="label.transaction.transactionId"/></th>
				<th align="left"><fmt:message key="label.transaction.accountId"/></th> --%>
				<th align="left"><fmt:message key="label.transaction.transactionType"/></th>
				<th align="left"><fmt:message key="label.transaction.transactionAmount"/></th>
				<th align="left"><fmt:message key="label.transaction.depositToAccount"/></th>
				<th align="left"><fmt:message key="label.transaction.transactionTime"/></th>

			<c:forEach var="c" items="${FullTransList}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}">
					<td nowrap>${status.index + 1}</td>
					<%-- <td nowrap>${c.transactionId}</td>
					<td nowrap>${c.accountId}</td> --%>
					<td nowrap>${c.transactionType}</td>
					<td nowrap>${c.transactionAmount}</td>
					<td nowrap>${c.depositToAccount}</td>
					<td nowrap>${c.transactionTime}</td>
					</tr>
					</c:forEach>
			</table>
			
			<br><hr>
			From:<input id="datepick1" size="20" name="FromDate"  /> 
			
			To:<input id="datepick2" size="20" name="ToDate" />
			
			<br>
			<script type="text/javascript" src="<c:url value='/jscripts/datepickr.js'/>"></script>
			<script type="text/javascript">
				new datepickr('datepick1');
			</script>
			<script type="text/javascript">
				new datepickr('datepick2');
			</script>
			<br>
			<input class="button grey" type="submit" value="View Transaction">
			</form>
		</div>
		
		</div>
		
<%@ include file="layout/footer.jsp" %>
