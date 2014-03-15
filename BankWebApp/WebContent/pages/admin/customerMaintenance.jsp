<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			
			<div id="content-admin-main" class="formatView-table">
			
			<h1 id="admin-title"><fmt:message key="admin.customerpanel"/></h1>
			
			
			
			<c:url var="insertURL" scope="page" value="/admin/customerSetup.jsp">
				<c:param name="insert" value="true"/>
			</c:url>
			
			<form action="${pageContext.request.contextPath}/admin/searchCustomer" method="post">
				<a style="margin-left: 40px;" href="${insertURL}"><fmt:message key="label.customer.add"/></a>
				
				<input style="margin-top:10px; margin-left: 120px;" type="text" placeholder="Type NRIC" name="keyword" value="${keyword}" size=15 maxlength=20 />
				<input style="margin-left: 10px;" class="button grey" type="submit" value="Search"/>
			
				<a class="button grey" href="./customerMaintenance">Show All</a>
			</form>
			
			
			<table class="center-table">
				<th>#</th>
				<th><fmt:message key="label.customer.nric"/></th>
				<th><fmt:message key="label.customer.name"/></th>
				<th><fmt:message key="label.customer.dob"/></th>
				<th><fmt:message key="label.customer.gender"/></th>
				<th><fmt:message key="page.edit"/></th>
				<th><fmt:message key="label.bankAccount"/></th>
				
			<c:forEach var="c" items="${customers}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}">
					<td nowrap>${status.index + 1}</td>
					<td nowrap>${c.nric}</td>
					<td nowrap>${c.name}</td>
					<td nowrap>${c.dateOfBirth}</td>
					<td nowrap>${c.gender}</td>
					
					<c:url var="updateURL" scope="page" value="/admin/customerSetup.jsp">
                            <c:param name="nric" value="${c.nric}"/>
                            <c:param name="name" value="${c.name}"/>
                            <c:param name="address" value="${c.address}"/>
                            <c:param name="dateOfBirth" value="${c.dateOfBirth}"/>
                            <c:param name="nationality" value="${c.nationality}"/>
                            <c:param name="gender" value="${c.gender}"/>
                            <c:param name="userid" value="${c.userid}"/>
                            <c:param name="password" value="${c.password}"/>
                            <c:param name="dateOfJoining" value="${c.dateOfJoining}"/>
                            <c:param name="update" value="true"/>
                    </c:url>
                    
					<td nowrap><a href="${updateURL}"><fmt:message key="page.edit"/></a></td>
					
					<c:url var="manageURL" scope="page" value="/admin/accountMaintenance">
                            <c:param name="nric" value="${c.nric}"/>
                    </c:url>
					
					<td nowrap><a href="${manageURL}"><fmt:message key="page.manage"/></a></td>
				</tr>
			</c:forEach>
			
			</table>
			
			</div>
			
		</div>
		
<%@ include file="layout/footer.jsp" %>