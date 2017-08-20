
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



	

<c:if test="${client.idClient != 0 }">
<c:if test="${fn:length(user_cards) != 0}">
	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<thead>
		<tr>
			<th width="25%">Номер карточки</th>
			<td width="25%">Владелец</td>
			<th width="25%">Статус</th>
			<th width="25%">Действия</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${user_cards}" var="card">
			<tr>
				<td >${card.numberCard}</td>
				<td>${card.login}</td>
				<td >
				<c:if test="${card.status == 1}">Заблокированна</c:if> 
				<c:if test="${card.status == 0}">Доступна</c:if>
				</td>
				<td >
				<c:if test="${card.status == 0}"><a href="#" class="action" id="${card.idCard}">Заблокировать</a></c:if>
				 <c:if test="${card.status == 1}"><a href="#" class="action" id="${card.idCard}">Разблокировать</a></c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<br />
<br />
<spring:form modelAttribute="card" action="newcard.html">
		
<div class="row">
		<div class="col-xs-4 form-group">
			<label for="disabledSelect">Выберите счет:</label> 
		<spring:select path="account" class="form-control">
		
		<c:forEach items="${user_accounts}" var="acc">
		<spring:option value="${acc.account}">${acc.account} (${acc.money} руб.)</spring:option>
		</c:forEach>
		</spring:select>
		</div>
</div>
<div class="row">
		<div class="col-xs-4 form-group">
			
				<spring:hidden class="form-control" path="login" />
			
		</div>
	</div>
<button type="submit" class="btn btn-primary">Завести карточку</button>
</spring:form>


<script type="text/javascript">
	$(function() {
		$('a.action')
				.on(
						'click',
						function(e) {
							var id = this.id;
							var obj = this;
							var numCell = obj.parentNode.cellIndex;
							var numRow = obj.parentNode.parentNode.rowIndex;
							var url = '/webapp-bank-web/rest/users/accounts/cards/'
									+ id;
							$
									.ajax({
										type : "PUT",
										url : url,
										dataType : "json",
										success : function(data) {
											if (obj.innerText == "Заблокировать") {

												obj.innerText = "Разблокировать";
												document.all.dataTables.rows[numRow].cells[numCell - 1].innerText = "Заблокированна";
											} else {

												obj.innerText = "Заблокировать";
												document.all.dataTables.rows[numRow].cells[numCell - 1].innerText = "Доступна";
											}
										}
									});
						});
	});
</script>
</c:if>
</c:if>
<c:if test="${fn:length(user_cards) == 0}"> 
<c:if test="${client.idClient != 0 }">
У клиента нет пластиковых карточек.
<br />
<br />
<c:if test="${client.inf.countAccounts != 0 }">
<spring:form modelAttribute="card" action="newcard.html">
<div class="row">
		<div class="col-xs-4 form-group">
		<div class="form-group">
			<label for="disabledSelect">Выберите счет:</label> 
		<spring:select path="account" class="form-control">
		<c:forEach items="${user_accounts}" var="acc">
		<spring:option value="${acc.account}">${acc.account} (${acc.money} руб.)</spring:option>
		</c:forEach>
		</spring:select>
		<spring:hidden class="form-control" path="login" />
		</div>

		
		</div>
	</div>
<button type="submit" class="btn btn-primary">Завести карточку</button>
</spring:form>
</c:if>
</c:if>
</c:if>

<c:if test="${client.inf.countAccounts == 0 }">
У клиента нет открытых счетов.
</c:if>

<c:if test="${client.idClient == 0 }">
Введите логин клиента:
<spring:form modelAttribute="client" action="cardscl.html">
<div class="row">
		<div class="col-xs-4 form-group">
			<div class="input-group">
				<spring:input class="form-control" path="login" />
			</div>
		</div>
	</div>
<button type="submit" class="btn btn-primary">Показать</button>
</spring:form>
</c:if>



