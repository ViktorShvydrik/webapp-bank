
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Имя</th>
		<th>Фамилия</th>
		<th>Логин</th>
		<th>Емейл</th>
		<th>Открыто счетов</th>
		<th>Деньги на счетах</th>
		<th>Пластиковые карточки</th>
	</tr>

	<tr>
		<td>${user.client.inf.name}</td>
		<td>${user.client.inf.secondName}</td>
		<td>${user.client.login}</td>
		<td>${user.client.inf.email}</td>
		<td>${user.countAcc}</td>
		<td>${user.totalMoney}</td>
		<td>${user.countCards}</td>
	</tr>

</table>
<br />
<br />
<br />
<c:if test="${user.countCards == 0}">
		У Вас нет активных пластиковых карточек. Обратитесь в банк.
		</c:if>
<c:if test="${user.countCards > 0}">
	<h2>Ваши карточки</h2>
	<table class="table table-striped table-bordered table-hover"
		id="dataTables">
		<tr>
			<th>Номер карточки</th>
			<th>Статус</th>
			<th>Действия</th>
		</tr>
		<c:forEach items="${user_cards}" var="card">
			<tr>
				<td width="33%">${card.numberCard}</td>
				<td width="33%">
				<c:if test="${card.status == 1}">Заблокированна</c:if> 
				<c:if test="${card.status == 0}">Доступна</c:if>
				</td>
				<td width="33%">
				<c:if test="${card.status == 0}"><a href="#" class="action" id="${card.idCard}">Заблокировать</a></c:if>
				 <c:if test="${card.status == 1}"><a href="#" class="action" id="${card.idCard}">Разблокировать</a></c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>


<script type="text/javascript">
	$(function() {
		$('a.action')
				.on(
						'click',
						function(e) {
							//отменяем стандартное действие при отправке формы
							e.preventDefault();
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
