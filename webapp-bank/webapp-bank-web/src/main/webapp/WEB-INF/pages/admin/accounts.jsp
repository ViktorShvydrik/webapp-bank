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
					<td>${acc.account }</td>
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



