<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

		<table class="table table-striped table-bordered table-hover" id="dataTables">
				<thead>
				<tr>
				<th> <s:message code="page.table.thead.name" /> </th>
				<th> <s:message code="page.table.thead.secondName" /></th>
				<th> <s:message code="page.table.thead.login" /></th>
				<th> <s:message code="page.table.thead.email" /></th>
				<th> <s:message code="page.table.thead.allAccounts" /></th>
				<th> <s:message code="page.table.thead.money" /></th>
				<th> <s:message code="page.table.thead.cards" /></th>
				<th> <s:message code="page.table.thead.access" /></th>
				<th> <s:message code="page.table.thead.status" /></th>
				<th> <s:message code="page.table.thead.actions" /></th>
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
					<td><a href="profilcl.html?client.login=${user.client.login}" >${user.client.login}</a></td>
					<td>${user.client.inf.email}</td>
					<td><a href="accounts_client.html?login=${user.client.login}">${user.countAcc}</a></td>
					<td>${user.totalMoney}</td>
					<td><a href="cardscl.html?login=${user.client.login}" >${user.countCards}</a></td>
					<td>
					<c:if test="${user.client.access == 1 }"><a href="acessUp.html?id=${user.client.idClient}"><s:message code="page.table.role.admin" /></a></c:if> 
					<c:if test="${user.client.access == 2 }"><a href="acessUp.html?id=${user.client.idClient}"><s:message code="page.table.role.operator" /></a></c:if>
					<c:if test="${user.client.access == 3 }"><a href="acessUp.html?id=${user.client.idClient}"><s:message code="page.table.role.client" /></a></c:if> 
					</td>
					<td>
					<c:if test="${user.client.status == 0 }"><s:message code="page.table.status.active" /></c:if> 
					<c:if test="${user.client.status == 1 }"><s:message code="page.table.status.block" /></c:if>
					<c:if test="${user.client.status == 2 }"><s:message code="page.table.status.del" /></c:if>
					</td>
					<td><a href="${pageContext.request.contextPath}/admin/blockUser.html?id=${user.client.idClient}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.block" /></a>
					<br/> <a href="${pageContext.request.contextPath}/admin/delUser.html?id=${user.client.idClient}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.del" /></a>
					<br/><a href="${pageContext.request.contextPath}/admin/unblock.html?id=${user.client.idClient}" class="action" id="${user.client.idClient}"><s:message code="page.table.actions.active" /></a>
					</td>
					
				</tr>
		</c:forEach>
		</tbody>
		</table>
		

		<br />
	