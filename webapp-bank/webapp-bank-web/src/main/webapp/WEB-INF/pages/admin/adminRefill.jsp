=<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


    <table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<thead>
			<tr>
				<th>Счет</th>
				<th>Баланс</th>
				<th>Владелец</th>
				<th>Статус</th>

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
					<td><a href="${pageContext.request.contextPath}/admin/addRefillAcc.html?acc=${acc.account}">${acc.account }</a> </td>
					<td>${acc.money }</td>
					<td>${acc.client.login }: ${acc.client.inf.secondName } ${acc.client.inf.name }</td>
					<td>
					<c:if test="${acc.status == 0 }">Активен</c:if> 
					<c:if test="${acc.status == 1 }">Заблокирован</c:if>
					<c:if test="${acc.status == 2 }">Удален</c:if>
					</td>
					
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
			<br />
		<br />

	
	<spring:form modelAttribute="refill" method="POST" id="refill" action="addMoney.html">
	
	<div class="row">
		<div class="col-xs-4 form-group">
			<label for="account">Выберите счет:</label>
				<spring:input class="form-control" path="account" id="account" />
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
		<button type="submit" class="btn btn-primary">Пополнить</button>
	</spring:form>




