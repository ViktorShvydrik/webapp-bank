<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

		<table class="table table-striped table-bordered table-hover" id="dataTables">
				<thead>
				<tr>
				<th> Имя </th>
				<th>Фамилия</th>
				<th>Логин</th>
				<th>Емейл</th>
				<th>Открыто счетов</th>
				<th>Деньги на счетах</th>
				<th>Пластиковые карточки</th>
				<th>Статус</th>
				<th>Действия</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
				<c:if test="${user.client.status == 0 }">
				<tr class="timeline-badge success"></c:if>
				<c:if test="${user.client.status == 1 }">
				<tr class="timeline-badge warning"></c:if> 
				<c:if test="${user.client.status == 2 }">
				<tr class="timeline-badge danger"></c:if> 
					<td>${user.client.inf.name}</td> 
					<td>${user.client.inf.secondName}</td>
					<td>${user.client.login}</td>
					<td>${user.client.inf.email}</td>
					<td>${user.countAcc}</td>
					<td>${user.totalMoney}</td>
					<td>${user.countCards}</td>
					<td>
					<c:if test="${user.client.status == 0 }">Активен</c:if> 
					<c:if test="${user.client.status == 1 }">Заблокирован</c:if>
					<c:if test="${user.client.status == 2 }">Удален</c:if>
					</td>
					<td><a href="${pageContext.request.contextPath}/admin/blockUser.html?id=${user.client.idClient}" class="action" id="${user.client.idClient}">Заблокировать</a>
					<br/> <a href="${pageContext.request.contextPath}/admin/delUser.html?id=${user.client.idClient}" class="action" id="${user.client.idClient}">Удалить</a>
					<br/><a href="${pageContext.request.contextPath}/admin/unblock.html?id=${user.client.idClient}" class="action" id="${user.client.idClient}">Разблокировать</a>
					</td>
					
				</tr>
		</c:forEach>
		</tbody>
		</table>
		

		<br />
	