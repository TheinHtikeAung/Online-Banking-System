<jsp:useBean id="bankBranch" class="sg.com.issbank.dao.mysql.BankBranchDaoImpl" scope="page"/>
<jsp:useBean id="checkAcc" class="sg.com.issbank.dao.mysql.CheckingAccountDaoImpl" scope="page"/>
<jsp:useBean id="saveAcc" class="sg.com.issbank.dao.mysql.SavingsAccountDaoImpl" scope="page"/>

<%@ include file="layout/adminheader.jsp" %>
<%@ include file="layout/adminmenu.jsp" %>			
			<div id="content-admin-main">
			
			<h1 id="admin-title"><fmt:message key="admin.bankaccount"/></h1>
			
			<form action="./bankaccountProcess" method=post>
			<input type="hidden" name="accountManager" value="${param['accountManager']}"/> 
			
			<table class="center-table">
				<tr>
					<td><fmt:message key="label.account.accountid"/> : </td>
					
					<c:if test="${param['insert']==true}" >
					<td><input type="text" name="accountId" value="${param['accountId']}" size=15 maxlength=20></td>
					<input type="hidden" name="insert" value="true" />
					</c:if>
					
					<c:if test="${param['update']==true}" >
					<td><input type="text" name="accountId" value="${param['accountId']}" size=15 maxlength=20 readonly="readonly"></td>
					<input type="hidden" name="insert" value="false" />
					</c:if>

				</tr>
				
				<script type="text/javascript">
				    window.onload = function() {
				        var accSelect = document.getElementById('accountType');
				        
				        var saveAcc = document.getElementById('saveAcc');
				        var overAcc = document.getElementById('overAcc');
				        
				        accSelect.onchange = function() {
				            if(accSelect.selectedIndex === 2) {
				                
				                saveAcc.style.display = 'table-row';
				                overAcc.style.display = 'none';
				                
				            } else if(accSelect.selectedIndex === 1){
				                
				                saveAcc.style.display = 'none';
				                overAcc.style.display = 'table-row';
				            }
				        }
				    }
				 </script>
				
				<tr>
					<td><fmt:message key="label.account.accountType"/> : </td>
					<td>
						<select id="accountType" name="accountType">
						  <option value="">--- Choose account type ---</option>
						  <option value="Checking Account" <c:if test="${param['accountType']=='Checking Account'}"> selected="selected"</c:if>><fmt:message key="label.account.checkAcc"/></option>
						  <option value="Saving Account" <c:if test="${param['accountType']=='Saving Account'}"> selected="selected"</c:if>><fmt:message key="label.account.saveAcc"/></option>
						</select>
					</td>
				</tr>
				
    				
    			<tr id="saveAcc" style="${param['accountType']=='Saving Account'?'display: table-row':'display: none'}">
					<td><fmt:message key="label.account.minBalance"/> :</td>
					<td><input type="text" name="minimumBalance" value="<%=saveAcc.findSavingAccount(request.getParameter("accountId")).getMinimumBalance()%>" size=15 maxlength=20></td>
				</tr>
    				
    			<tr id="overAcc" style="${param['accountType']=='Checking Account'?'display: table-row':'display: none'}">
					<td><fmt:message key="label.account.overdraft"/> :</td>
					<td><input type="text" name="overDraftAmount" value="<%=checkAcc.findCheckingAccount(request.getParameter("accountId")).getOverDraftAmount()%>" size=15 maxlength=20></td>
				</tr>
    				
    			
				<tr>
					<td><fmt:message key="label.account.balance"/> : </td>
					<td><input type="text" name="balance" value="${param['balance']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="label.account.pin"/> : </td>
					<td><input type="password" name="PIN" value="${param['PIN']}" size=6 maxlength=6></td>
				</tr>
				<tr>
					<td><fmt:message key="label.account.bbid"/> : </td>
					<td>
						<select name="BBID">
							<c:forEach var="bb" items="<%=bankBranch.getBankbranch()%>" varStatus="status">
								<option value="${bb.BBID}" <c:if test="${param['BBID']==bb.BBID}"> selected="selected"</c:if>>${bb.name} (${bb.BBID})</option>
							</c:forEach>
						</select>
					</td>
				
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						<input class="button grey" type="submit" name="action" value="submit">
						
						<c:if test="${param['update']==true}" >
							<c:if test="${empty param['accountManager']}" >	
							<input class="button pink" type="submit" name="action" value="disjoint">
							</c:if>
						</c:if>
						
						<%-- <c:url var="disjointURL" scope="page" value="./disjointProcess">
							<c:param name="accountId" value="${param['accountId']}"/>
						</c:url>
						<a class="button pink" href="${	}">Disjoint Account</a> --%>
					</td>
				</tr>
				
			</table>
			</form>
			
			</div>

			</div>

<%@ include file="layout/footer.jsp" %>
