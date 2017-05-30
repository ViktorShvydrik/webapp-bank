<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bank - login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" media="screen" type="text/css" />
	<script src="${pageContext.request.contextPath}/resources/js/prefixfree.min.js"></script>
	<link rel="icon" href="${pageContext.request.contextPath}/resources/ico/coins.png" type="image/x-icon">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/ico/coins.png" type="image/x-icon"> 
</head>
<body>

  <header>
  <h2>Нет аккаунта?</h2>
  <a class="h2" href="#" id="form-switch">Регистрация!</a>
</header>

<div class="form">
  <div class="front-sign-in">
  <spring:form  action="login.html" method="post" modelAttribute="clients">
    <spring:input type="text" placeholder="Логин" path="login" />
    <spring:input type="password" placeholder="Пароль" path="pass" />
    <input class="signin-submit" type="button" onclick="submit()" value="ВОЙТИ">
    </spring:form>
  </div>
  <div class="back-sign-up">
  <spring:form  action="reg.html" method="post" modelAttribute="clients">
    <spring:input type="text" placeholder="Логин" path="login" />
    <spring:input type="password" placeholder="Пароль" path="pass" />
    <input class="signup-submit" type="button" onclick="submit()" value="Регистрация">
    </spring:form>
  </div>
 </div>

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>
