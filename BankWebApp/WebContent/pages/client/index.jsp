<%@ include file="layout/header.jsp" %>
<%@ include file="layout/loginMenu.jsp" %>
		
		<div id="content-box1"><a href="#"><h1 id="content-main-h1"><fmt:message key="bank.aboutUs"/></h1></a></div>
		<div id="content-box2"><a href="#"><h1 id="content-main-h1"><fmt:message key="bank.find.branch"/></h1></a></div>
		<div id="content-box3"><a href="#"><h1 id="content-main-h1"><fmt:message key="bank.how.open.account"/></h1></a></div>
		
		<div id="content-main">
			<table border="0">
				<tr>
					<td rowspan="2"><img src="<c:url value='/img/Bank.jpg'/>"/></td>
					<td>
						<h1 id="content-main-h1"><fmt:message key="bank.storytitle"/></h1>
					</td>
				</tr>
				<tr>
					<td id="content-main-td">
						<fmt:message key="bank.story"/><br/>
						<a href=""><fmt:message key="bank.readmore"/></a>
					</td>
				</tr>
			</table>				
		</div>
	</div>
		
<%@ include file="layout/footer.jsp" %>
		