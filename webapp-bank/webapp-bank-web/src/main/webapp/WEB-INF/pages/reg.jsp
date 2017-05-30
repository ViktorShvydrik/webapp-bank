<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reg.css" media="screen" type="text/css" />
<title>Insert title here</title>
</head>
<body>


<div class="p-x-1 p-y-3">
 <form class="card card-block m-x-auto bg-faded form-width">
 <legend class="m-b-1 text-xs-center">Регистрация</legend>
 <div class="form-group input-group">
 <span class="has-float-label">
 <input class="form-control" id="first" type="text" />
 <label for="first">Имя</label>
 </span>
 <span class="has-float-label">
 <input class="form-control" id="last" type="text" />
 <label for="last">Фамилия</label>
 </span>
 </div>
 <div class="form-group input-group">
 <span class="input-group-addon">@</span>
 <span class="has-float-label">
 <input class="form-control" id="email" type="email" />
 <label for="email">E-mail</label>
 </span>
 </div>
 
 <div class="text-xs-center">
 <button class="btn btn-block btn-primary" type="submit">Регистрация</button>
 </div>
 </form>
</div>

</body>
</html>