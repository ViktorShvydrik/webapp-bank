<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/main.css" type="text/css">
<meta charset="utf-8">
<title> Пластиковые карты</title>
</head>
<body>

		<ul class="nav">
            <li><a href="index.html">Логин</a></li>
            <li><a href="userPage.html" >Главная</a></li>
            <li><a href="accounts.html">Счета</a></li>
            <li><a href="cards.html">Карты</a></li>
            <li><a href="#">Переводы</a></li>
            <li><a href="#" class = "active">Пополнение счета</a></li>
            <li><a href="#">Настроки</a></li>
        </ul>
        
        <table border="1">
			<tr>
				<th>имя  </th>
				<th>фамилия</th>
				<th>логин</th>
				<th>Емейл</th>
				<th>Открыто счетов</th>
				<th>Деньги на счетах</th>
				<th>Пластиковые карточки</th>

			</tr>

				<tr>
					<td>${user.name}</td>
					<td>${user.secondName}</td>
					<td>${user.login}</td>
					<td>${user.email}</td>
					
					<td>${user.accounts}</td>
					<td>${user.money}</td>
					<td>${user.cards}</td>
				</tr>
		
		</table >
		
			<br />
		<br />

	<c:if test="${user.accounts == 0}">У Вас нет открытых счетов.  </c:if> 
	<c:if test="${user.accounts > 0}">
	<spring:form action="refillmoney.html" modelAttribute="refill">
		<spring:select path="idAccount">
		<c:forEach items="${user_accounts}" var="acc">
		<spring:option value="${acc.idAccount}">${acc.account} (${acc.money} руб.)</spring:option>
		</c:forEach>
		</spring:select>
		
		<spring:input path="money" />
		<input  type="submit" value="Пополнить">
	</spring:form>
	
	</c:if>

</body>
</html>