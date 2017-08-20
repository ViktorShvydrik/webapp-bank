
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



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
		<c:forEach items="${users_cards}" var="card">
			<tr>
				<td >${card.numberCard}</td>
				<td><a href="cardscl.html?login=${card.login}" >${card.login}</a></td>
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