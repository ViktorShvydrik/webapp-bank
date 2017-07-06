<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>






	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<thead>
			<tr>
				<th>Счет</th>
				<th>Баланс</th>
				<th>Владелец</th>
				<th>Статус</th>
				<th>Действия</th>

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
					<td><a href="#" id= "acc">${acc.account }</a></td>
					<td>${acc.money }</td>
					<td>${acc.client.login }: ${acc.client.inf.secondName } ${acc.client.inf.name }</td>
					<td>
					<c:if test="${acc.status == 0 }">Активен</c:if> 
					<c:if test="${acc.status == 1 }">Заблокирован</c:if>
					<c:if test="${acc.status == 2 }">Удален</c:if>
					</td>
					<td>
					<a href="${pageContext.request.contextPath}/admin/blockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}">Заблокировать</a>
					   <a href="${pageContext.request.contextPath}/admin/delAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}">Удалить</a>
					   <a href="${pageContext.request.contextPath}/admin/unblockAcc.html?id=${acc.idAccount}" class="action" id="${user.client.idClient}">Разблокировать</a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />

<spring:form modelAttribute="transfer" id="form" action="addTransfer.html" method="POST">
	<div class="row">
		<div class="col-xs-4 form-group">
			<label for="disabledSelect">Укажите откуда:</label> 
		<spring:input class="form-control" path="fromAcc.account" id="accA" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 form-group">
			<label for="exampleInputAmount">Укажите сумму:</label>
			<div class="input-group">
				<div class="input-group-addon"><span class="glyphicon glyphicon-rub" aria-hidden="true"></span></div>
				<spring:input class="form-control" id="money" path="money" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class=" col-xs-4 form-group">
			<label for="disabledSelect">Укажите куда:</label> 
				<spring:input class="form-control" path="toAcc.account" id="accB" />
		
				
		</div>
	</div>
	
	<div class="row">
	<button type="submit" class="btn btn-primary">Перевести</button>
	</div>
</spring:form>


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

