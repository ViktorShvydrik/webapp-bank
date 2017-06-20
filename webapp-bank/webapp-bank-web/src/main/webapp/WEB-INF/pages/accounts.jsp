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
<title> Управление счетами</title>
</head>
<body>

		<ul class="nav">
            <li><a href="index.html">Логин</a></li>
            <li><a href="userPage.html" >Главная</a></li>
            <li><a href="#" class = "active">Счета</a></li>
            <li><a href="cards.html">Карточки</a></li>
            <li><a href="#">Переводы</a></li>
            <li><a href="refill.html">Пополнение счета</a></li>
            <li><a href="#">Настроки</a></li>
        </ul>
        
        <table border="1">
				<tr>
				<th>имя </th>
				<th>фамилия</th>
				<th>логин</th>
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
	<c:if test="${user.accounts > 0}">
		<h2>Ваши счета:</h2>
				<table border="1">
		<tr>
			<th>
					Счет
				</th>
				<th>
					Баланс
				</th>	
				<th>
					Действия
				</th>	

			</tr>
			<c:forEach items="${user_accounts}" var="acc">
			<tr>
			<td>${acc.account }  </td>
			<td>${acc.money }</td>	
			<td></td>
			</tr>
			</c:forEach>
		
		</table>
	</c:if>
	<c:if test="${user.accounts == 0}">У Вас нет открытых счетов.  </c:if> 
	<br />
	<a href="newAccountUser.html">Открыть новый счет</a>
	
</body>
</html>