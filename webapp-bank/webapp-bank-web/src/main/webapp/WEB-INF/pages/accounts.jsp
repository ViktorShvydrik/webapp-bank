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
            <li><a href="groupList.html">Карточки</a></li>
            <li><a href="groupList.html">Переводы</a></li>
            <li><a href="groupList.html">Пополнеение счета</a></li>
            <li><a href="groupList.html">Настроки</a></li>
        </ul>
        
        <table border="1">
			<tr>
				<th>
					имя  
				</th>
				<th>
					фамилия
				</th>
				<th>
					логин
				</th>
				<th>
					Емейл
				</th>
				<th>
					Открыто счетов
				</th>

			</tr>

				<tr>
					<td>
						${user.name}
					</td>
					<td>
						<c:out value="${user.secondName}" />
					</td>
					<td>
						<c:out value="${user.login}" />
					</td>
					<td>
						<c:out value="${user.email}" />
					</td>
					<td>
						<c:out value="${user.accounts}" />
						
					</td>
					

								
					
				</tr>
		
		</table>
		
	<c:if test="${user.accounts > 0}">
		
				<table>
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
			<c:forEach items="user_accounts" var="acc">
			<tr>
			<td> <c:out value="${acc.money }" /> </td>
			<td>${acc.money }</td>	
			<td></td>
			</tr>
			</c:forEach>
		
		</table>
	</c:if>
	<c:if test="${user.accounts = 0}">У Вас нет открытых счетов. <a href="newAccountUser.html">Открыть счет</a> </c:if>
	
</body>
</html>