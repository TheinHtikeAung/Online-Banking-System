<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			
			<div id="content-admin-main" class="formatView-table">
			
			<h1 id="admin-title"><fmt:message key="admin.bankaccount"/></h1>
			
			<table class="info-table">
				<th colspan="2">Customer Detail</th>
				
				<tr>
					<td style="width: 100px;"><fmt:message key="label.customer.nric"/> :</td>
					<td>${customer.nric}</td>
				<tr></tr>
					<td><fmt:message key="label.customer.name"/> :</td>
					<td>${customer.name}</td>
				<tr></tr>	
					<td><fmt:message key="label.customer.dob"/> :</td>
					<td>${customer.dateOfBirth}</td>
				<tr></tr>
					<td><fmt:message key="label.customer.gender"/> :</td>
					<td>${customer.gender}</td>
				<tr></tr>	
					<td><fmt:message key="label.customer.userid"/> :</td>
					<td>${customer.userid}</td>
				<tr></tr>	
					<td><fmt:message key="label.customer.nationality"/> :</td>
					<td>${customer.nationality}</td>
				<tr></tr>	
					<td><fmt:message key="label.customer.address"/> :</td>
					<td>${customer.address}</td>
				<tr></tr>	
					<td><fmt:message key="label.customer.join"/> :</td>
					<td>${customer.dateOfJoining}</td>
				</tr>
			</table>
			
			
			<table style="width: 555px;" class="center-table">
				<th>#</th>
				<th><fmt:message key="label.account.accountid"/></th>
				<th><fmt:message key="label.account.accountType"/></th>
				<th><fmt:message key="label.account.balance"/></th>
				<th><fmt:message key="label.account.bbid"/></th>
				<th><fmt:message key="page.edit"/></th>
				
			<c:forEach var="a" items="${bankaccounts}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}">
					<td nowrap>${status.index + 1}</td>
					<td nowrap>${a.accountId}</td>
					<td nowrap>${a.accountType}</td>
					<td nowrap>${a.balance}</td>
					<td nowrap>${a.BBID}</td>
					
					<c:url var="updateURL" scope="page" value="./accountSetup.jsp">
                            <c:param name="accountId" value="${a.accountId}"/>
                            <c:param name="accountType" value="${a.accountType}"/>
                            <c:param name="balance" value="${a.balance}"/>
                            <c:param name="BBID" value="${a.BBID}"/>
                            <c:param name="PIN" value="${a.PIN}"/>
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
			
			<c:url var="insertURL" scope="page" value=" ./accountSetup.jsp">
				<c:param name="insert" value="true"/>
			</c:url>
			<a style="margin-left: 50px;" href="${insertURL}"><fmt:message key="label.account.add"/></a>
			
			<c:url var="jointURL" scope="page" value=" ./accountJoint.jsp">
				<%-- <c:param name="insert" value="true"/> --%>
			</c:url>
			<a style="margin-left: 230px;" href="${jointURL}"><fmt:message key="label.account.joint"/></a>
			
			
			</div>
			
		</div>
		
<%@ include file="layout/footer.jsp" %>