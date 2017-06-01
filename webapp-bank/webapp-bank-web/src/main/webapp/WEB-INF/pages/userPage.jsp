<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=application.getContextPath() %>resources/css/main.css" type="text/css">
<meta charset="utf-8">
<title>UserPage - главная</title>
</head>
<body>


		<ul class="nav">
            <li><a href="index.html">Логин</a></li>
            <li><a href="#" style="background-color: #333; color: #f4f4f4">Главная</a></li>
            <li><a href="projectList.html">Счета</a></li>
            <li><a href="groupList.html">Карточки</a></li>
            <li><a href="groupList.html">Переводы</a></li>
            <li><a href="groupList.html">Пополнеение счета</a></li>
        </ul>
        
        
</body>
</html>