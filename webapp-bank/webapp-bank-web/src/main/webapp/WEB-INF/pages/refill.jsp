=<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		</table >
		
			<br />
		<br />

	<c:if test="${user.countAcc == 0}">У Вас нет открытых счетов.  </c:if> 
	<c:if test="${user.countAcc > 0}">
	<spring:form modelAttribute="refill" method="POST" id="refill">
		<spring:select path="idAccount" id="id">
		<c:forEach items="${user_accounts}" var="acc">
		<spring:option value="${acc.idAccount}">${acc.account} (${acc.money} руб.)</spring:option>
		</c:forEach>
		</spring:select>
		
		<spring:input path="money" id="money"/>
		<input  type="submit" value="Пополнить">
	</spring:form>
	
	</c:if>


<script type="text/javascript">
$(function(){ 
	$('#refill').submit(function(e){
		//отменяем стандартное действие при отправке формы
		e.preventDefault();
		var select = document.getElementById('id');
		var id = select.value;
		var money = document.getElementById('money').value;
		var url = '/webapp-bank-web/rest/users/accounts/'+id+'/'+ money;
		$.ajax({
			type: "POST",
			url: url,
			dataType: "json",
			success: function(data){
				select.options[select.selectedIndex].text = data.account + "(" + data.money + " руб.)";
				var totalMoney = Number(document.all.inf.rows[1].cells[5].innerText);
				totalMoney = Number(totalMoney) + Number(money);
				document.all.inf.rows[1].cells[5].innerText = totalMoney;
				
			}
			});
		});
	});
</script>
