<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<div style="text-align: right;">
        <a href="?language=en_US">
            <s:message code="application.language.en" />
        </a>
        |
        <a href="?language=ru_RU">
            <s:message code="application.language.ru" />
        </a>
</div>
  <header>
  <h2><s:message code="page.index.account" /></h2>
  <a class="h2" href="#" id="form-switch"><s:message code="page.index.registration" /></a>
</header>

<c:if test="${not empty error}">
<div style="  margin: 0 auto; width: 36%;  ">
    <span style="color:red; font-size:30px ">    <s:message code="page.index.error.signIn" /> </span></div>
      </c:if>
<c:if test="${not empty logout}">
<div style="  margin: 0 auto; width: 18%;  ">
    <span style="color:blue; font-size:30px ">    <s:message code="page.index.error.logout" /> </span></div>
      </c:if>
      
<c:if test="${not empty errorReg}">
<div style="  margin: 0 auto; width: 20%;  ">
    <span style="color:red; font-size:20px ">    <s:message code="page.index.error.errorReg" /> </span></div>
      </c:if>  
      
<div class="form">
  <div class="front-sign-in">
  <spring:form  action="${pageContext.request.contextPath}/login" method="post" modelAttribute="clients">
  <spring:errors  cssClass="label label-important" />
    <spring:input type="text" placeholder="Login" path="login" />
    <spring:input type="password" placeholder="Password" path="pass" />
    <input class="signin-submit" type="submit"  value="<s:message code="page.index.btn.signIn" />">
    </spring:form>
  </div>
   <div class="back-sign-up">
  <spring:form  action="reg.html" method="post" modelAttribute="clients">
    <spring:input type="text" placeholder="Login" path="login" />
    <spring:input type="password" placeholder="Password" path="pass" />
    <input class="signup-submit" type="submit" value="<s:message code="page.index.btn.reg" />">
    </spring:form>
  </div> 
 </div>

 