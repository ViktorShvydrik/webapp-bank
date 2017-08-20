<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
	
		
		


		