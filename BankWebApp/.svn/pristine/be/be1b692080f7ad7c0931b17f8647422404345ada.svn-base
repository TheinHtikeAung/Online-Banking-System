<jsp:useBean id="bankBranch" class="sg.com.issbank.dao.mysql.BankBranchDaoImpl" scope="page"/>
<jsp:useBean id="checkAcc" class="sg.com.issbank.dao.mysql.CheckingAccountDaoImpl" scope="page"/>
<jsp:useBean id="saveAcc" class="sg.com.issbank.dao.mysql.SavingsAccountDaoImpl" scope="page"/>

<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			
			<div id="content-admin-main" class="formatView-table">
			
			<h1 id="admin-title"><fmt:message key="admin.bankaccount"/></h1>
			
			<div style="border:0px; text-align:center; width:644px; margin:0 auto;">
			<form style="float: center;" action="./searchBankAcc" method="post">
				Bank Account No :
				<input type="text" placeholder="Bank Account No" name="accountId" value="${accountId}" />
				<input class="button grey" type="submit" value="Search"/>
			
			</form>
			</div>
			<c:if test="${!empty account.accountId}">
			<table class="info-table">
				<th colspan="2"><fmt:message key="label.accountManager.AccountDetail"/>
				
				<c:url var="updateURL" scope="page" value="./accountSetup.jsp">
                            <c:param name="accountId" value="${account.accountId}"/>
                            <c:param name="accountType" value="${account.accountType}"/>
                            <c:param name="balance" value="${account.balance}"/>
                            <c:param name="BBID" value="${account.BBID}"/>
                            <c:param name="PIN" value="${account.PIN}"/>
                            <c:param name="accountManager" value="true"/>
                            <c:param name="update" value="true"/>
                </c:url>
				
					<a style="float: right;"  href="${updateURL}">Edit</a>
				</th>
				
				<tr>
					<td style="width: 150px;"><fmt:message key="label.account.accountid"/> : </td>
					<td>${account.accountId}</td>
				</tr>
				<tr>
					<td><fmt:message key="label.account.accountType"/> : </td>
					<td>${account.accountType}</td>
				</tr>
				
				<c:if test="${account.accountType=='Saving Account'}">
				<tr>
					<td><fmt:message key="label.account.minBalance"/> : </td>
					<td><%=saveAcc.findSavingAccount(request.getParameter("accountId")).getMinimumBalance()%></td>
				</tr>
				
				</c:if>
				<c:if test="${account.accountType=='Checking Account'}">
				<tr>
					<td><fmt:message key="label.account.overdraft"/> : </td>
					<td><%=checkAcc.findCheckingAccount(request.getParameter("accountId")).getOverDraftAmount()%></td>
				</tr>
				</c:if>
				<tr>
					<td><fmt:message key="label.account.balance"/> : </td>
					<td>${account.balance}</td>
				</tr>
				<tr>
					<td><fmt:message key="label.account.pin"/> : </td>
					<td>${account.PIN}</td>
				</tr>
				<tr>
					<td><fmt:message key="label.account.bbid"/> : </td>
					<td>${branch.name} (${branch.BBID})</td>
				</tr>
				
			</table>
			<h3 style="text-align: center;">Owners</h3>
			<table style="width: 555px;" class="center-table">
				<th>#</th>
				<th><fmt:message key="label.customer.nric"/></th>
				<th><fmt:message key="label.customer.name"/></th>
				<th><fmt:message key="label.customer.dob"/></th>
				<th><fmt:message key="label.customer.gender"/></th>
				
			<c:forEach var="c" items="${customers}" varStatus="status">
				<tr class="${status.index%2==0?'even':'odd'}">
					<td nowrap>${status.index + 1}</td>
					<td nowrap>${c.nric}</td>
					<td nowrap>${c.name}</td>
					<td nowrap>${c.dateOfBirth}</td>
					<td nowrap>${c.gender}</td>
				</tr>
			</c:forEach>
			
			</table>
			
			<%-- <table style="width: 555px;" class="center-table">
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
					
					<c:url var="deleteURL" scope="page" value="/deleteCustomer">
                            <c:param name="nric" value="${c.nric}"/>
                    </c:url>
					
					<td nowrap><a href="${deleteURL}"><fmt:message key="page.delete"/></a></td>
				</tr>
			</c:forEach>
			
			</table> --%>
			
			<%-- <c:url var="insertURL" scope="page" value=" ./accountSetup.jsp">
				<c:param name="insert" value="true"/>
			</c:url>
			<a style="margin-left: 50px;" href="${insertURL}"><fmt:message key="label.account.add"/></a>
			
			<c:url var="jointURL" scope="page" value=" ./accountJoint.jsp">
				<c:param name="insert" value="true"/>
			</c:url>
			<a style="margin-left: 230px;" href="${jointURL}"><fmt:message key="label.account.joint"/></a> --%>
			</c:if>
			
			</div>
			
		</div>
		
<%@ include file="layout/footer.jsp" %>