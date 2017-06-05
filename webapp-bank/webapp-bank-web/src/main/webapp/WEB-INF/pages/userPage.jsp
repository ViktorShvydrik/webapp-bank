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
<title>UserPage - главная</title>
</head>
<body>


		<ul class="nav">
            <li><a href="index.html">Логин</a></li>
            <li><a href="#" class = "active">Главная</a></li>
            <li><a href="accounts.html">Счета</a></li>
            <li><a href="groupList.html">Карточки</a></li>
            <li><a href="groupList.html">Переводы</a></li>
            <li><a href="groupList.html">Пополнеение счета</a></li>
            <li><a href="groupList.html">Настроки</a></li>
        </ul>
        
        <div class="dataFrame largeFrame">
		<h1>
		</h1>

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
						<c:out value="${user.name}" />
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
		

		<br />
		<hr />
		<br />
		
		


		<%-- <div class="dataFrame shortFrame">
			<h1>
			</h1>

			<form method="post" action="userList.html" >
				<input type="hidden" name="action" value="save_user" />

				<input type="hidden" name="hdn_user_id" value="<c:out value='${current_user.id}' default=''  />" />

				<fmt:message key="userListPage.saveUserForm.userName.label" bundle="${msgs}" />
				<br />
				<input type="text" id="txt_login" name="txt_login" value="<c:out value='${current_user.userName}' default=''  />" />

				<c:if test="${validation_errors != null}">
					<c:forEach items="${validation_errors}" var="error">
						<c:if test="${error.errorCode == 'userName.error'}">
							<span class="errorText">
								<fmt:message key="${error.errorText}" bundle="${msgs}" />
							</span>
						</c:if>
					</c:forEach>
				</c:if>

				<br />
				<br />

				<fmt:message key="userListPage.saveUserForm.password.label" bundle="${msgs}" />
				<br />
				<input type="text" id="txt_password" name="txt_password" value="<c:out value='${current_user.password}' default=''/>" />

				<c:if test="${validation_errors != null}">
					<c:forEach items="${validation_errors}" var="error">
						<c:if test="${error.errorCode == 'password.error'}">
							<span class="errorText">
								<fmt:message key="${error.errorText}" bundle="${msgs}" />
							</span>
						</c:if>
					</c:forEach>
				</c:if>

				<br />
				<br />
				<input type="submit" name="login_btn" value="<fmt:message key='save.button' bundle='${msgs}' />" /> 
				</form>--%>
			
		</div>
	
</body>
</html>