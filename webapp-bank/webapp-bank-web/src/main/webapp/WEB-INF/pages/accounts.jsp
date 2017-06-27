<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


        
        <table class="table table-striped table-bordered table-hover" id="inf">
				<tr>
				<th> Имя </th>
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
	<c:if test="${user.countAcc > 0}">
	<h2>Ваши счета:</h2>
	<table class="table table-striped table-bordered table-hover" id="dataTables">
		<thead>
			<tr>
				<th>Счет</th>
				<th>Баланс</th>
				<th>Действия</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user_accounts}" var="acc">
				<tr>
					<td>${acc.account }</td>
					<td>${acc.money }</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<button type="button" class="btn btn-primary btn-lg btn-block">Открыть новый счет</button>
</c:if>
	<c:if test="${user.countAcc == 0}">У Вас нет открытых счетов. 
	<br />
	<button type="button" class="btn btn-primary btn-sm">Открыть новый счет</button>
	<a href="newAccountUser.html">Открыть новый счет</a> </c:if> 
	
	<<script type="text/javascript">

		$(function(){
		    $('button').bind('click', function(){
			var id = ${user.client.idClient};
			var url = '/webapp-bank-web/rest/users/'+id+'/accounts/';
			$.ajax({
				type: "PUT",
				url: url,
				dataType: "json",
				success: function(data){
					newrow = document.all.dataTables.insertRow()
					newcell = newrow.insertCell(0);
					newcell.innerText=data.account;
					newcell = newrow.insertCell(1);
					newcell.innerText=data.money;
					newcell = newrow.insertCell(2);

					var countAcc = Number(document.all.inf.rows[1].cells[4].innerText);
					countAcc = countAcc + 1;
					document.all.inf.rows[1].cells[4].innerText = countAcc;
					
				}
				});
			});
		});
	
	</script>
	
	
	
