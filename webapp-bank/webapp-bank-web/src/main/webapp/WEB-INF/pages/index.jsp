<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

  <header>
  <h2>Нет аккаунта?</h2>
  <a class="h2" href="#" id="form-switch">Регистрация!</a>
</header>

<div class="form">
  <div class="front-sign-in">
  <spring:form  action="login.html" method="post" modelAttribute="clients">
    <spring:input type="text" placeholder="Логин" path="login" />
    <spring:input type="password" placeholder="Пароль" path="pass" />
    <input class="signin-submit" type="submit"  value="ВОЙТИ">
    </spring:form>
  </div>
   <div class="back-sign-up">
  <spring:form  action="reg.html" method="post" modelAttribute="clients">
    <spring:input type="text" placeholder="Логин" path="login" />
    <spring:input type="password" placeholder="Пароль" path="pass" />
    <input class="signup-submit" type="submit" value="Регистрация">
    </spring:form>
  </div> 
 </div>

 