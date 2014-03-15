<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>
			<div id="content-admin-main" class="formatView-table">
			
			<h1 id="admin-title"><fmt:message key="admin.trasaction"/></h1>
			
			${error}
			
			<form action="./transactionProcess" method=post>
			
			<table>
				<tr>
					<td><fmt:message key="label.account.accountid"/> : </td>
					<td>
							<input type="text" name="accountId" value="${accountId}" size=15 maxlength=20/>
							<input name="action" class="button grey" type="submit" value="Search"/>
					</td>
				</tr>
			</table>
			
			</form>
			
			<table class="center-table">
				<th>#</th>
				<th><fmt:message key="label.transaction.type"/></th>
				<th><fmt:message key="label.transaction.amount"/></th>
				<th><fmt:message key="label.transaction.depoistToAcc"/></th>
				<th><fmt:message key="label.transaction.time"/></th>
				
				<c:forEach var="t" items="${transactions}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}">
				
					<td nowrap>${status.index + 1}</td>
				
					<td nowrap>${t.transactionType}</td>
				
					<td nowrap>${t.transactionAmount}</td>
				
					<td nowrap>${t.depositToAccount}</td>					
				
					<td nowrap>${t.transactionTime}</td>
				</tr>
				</c:forEach>
			</table>
			
			</div>

			</div>
			
		
		
<%@ include file="layout/footer.jsp" %>
