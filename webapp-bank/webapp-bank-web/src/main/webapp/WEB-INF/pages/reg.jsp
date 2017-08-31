<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



<div class="p-x-1 p-y-3">
 <spring:form class="card card-block m-x-auto bg-faded form-width" action="reginf.html" method="POST" modelAttribute="clientsInf">
 <spring:hidden path="idClient"/>
 <legend class="m-b-1 text-xs-center"><s:message code="page.reg.legend" /></legend>
 <div class="form-group input-group">
 <span class="has-float-label">
 <spring:input class="form-control" type="text" path="name" />
 <label for="first"><s:message code="page.reg.name" /></label>
 </span>
 <span class="has-float-label">
 <spring:input class="form-control" type="text" path="secondName" />
 <label for="last"><s:message code="page.reg.secondName" /></label>
 </span>
 </div>
 <div class="form-group input-group">
 <span class="input-group-addon">@</span>
 <span class="has-float-label">
 <spring:input class="form-control" id="email" type="email" path="email"/>
 <label for="email">E-mail</label>
 </span>
 </div>
 
 <div class="text-xs-center">
 <button class="btn btn-block btn-primary" type="submit"><s:message code="page.context.button.reg" /></button>
 </div>
 </spring:form>
</div>
