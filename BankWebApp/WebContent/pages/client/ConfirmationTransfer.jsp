<%@ include file="layout/header.jsp" %>
<%@ include file="layout/menu.jsp" %>
<div id="content-admin-main" class="formatView-table">

	<form name="zuihoule" method="post" action="${pageContext.request.contextPath }/transferConfirmController">
	<h1 id="admin-title"><font color="grey" size="5" >Confirmation</font></h1>
	
          <table>
              <tr width="100%">
                    <tr>
                    <td width="50%">Account Type</td>
                    <td width="50%"><input readonly="readonly" name="accountType111" type="text" value ="${accountType111}"></td>
                </tr>
                 <tr>
                    <td width="50%">Branch</td>
                    <td width="50%"><input readonly="readonly" name="branch" type="text" value =<%=request.getParameter("branch")%>></td>
                </tr>
                 <tr>
                    <td width="50%">Name</td>
                    <td width="50%"><input readonly="readonly" name="name" type="text" value =<%=request.getParameter("name")%>></td>
                </tr>
                <%-- <tr>
                    <td>From Account</td>
                    <td><input readonly="readonly" name="fromAcc" type="text" value =<%=request.getParameter("fromAcc")%>></td>
                </tr> --%>
                                <tr>
                    <td>To Account</td>
                    <td><input readonly="readonly" name="toAcc" type="text" value =<%=request.getParameter("toAcc")%>></td>
                </tr>
                <tr>
                    <td>Email of account holder</td>
                    <td><input readonly="readonly" name="email" type="text" value =<%=request.getParameter("email")%>></td>
                </tr>
                 <tr>
                    <td>Amount</td>
                    <td><input readonly="readonly" name="amount" type="text" value =<%=request.getParameter("amount")%>></td>
                </tr>
                                <tr><td align="center" colspan="2">
                          <!-- <A HREF="TransferInfo.jsp">
                                        <font size="3" color="blue">Edit</font></A> -->
                        
                        <INPUT class="button grey" TYPE="SUBMIT" value="submit">
                      
                        </td>
            </tr>                                            
                                            
        </table>   
	</form>

</div>
</div>


<%@ include file="layout/footer.jsp" %>