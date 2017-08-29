<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>




<c:if test="${not empty error}">
<div style="  margin: 0 auto; width: 100px;  ">
<span style="color:red; "><s:message code="page.error.accounts.unsuccessfully" /></span></div>
</c:if>

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
			<c:forEach items="${list_accounts}" var="acc">
				<c:if test="${acc.status == 0 }">
				<tr class="timeline-badge success"></c:if>
				<c:if test="${acc.status == 1 }">
				<tr class="timeline-badge warning"></c:if> 
				<c:if test="${acc.status == 2 }">
				<tr class="timeline-badge danger"></c:if> 
					<td>
					<c:if test="${acc.status == 0 }"><a href="#" id= "acc">${acc.account }</a></c:if>
					<c:if test="${acc.status == 1 }">${acc.account }</c:if>
					<c:if test="${acc.status == 2 }">${acc.account }</c:if>
					</td>
					<td>${acc.money }</td>
					<td>${acc.client.login }: ${acc.client.inf.secondName } ${acc.client.inf.name }</td>
					<td>
					<c:if test="${acc.status == 0 }"><s:message code="page.table.status.active" /></c:if> 
					<c:if test="${acc.status == 1 }"><s:message code="page.table.status.block" /></c:if>
					<c:if test="${acc.status == 2 }"><s:message code="page.table.status.del" /></c:if>
					</td>
					<td><a href="cardscl.html?login=${user.client.login}" >${ acc.countCards}</a></td>
					<td>
					<a href="${pageContext.request.contextPath}/admin/blockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.block" /></a>
					   <a href="${pageContext.request.contextPath}/admin/delAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.del" /></a>
					   <a href="${pageContext.request.contextPath}/admin/unblockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.active" /></a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />

<spring:form modelAttribute="transfer" id="form" action="addTransfer.html" method="POST">
	<div class="row">
		<div class="col-xs-4 form-group">
		<div class="form-group">
			<label for="disabledSelect"><s:message code="page.context.accounts.whence" />:</label> 
		<spring:input class="form-control" path="fromAcc.account" id="accA" />
		</div>
			
			
			<div class="form-group">
			<label for="exampleInputAmount"><s:message code="page.context.accounts.sum" />:</label>
			<div class="input-group">
				<div class="input-group-addon"><span class="glyphicon glyphicon-rub" aria-hidden="true"></span></div>
				<spring:input class="form-control" id="money" path="money" type="number" min="0"/>
			</div>
			</div>
			<div class="form-group">
			<label for="disabledSelect"><s:message code="page.context.accounts.whither" />:</label> 
				<spring:input class="form-control" path="toAcc.account" id="accB" />
		</div>
				
	
	<button type="submit" class="btn btn-primary"><s:message code="page.context.button.transfer" /></button>
	
	</div>
	</div>
</spring:form>
<br />
<br />
<!-- <button type="button" onclick="javascript:document.location.href='reloadacc.html'">Обновить информацию</button> -->

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
</script>

