
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



<table class="table table-striped table-bordered table-hover">
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
<br />
<br />
<c:if test="${user.countCards == 0}">
		<s:message code="page.error.cards.noCards" />
		</c:if>
<c:if test="${user.countCards > 0}">
	<h2><s:message code="page.context.cards.your" /></h2>
	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<tr>
			<th><s:message code="page.table.thead.number" /></th>
			<th><s:message code="page.table.thead.status" /></th>
			<th><s:message code="page.table.thead.actions" /></th>
		</tr>
		<c:forEach items="${user_cards}" var="card">
			<tr>
				<td width="33%">${card.numberCard}</td>
				<td width="33%">
				<c:if test="${card.status == 1}"><s:message code="page.table.card.status.blocked" /></c:if> 
				<c:if test="${card.status == 0}"><s:message code="page.table.card.status.available" /></c:if>
				</td>
				<td width="33%">
				<c:if test="${card.status == 0}"><a href="#" class="action" id="${card.idCard}"><s:message code="page.table.actions.block" /></a></c:if>
				 <c:if test="${card.status == 1}"><a href="#" class="action" id="${card.idCard}"><s:message code="page.table.actions.active" /></a></c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>


<script type="text/javascript">
	$(function() {
		$('a.action')
				.on(
						'click',
						function(e) {
							e.preventDefault();
							var id = this.id;
							var obj = this;
							var numCell = obj.parentNode.cellIndex;
							var numRow = obj.parentNode.parentNode.rowIndex;
							var block = '<s:message code="page.table.actions.block" />';
							var unblock = '<s:message code="page.table.actions.active" />';
							var blocked = '<s:message code="page.table.card.status.blocked" />';
							var available = '<s:message code="page.table.card.status.available" />';
							var url = '/webapp-bank-web/rest/users/accounts/cards/'
									+ id;
							$
									.ajax({
										type : "PUT",
										url : url,
										dataType : "json",
										success : function(data) {
											if (obj.innerText == block) {

												obj.innerText = unblock;
												document.all.dataTables.rows[numRow].cells[numCell - 1].innerText = blocked;
											} else {

												obj.innerText = block;
												document.all.dataTables.rows[numRow].cells[numCell - 1].innerText = available;
											}
										}
									});
						});
	});
</script>
