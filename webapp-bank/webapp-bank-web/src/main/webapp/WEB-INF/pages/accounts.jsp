<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


        
        <table class="table table-striped table-bordered table-hover">
				<tr>
				<th> Имя </th>
				<th>Фамилия</th>
				<th>Логин</th>
				<th>Емейл</th>
				<th>Открыто счетов</th>
				<th>Деньги на счетах</th>
				<th>Пластиковые карточки</th>
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
		<br />
		<br />
	<c:if test="${user.countAcc > 0}">
	<h2>Ваши счета:</h2>
	<table class="table table-striped table-bordered table-hover" id="dataTables">
		<thead>
			<tr>
				<th>Счет</th>
				<th>Баланс</th>
				<th>Действия</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user_accounts}" var="acc">
				<tr>
					<td>${acc.account }</td>
					<td>${acc.money }</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
	<c:if test="${user.countAcc == 0}">У Вас нет открытых счетов.  </c:if> 
	<br />
	<a href="newAccountUser.html">Открыть новый счет</a>
	
