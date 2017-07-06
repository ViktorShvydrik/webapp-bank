<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">

			<li><a href="${pageContext.request.contextPath}/admin/index.html"><i
					class="fa fa-list-alt fa-fw"></i> Главная страница</a></li>

			<li><a href="#"><i class="fa fa-table fa-fw"></i> Управление
					счетами <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/admin/accounts.html">Счета</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/admin/refill.html">Пополнить
							баланс</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/transfers.html">Переводы</a></li>
						


					

				</ul> <!-- /.nav-second-level --></li>


			<li><a href="#"><i class="fa fa-credit-card fa-fw"></i>
					Пластиковые карточки<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/admin/cards.html">Мои
							карточки</a></li>

				</ul> <!-- /.nav-second-level --></li>
			<li><a href="${pageContext.request.contextPath}/logout.html">Выход</a></li>
			<li><a href="${pageContext.request.contextPath}/userPage.html">Клиент</a></li>
			<li><a href="${pageContext.request.contextPath}/operator/index.html">Оператор</a></li>



		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->

<script>

</script>