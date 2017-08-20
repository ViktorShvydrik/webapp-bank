<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


<c:if test="${user.client.login != null }">


	<div class="row">
		<div class="col-xs-4 form-group"></div>
		<div class="col-xs-4 form-group">
			<spring:form modelAttribute="user" action="profiledit.html">
				<div class="form-group">
					<label for="login">Логин клиента:</label>
					<spring:input class="form-control" path="client.login" />
					<spring:hidden path="client.idClient" />
					<spring:hidden path="client.inf.idClient" />
				</div>
				<div class="form-group">
					<label for="login">Имя клиента:</label>
					<spring:input class="form-control" path="client.inf.name" />
				</div>
				<div class="form-group">
					<label for="login">Фамилия клиента:</label>
					<spring:input class="form-control" path="client.inf.secondName" />
				</div>
				<div class="form-group">
					<label for="login">Email клиента:</label>
					<spring:input class="form-control" path="client.inf.email" />
				</div>
				<div class="form-group">
					<label for="login">Пароль клиента:</label>
					<spring:password class="form-control" path="client.pass" />
				</div>


				<spring:hidden class="form-control" path="countAcc" />
				<spring:hidden class="form-control" path="totalMoney" />
				<spring:hidden class="form-control" path="countCards" />
				<button type="submit" class="btn btn-primary">Редактировать</button>
			</spring:form>


		</div>
	</div>

</c:if>
<br />
<c:if test="${user.client.login == null }">
		Введите логин клиента:
		<spring:form modelAttribute="user.client" action="profilcl.html">
		<div class="row">
			<div class="col-xs-4 form-group">
				<div class="form-group">
					<spring:input class="form-control" path="login" />
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Показать</button>
	</spring:form>
</c:if>