<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<c:if test="${user.client == null }">
<button type="button" class="btn btn-primary btn-sm" onclick="javascript:document.location.href='createclient.html'"><s:message code="page.context.button.create" /></button>

</c:if>

<c:if test="${user.client != null }">
<div class="row">
		<div class="col-xs-4 form-group">
		</div>
			<div class="col-xs-4 form-group">
			<spring:form modelAttribute="user" action="profilcl.html">
			<div class="form-group">
			 <label for="login">Логин клиента:</label>
			<spring:input class="form-control" path="client.login" />
			<spring:hidden path="client.idClient"/>
			</div>
			<div class="form-group">
			 <label for="client.pass">Пароль клиента:</label>
			${user.client.pass}
			</div>
			
			<button type="submit" class="btn btn-primary" >Дальше</button>
			</spring:form>
			
			
		</div>
	</div>

</c:if>