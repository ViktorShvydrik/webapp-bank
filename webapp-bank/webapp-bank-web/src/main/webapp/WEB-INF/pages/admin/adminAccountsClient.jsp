<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<c:if test="${visit == 2}">

	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<thead>
			<tr>
				<th> <s:message code="page.table.thead.account" /></th>
				<th> <s:message code="page.table.thead.balance" /></th>
				<th> <s:message code="page.table.thead.owner" /></th>
				<th> <s:message code="page.table.thead.status" /></th>
				<th> <s:message code="page.table.thead.cards" /></th>
				<th> <s:message code="page.table.thead.actions" /></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts_client}" var="acc">
				<c:if test="${acc.status == 0 }">
				<tr class="timeline-badge success"></c:if>
				<c:if test="${acc.status == 1 }">
				<tr class="timeline-badge warning"></c:if> 
				<c:if test="${acc.status == 2 }">
				<tr class="timeline-badge danger"></c:if> 
					<td>${acc.account }</td>
					<td>${acc.money }</td>
					<td>${acc.client.login }: ${acc.client.inf.secondName } ${acc.client.inf.name }</td>
					<td>
					<c:if test="${acc.status == 0 }"><s:message code="page.table.status.active" /></c:if> 
					<c:if test="${acc.status == 1 }"><s:message code="page.table.status.block" /></c:if>
					<c:if test="${acc.status == 2 }"><s:message code="page.table.status.del" /></c:if>
					</td>
					<td><a href="cardscl.html?login=${acc.client.login}" >${acc.countCards}</a></td>
					<td>
					<a href="${pageContext.request.contextPath}/admin/blockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.block" />Заблокировать</a>
					   <a href="${pageContext.request.contextPath}/admin/delAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.del" /></a>
					   <a href="${pageContext.request.contextPath}/admin/unblockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.active" /></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />


<br />
<br />


<button type="button" class="btn btn-primary btn-lg btn-block" id="new"><s:message code="page.context.button.newAccount" /></button>

<script type="text/javascript">
$(function() {
	$('a#acc').on('click', function(e){
		e.preventDefault();
		var acc1 = this.innerText;
		document.all.accA.value = acc1;
		$('a#acc').each( function(){
			$(this).unbind('click');
				$('a#acc').on('click', function(e){
					e.preventDefault();
					var acc2 = this.innerText;
					document.all.accB.value = acc2;
				})
		})
	})
})
$(function() {
		var id = ${client.idClient};
		var url = '/webapp-bank-web/rest/users/' + id+ '/accounts/';
		$('button#new').bind('click',function() {
							$.ajax({
										type : "PUT",
										url : url,
										dataType : "json",
										success : function(data) {
											newrow = document.all.dataTables.insertRow();
											newrow.classList.add("timeline-badge", "success");
											newcell = newrow.insertCell(0);
											newcell.innerText = data.account;
											newcell = newrow.insertCell(1);
											newcell.innerText = data.money;
											newcell = newrow.insertCell(2);
											newcell.innerText = "${client.login }: ${client.inf.secondName } ${client.inf.name }";
											newcell = newrow.insertCell(3);
											newcell.innerText = "Активен"
											newcell = newrow.insertCell(4);
											newcell.innerText = "0"
											newcell = newrow.insertCell(5);
											newcell.innerHTML = '<a href="${pageContext.request.contextPath}/admin/blockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}">Заблокировать</a> <a href="${pageContext.request.contextPath}/admin/delAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}">Удалить</a>  <a href="${pageContext.request.contextPath}/admin/unblockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}">Разблокировать</a>';

										}
									});
						});
	});
</script>
</c:if>
<br />

<c:if test="${visit == 1}">

<spring:form modelAttribute="client" action="accounts_client.html">
<div class="row">
		<div class="col-xs-4 form-group">
		</div>
		<div class="col-xs-4 form-group">
			<div class="input-group">
			<s:message code="page.context.clientLogin" />:
				<spring:input class="form-control" path="login" />
			</div>
			<button type="submit" class="btn btn-primary"><s:message code="page.context.button.show" /></button>
		</div>
	</div>

</spring:form>
</c:if>