<%@ include file="layout/header.jsp" %>
		
		<div id="login">
		<h1 id="welcome"><fmt:message key="login.welcome"/></h1>
 		<c:if test="${!empty message}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${message}</div>
		</c:if> 

			<form method="post" action="/issbank/login">
			<table>
				<tr>
					<td><fmt:message key="login.user"/></td>
					<td><input type="text" name="id" value="" placeholder="User ID"></td>
				</tr>
				<tr>
					<td><fmt:message key="login.password"/></td>
					<td><input type="password" name="pwd" placeholder="Password"></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input id="loginbutton" class="button white" value="Log in" type="submit"/>
						<!-- <input id="loginbutton" class="button white" name="cancel" value="Cancel" type="button"> -->
					</td>
				</tr>
			
			</table>
			</form>
		</div>
		
<%@ include file="layout/footer.jsp" %>