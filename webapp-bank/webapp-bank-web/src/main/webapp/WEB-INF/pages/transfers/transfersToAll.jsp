<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


<h4> Последнии 5 переводов:</h4>
<table class="table table-striped table-bordered table-hover"	id="dataTables">
	<thead>
	<tr>
	
		<th width="25%">Номер перевода</th>
		<th width="25%">С какого счета</th>
		<th width="25%">Деньги</th>
		<th width="25%">На какой счет</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${transfers_list}" var="tr">
		<tr>
			<td>${tr.idTransfer}</td>
			<td><c:if test="${tr.fromAcc.account > 0}"> ${tr.fromAcc.account}</c:if></td>
			<td>${tr.money}</td>
			<td>${tr.toAcc.account}</td>

		</tr>
	</c:forEach>
	</tbody>
</table>

<br /><br /><br />	
		
<c:if test="${user.countAcc == 0}">У Вас нет открытых счетов.  </c:if>

<c:if test="${user.countAcc > 0}">
<spring:form modelAttribute="transfer" id="form" action="">
	<div class="row">
		<div class="col-xs-4 form-group">
			<label for="disabledSelect">Укажите откуда:</label> 
		<spring:select path="fromAcc" id="accA" class="form-control">
		<c:forEach items="${user_accounts}" var="acc">
		<spring:option value="${acc.account}">${acc.account} (${acc.money} руб.)</spring:option>
		</c:forEach>
		</spring:select>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 form-group">
			<label for="exampleInputAmount">Укажите сумму:</label>
			<div class="input-group">
				<div class="input-group-addon"><span class="glyphicon glyphicon-rub" aria-hidden="true"></span></div>
				<spring:input class="form-control" id="money" path="money" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class=" col-xs-4 form-group">
			<label for="disabledSelect">Укажите куда:</label> 
				<spring:input class="form-control" path="toAcc" id="accB" />
		
				
		</div>
	</div>
	
	<div class="row">
	<button type="submit" class="btn btn-primary">Перевести</button>
	</div>
</spring:form>
</c:if>
<br />

<script type="text/javascript">
$(function() {
	$('#form').submit(function(e) {
		//отменяем стандартное действие при отправке формы
		e.preventDefault();
		var objA = document.all.form.accA;
		var objB = document.all.form.accB;
		var accA = objA.value;
		var accb = objB.value;
		var money = document.all.form.money.value
		
		var url = '/webapp-bank-web/rest/users/accounts/'+accA+'/Transfer/'+accb+'/'+money;
		$.ajax({
					type : "POST",
					url : url,
					dataType : "json",
					success : function(data) {
						console.log(document.all.dataTables.rows.length);
						if(document.all.dataTables.rows.length > 5){
							document.all.dataTables.deleteRow(5);
						}
						newrow = document.all.dataTables.insertRow(1);
							newcell = newrow.insertCell(0);
							newcell.innerText = data.idTransfer;
							newcell = newrow.insertCell(1);
							newcell.innerText = data.fromAcc.account;
							newcell = newrow.insertCell(2);
							newcell.innerText = data.money;
							newcell = newrow.insertCell(3);
							newcell.innerText = data.toAcc.account;
					
							objA.options[objA.selectedIndex].text = data.fromAcc.account + "(" + data.fromAcc.money + " руб.)";
							
							
				}
	});
});
});
</script>