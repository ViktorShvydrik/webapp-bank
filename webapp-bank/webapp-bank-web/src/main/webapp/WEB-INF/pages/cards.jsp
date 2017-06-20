
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
            <li><a href="#" class = "active">Карты</a></li>
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
		
		</table >
		<br />
		<br />
		<br />
		<h2>Ваши карточки</h2>
		<c:if test="${user.cards > 0}">
		<table border="1">
		<tr>
				<th>
					Номер карточки 
				</th>
				<th>
					Статус 
				</th>
				<th>
					Действия  
				</th>
				</tr>
		<c:forEach items="${user_cards}" var="card">
			<tr>
			<td>
						${card.numberCard}
						
					</td>
					<td>
						<c:if test="${card.status == 1}">Заблокированна</c:if>
						<c:if test="${card.status == 0}">Доступна</c:if>
					</td>
					<td>
						<a href="cardsblock.html?id=${card.idCard}">Заблокировать</a>
						<a href="cardsunblock.html?id=${card.idCard}">Разблокировать</a>
					</td>
		</tr>
		</c:forEach>
		</table>
		</c:if>

</body>
</html>