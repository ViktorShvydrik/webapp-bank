<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


<c:if test="${user.client.login != null }">
		

	<div class="row">
		<div class="col-xs-4 form-group">
		</div>
			<div class="col-xs-4 form-group">
			<spring:form modelAttribute="user" action="profiledit.html">
			<div class="form-group">
			 <label for="client.login"><s:message code="page.context.profil.login" />:</label>
			<spring:input class="form-control" path="client.login" />
			<spring:hidden path="client.idClient"/>
			<spring:hidden path="client.inf.idClient"/>
			</div>
			<div class="form-group">
			 <label for="client.inf.name"><s:message code="page.context.profil.name" />:</label>
			<spring:input class="form-control" path="client.inf.name" />
			</div>
			<div class="form-group">
			 <label for="client.inf.secondName"><s:message code="page.context.profil.lastName" />:</label>
			<spring:input class="form-control" path="client.inf.secondName" />
			</div>
			<div class="form-group">
			 <label for="client.inf.email"><s:message code="page.context.profil.email" />:</label>
			<spring:input class="form-control" path="client.inf.email" />
			</div>
			<div class="form-group">
			 <label for="client.pass"><s:message code="page.context.profil.pass" />:</label>
			<spring:password class="form-control" path="client.pass" />
			</div>
			<div class="form-group">
			 <label for="client.access"><s:message code="page.context.profil.access" />:</label>
			<spring:select class="form-control" path="client.access" >
			<spring:option value="1"><s:message code="page.table.role.admin" /></spring:option>
			<spring:option value="2"><s:message code="page.table.role.operator" /></spring:option>
			<spring:option value="3"><s:message code="page.table.role.client" /></spring:option>
			</spring:select>
			</div>
			<div class="form-group">
			 <label for="client.status"><s:message code="page.context.profil.status" />:</label>
			<spring:select class="form-control" path="client.status" >
			<spring:option value="0"><s:message code="page.table.status.active" /></spring:option>
			<spring:option value="1"><s:message code="page.table.status.block" /></spring:option>
			<spring:option value="2"><s:message code="page.table.status.del" /></spring:option>
			</spring:select>
			</div>
			<spring:hidden class="form-control" path="countAcc" />
			<spring:hidden class="form-control" path="totalMoney" />
			<spring:hidden class="form-control" path="countCards" />
			<button type="submit" class="btn btn-primary"><s:message code="page.context.button.edit" /></button>
			</spring:form>
			
			
		</div>
	</div>

</c:if>
		<br />
		<c:if test="${user.client.login == null }">
		<s:message code="page.context.clientLogin" />:
		<spring:form modelAttribute="user.client" action="profilcl.html">
<div class="row">
		<div class="col-xs-4 form-group">
			<div class="form-group">
				<spring:input class="form-control" path="login" />
			</div>
		</div>
	</div>
<button type="submit" class="btn btn-primary"><s:message code="page.context.button.show" /></button>
</spring:form>
</c:if>