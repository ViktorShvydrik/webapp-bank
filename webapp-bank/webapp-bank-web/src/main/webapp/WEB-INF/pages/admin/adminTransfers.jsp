<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



<table class="table table-striped table-bordered table-hover"
	id="dataTables">
	<thead>
	<tr>
	
		<th width="20%"><s:message code="page.table.transfers.number" /></th>
		<th width="20%"><s:message code="page.table.transfers.from" /></th>
		<th width="20%"><s:message code="page.table.transfers.money" /></th>
		<th width="20%"><s:message code="page.table.transfers.to" /></th>
		<th width="20%"><s:message code="page.table.transfers.who" /></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${transfers_list}" var="tr">
		<tr>
			<td>${tr.idTransfer}</td>
			<td>  <c:if test="${tr.fromAcc.account > 0}">  ${tr.fromAcc.account}  </c:if>  </td>
			<td>${tr.money}</td>
			<td>${tr.toAcc.account}</td>
			<td>${tr.login }</td>

		</tr>
	</c:forEach>
	</tbody>
</table>



<br />