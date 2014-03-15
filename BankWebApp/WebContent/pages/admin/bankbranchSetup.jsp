<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			
			<div id="content-admin-main">
			
			<h1 id="admin-title"><fmt:message key="admin.bankbranch"/></h1>
			
			<form action="./bankbranchProcess" method=post>
			<table class="center-table">
				<tr>
					<td><fmt:message key="label.bankbranch.bbid"/> : </td>
					
					<c:if test="${param['insert']==true}" >
					<td><input type="text" name="BBID" value="${param['BBID']}" size=15 maxlength=20></td>
					<input type="hidden" name="insert" value="true" />
					</c:if>
					
					<c:if test="${param['update']==true}" >
					<td><input type="text" name="BBID" value="${param['BBID']}" size=15 maxlength=20 readonly="readonly"></td>
					<input type="hidden" name="insert" value="false" />
					</c:if>

				</tr>
				<tr>
					<td><fmt:message key="label.customer.name"/> : </td>
					<td><input type="text" name="name" value="${param['name']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="label.bankbranch.location"/> : </td>
					<td><TEXTAREA NAME="location" ROWS=3 COLS=30 >${param['location']}</TEXTAREA></td>
				</tr>
				<tr>
					<td><fmt:message key="label.bankbranch.description"/> : </td>
					<td><TEXTAREA NAME="description" ROWS=3 COLS=30 >${param['description']}</TEXTAREA></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						<input class="button grey" type="submit" value="Submit"> 
						<input class="button grey" type="reset"  value="Reset">
					</td>
				</tr>
				
			</table>
			</form>
			
			</div>

			</div>
			
		
		
<%@ include file="layout/footer.jsp" %>