<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			
			<div id="content-admin-main" class="formatView-table">
			
			<h1 id="admin-title"><fmt:message key="admin.bankbranch"/></h1>
			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<c:url var="insertURL" scope="page" value=" ./bankbranchSetup.jsp">
				<c:param name="insert" value="true"/>
			</c:url>
			<a href="${insertURL}"><fmt:message key="label.bankbranch.add"/></a>
			
			<table class="center-table">
				<th>#</th>
				<th><fmt:message key="label.bankbranch.bbid"/></th>
				<th><fmt:message key="label.bankbranch.name"/></th>
				<th><fmt:message key="label.bankbranch.location"/></th>
				<th><fmt:message key="label.bankbranch.description"/></th>
				<th><fmt:message key="page.edit"/></th>
				
			<c:forEach var="b" items="${bankbranches}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}">
					<td nowrap>${status.index + 1}</td>
					<td nowrap>${b.BBID}</td>
					<td nowrap>${b.name}</td>
					<td nowrap>${b.location}</td>
					<td nowrap>${b.description}</td>
					
					<c:url var="updateURL" scope="page" value="./bankbranchSetup.jsp">
                            <c:param name="BBID" value="${b.BBID}"/>
                            <c:param name="name" value="${b.name}"/>
                            <c:param name="location" value="${b.location}"/>
                            <c:param name="description" value="${b.description}"/>
                            <c:param name="update" value="true"/>
                    </c:url>
                    
					<td nowrap><a href="${updateURL}"><fmt:message key="page.edit"/></a></td>
					
					<%-- <c:url var="deleteURL" scope="page" value="/deleteCustomer">
                            <c:param name="nric" value="${c.nric}"/>
                    </c:url>
					
					<td nowrap><a href="${deleteURL}"><fmt:message key="page.delete"/></a></td> --%>
				</tr>
			</c:forEach>
			
			</table>
			
			</div>
			
		</div>
		
<%@ include file="layout/footer.jsp" %>