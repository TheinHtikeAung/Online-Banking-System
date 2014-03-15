<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>

 		<div id="content-admin-main" align="center">
 		<form method="post" action="${pageContext.request.contextPath}/pinChange">
 		
 		<h1 id="admin-title"><fmt:message key="title.transaction.pinChange"/></h1>
 		 		
			<c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
			
			<table>
				<tr>
					<td><fmt:message key="label.existing.PIN"/> : </td>
					<td>
							<input type="password" name="oldPIN" size=6 maxlength="6"/>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="label.new.PIN"/> : </td>
					<td>
							<input type="password" name="newPIN" size=6 maxlength="6"/>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="label.reenter.PIN"/> : </td>
					<td>
							<input type="password" name="newPIN2" size=6 maxlength="6"/>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center"><input name="action" class="button pink" type="submit" value="Change PIN"/></td>
				</tr>
			</table>
			
			</form>
		</div>
		
		</div>
		
<%@ include file="layout/footer.jsp" %>
