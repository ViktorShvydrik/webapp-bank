<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">

			<li><a href="${pageContext.request.contextPath}/client/home.html"><i
					class="fa fa-list-alt fa-fw"></i> <s:message code="page.menu.navigation.home" /></a></li>

			<li><a href="#"><i class="fa fa-table fa-fw"></i> <s:message code="page.menu.navigation.accManag" /> <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/client/accounts.html"><s:message code="page.menu.navigation.accManag.accounts" /></a>
					</li>
					<li><a href="${pageContext.request.contextPath}/client/refill.html"><s:message code="page.menu.navigation.accManag.refill" /></a></li>
					<li><a href="#"><s:message code="page.menu.navigation.accManag.transfers" /><span class="fa arrow"></span></a>
						<ul class="nav nav-third-level">
							<li><a href="${pageContext.request.contextPath}/client/transfers/transfers.html"><s:message code="page.menu.navigation.accManag.transfers.all" /></a></li>
							<li><a href="${pageContext.request.contextPath}/client/transfers/betweenOwnAcc.html"><s:message code="page.menu.navigation.accManag.transfers.between" /></a></li>
							<li><a href="${pageContext.request.contextPath}/client/transfers/transfersToAll.html"><s:message code="page.menu.navigation.accManag.transfers.other" /></a></li>


						</ul> <!-- /.nav-third-level --></li>

				</ul> <!-- /.nav-second-level --></li>


			<li><a href="#"><i class="fa fa-credit-card fa-fw"></i> <s:message code="page.menu.navigation.cards" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/client/cards.html"> <s:message code="page.menu.navigation.cards.my" /></a></li>

				</ul> <!-- /.nav-second-level --></li>
			<li><a href="${pageContext.request.contextPath}/logout.html"><i class="fa fa-sign-out fa-fw"></i> <s:message code="page.menu.logout" /></a></li>
			<sec:authorize access="hasAuthority('administrator')">
			<li><a href="${pageContext.request.contextPath}/admin/index.html"> <s:message code="page.menu.admin" /></a></li>
			</sec:authorize>
			



		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->

<script>

</script>