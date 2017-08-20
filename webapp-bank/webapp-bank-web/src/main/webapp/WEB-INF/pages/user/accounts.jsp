<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



<table class="table table-striped table-bordered table-hover" id="inf">
	<tr>
				<th> <s:message code="page.table.thead.name" /> </th>
				<th> <s:message code="page.table.thead.secondName" /></th>
				<th> <s:message code="page.table.thead.login" /></th>
				<th> <s:message code="page.table.thead.email" /></th>
				<th> <s:message code="page.table.thead.allAccounts" /></th>
				<th> <s:message code="page.table.thead.money" /></th>
				<th> <s:message code="page.table.thead.cards" /></th>
	</tr>

	<tr>
		<td>${user.client.inf.name}</td>
		<td>${user.client.inf.secondName}</td>
		<td>${user.client.login}</td>
		<td>${user.client.inf.email}</td>
		<td>${user.countAcc}</td>
		<td>${user.totalMoney}</td>
		<td>${user.countCards}</td>
	</tr>

</table>

<br />
<c:if test="${user.countAcc > 0}">
	<h2><s:message code="page.context.yourAccounts" />:</h2>
	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<thead>
			<tr>
				<th><s:message code="page.table.thead.account" /></th>
				<th><s:message code="page.table.thead.balance" /></th>
				<th><s:message code="page.table.thead.status" /></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user_accounts}" var="acc">
				<c:if test="${acc.status == 1 }">
				<tr class="timeline-badge warning"></c:if> 
					<td>${acc.account }</td>
					<td>${acc.money }</td>
					<td>
					<c:if test="${acc.status == 0 }"><s:message code="page.table.status.active" /></c:if> 
					<c:if test="${acc.status == 1 }"><s:message code="page.table.status.block" /></c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<button type="button" class="btn btn-primary btn-lg btn-block" id="new"><s:message code="page.context.button.newAccount" /></button>
</c:if>
<c:if test="${user.countAcc == 0}"><s:message code="page.error.accounts.no" />
	<br />
	<button type="button" class="btn btn-primary btn-sm" onclick="javascript:document.location.href='newAccountUser.html'"><s:message code="page.context.button.newAccount" /></button>
	
</c:if>

<script type="text/javascript">
	$(function() {
		var id = ${user.client.idClient};
		var url = '/webapp-bank-web/rest/users/' + id+ '/accounts/';
		$('button#new').bind('click',function() {
							var id = ${user.client.idClient};
							var url = '/webapp-bank-web/rest/users/' + id+ '/accounts/';
							$
									.ajax({
										type : "PUT",
										url : url,
										dataType : "json",
										success : function(data) {
											newrow = document.all.dataTables.insertRow();
											newcell = newrow.insertCell(0);
											newcell.innerText = data.account;
											newcell = newrow.insertCell(1);
											newcell.innerText = data.money;
											newcell = newrow.insertCell(2);
											newcell.innerText = "Активен"

											var countAcc = Number(document.all.inf.rows[1].cells[4].innerText);
											countAcc = countAcc + 1;
											document.all.inf.rows[1].cells[4].innerText = countAcc;

										}
									});
						});
	});
</script>



