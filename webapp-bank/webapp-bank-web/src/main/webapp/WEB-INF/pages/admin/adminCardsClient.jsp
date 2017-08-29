
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



	

<c:if test="${client.idClient != 0 }">
<c:if test="${client.inf.countAccounts != 0 }">
	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<thead>
		<tr>
			<th width="25%"><s:message code="page.table.thead.number" /></th>
			<td width="25%"><s:message code="page.table.thead.owner" /></td>
			<th width="25%"><s:message code="page.table.thead.status" /></th>
			<th width="25%"><s:message code="page.table.thead.actions" /></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${user_cards}" var="card">
			<tr>
				<td >${card.numberCard}</td>
				<td>${card.login}</td>
				<td >
				<c:if test="${card.status == 1}"><s:message code="page.table.card.status.blocked" /></c:if> 
				<c:if test="${card.status == 0}"><s:message code="page.table.card.status.available" /></c:if>
				</td>
				<td >
				<c:if test="${card.status == 0}"><a href="#" class="action" id="${card.idCard}"><s:message code="page.table.actions.block" /></a></c:if>
				 <c:if test="${card.status == 1}"><a href="#" class="action" id="${card.idCard}"><s:message code="page.table.actions.active" /></a></c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<br />
<br />

<spring:form modelAttribute="card" action="newcard.html">
		
<div class="row">
		<div class="col-xs-4 form-group">
			<label for="disabledSelect"><s:message code="page.context.refill.select" />:</label> 
		<spring:select path="account" class="form-control">
		
		<c:forEach items="${user_accounts}" var="acc">
		<spring:option value="${acc.account}">${acc.account} (${acc.money} <s:message code="page.context.rub" />)</spring:option>
		</c:forEach>
		</spring:select>
		</div>
</div>
<div class="row">
		<div class="col-xs-4 form-group">
			
				<spring:hidden class="form-control" path="login" />
			
		</div>
	</div>
<button type="submit" class="btn btn-primary"><s:message code="page.context.button.newCard" /></button>
</spring:form>


<script type="text/javascript">
	$(function() {
		$('a.action')
				.on(
						'click',
						function(e) {
							var id = this.id;
							var obj = this;
							var block = '<s:message code="page.table.actions.block" />';
							var unblock = '<s:message code="page.table.actions.active" />';
							var blocked = '<s:message code="page.table.card.status.blocked" />';
							var available = '<s:message code="page.table.card.status.available" />';
							var numCell = obj.parentNode.cellIndex;
							var numRow = obj.parentNode.parentNode.rowIndex;
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
</c:if>
</c:if>

<c:if test="${client.inf.countAccounts == 0 }">
<s:message code="page.error.accounts.clientNo" />
</c:if>
<c:if test="${empty client.inf }">
<c:if test="${client.idClient != 0 }">
<s:message code="page.error.noInf" />
</c:if>
</c:if>
<c:if test="${client.idClient == 0 }">
<s:message code="page.context.clientLogin" />:
<spring:form modelAttribute="client" action="cardscl.html">
<div class="row">
		<div class="col-xs-4 form-group">
			<div class="input-group">
				<spring:input class="form-control" path="login" />
			</div>
		</div>
	</div>
<button type="submit" class="btn btn-primary"><s:message code="page.context.button.show" /></button>
</spring:form>
</c:if>



