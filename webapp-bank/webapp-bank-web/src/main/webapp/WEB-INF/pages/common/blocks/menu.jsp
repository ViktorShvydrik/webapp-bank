<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">

			<li><a href="${pageContext.request.contextPath}/userPage.html"><i
					class="fa fa-list-alt fa-fw"></i> Главная страница</a></li>

			<li><a href="#"><i class="fa fa-table fa-fw"></i> Управление
					счетами <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/accounts.html">Счета</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/refill.html">Пополнить
							баланс</a></li>
					<li><a href="#">Переводы<span class="fa arrow"></span></a>
						<ul class="nav nav-third-level">
							<li><a
								href="${pageContext.request.contextPath}/transfers/transfers.html">Просмотр
									всех переводов</a></li>
							<li><a href="${pageContext.request.contextPath}/transfers/betweenOwnAcc.html">Между своими счетами</a></li>
							<li><a href="${pageContext.request.contextPath}/transfers/transfersToAll.html">На счета других клиентов</a></li>


						</ul> <!-- /.nav-third-level --></li>

				</ul> <!-- /.nav-second-level --></li>


			<li><a href="#"><i class="fa fa-credit-card fa-fw"></i>
					Пластиковые карточки<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/cards.html">Мои
							карточки</a></li>

				</ul> <!-- /.nav-second-level --></li>
			<li><a href="${pageContext.request.contextPath}/logout.html">Выход</a>
			</li>



		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->

<script>

</script>