<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>



		<table class="table table-striped table-bordered table-hover" id="dataTables">
				<tr>
				<th> Номер перевода </th>
				<th>С какого счета</th>
				<th>Деньги</th>
				<th>На какой счет</th>
			</tr>
				<c:forEach items="${transfers_list}" var="tr">
				<tr>
					<td>${tr.idTransfer}</td> 
					<td>${tr.fromAcc}</td>
					<td>${tr.money}</td>
					<td>${tr.toAcc}</td>
					
				</tr>
				</c:forEach>
		</table>
		

		<br />