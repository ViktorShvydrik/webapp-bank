<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>


        
        <table class="table table-striped table-bordered table-hover" id="inf">
			<tr>
				<th> <s:message code="page.table.thead.name" /> </th>
				<th> <s:message code="page.table.thead.secondName" /></th>
				<th> <s:message code="page.table.thead.login" /></th>
				<th> <s:message code="page.table.thead.email" /></th>
				<th> <s:message code="page.table.thead.allAccounts" /></th>
				<th> <s:message code="page.table.thead.money" /></th>
				<th> <s:message code="page.table.thead.cards" /></th>

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

	<c:if test="${user.countAcc == 0}"><s:message code="page.error.accounts.no" />  </c:if>
<c:if test="${user.countAcc > 0}">

	<spring:form modelAttribute="refill" method="POST" id="refill"	action="addrefill.html">

		<div class="row">
			<div class="col-xs-4 form-group">
			
				<div class="form-group">
					<label for="account"><s:message code="page.context.refill.amount" />:</label>
						<spring:select path="idAccount" id="id" class="form-control">
							<c:forEach items="${user_accounts}" var="acc">
								<spring:option value="${acc.idAccount}">${acc.account} (${acc.money} <s:message code="page.context.rub" />)</spring:option>
							</c:forEach>
						</spring:select>
				</div>

				<div class="form-group">
					<label for="exampleInputAmount"><s:message code="page.context.refill.select" />:</label>
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-rub" aria-hidden="true"></span>
							</div>
						<spring:input type="number" class="form-control" id="money"	path="money" min="0" />
					</div>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary" id="btn"><s:message code="page.context.button.refill" /></button>
	</spring:form>

</c:if>


<script type="text/javascript">
$(function(){ 
	$('#refill').submit(function(e){
		
		e.preventDefault();
		var select = document.getElementById('id');
		var id = select.value;
		var money = document.getElementById('money').value;
		var url = '/webapp-bank-web/rest/users/accounts/'+id+'/'+ money;
		var rub = ' <s:message code="page.context.rub" />';
		$.ajax({
			type: "POST",
			url: url,
			dataType: "json",
			success: function(data){
				select.options[select.selectedIndex].text = data.account + "(" + data.money + rub +")";
				var totalMoney = Number(document.all.inf.rows[1].cells[5].innerText);
				totalMoney = Number(totalMoney) + Number(money);
				document.all.inf.rows[1].cells[5].innerText = totalMoney;
				
			}
			});
		});
	});
</script>
