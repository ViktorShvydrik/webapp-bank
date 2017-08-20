<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">

			<li><a href="${pageContext.request.contextPath}/admin/index.html"><i
					class="fa fa-list-alt fa-fw"></i> <s:message code="page.menu.navigation.home" /></a></li>

			<li><a href="#"><i class="fa fa-table fa-fw"></i> <s:message code="page.menu.navigation.accManag" /> <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#"><s:message code="page.menu.navigation.accManag.accounts" /><span class="fa arrow"></span></a>
					<ul class="nav nav-third-level">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/admin/accounts.html"><s:message code="page.menu.navigation.accManag.accounts.allAccTrans" /></a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/admin/accounts_cl.html"><s:message code="page.menu.navigation.accManag.accounts.oneCustomerAndNew" /></a>
                                        </li>
                                    </ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/admin/refill.html"><s:message code="page.menu.navigation.accManag.reWi" /> </a></li>
					<li><a href="${pageContext.request.contextPath}/admin/transfers.html"><s:message code="page.menu.navigation.accManag.allTransfers" /></a></li>
						


					

				</ul> <!-- /.nav-second-level --></li>


			<li><a href="#"><i class="fa fa-credit-card fa-fw"></i>	<s:message code="page.menu.navigation.cards" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/admin/cards.html"><s:message code="page.menu.navigation.cards.all" /></a></li>
					<li><a href="${pageContext.request.contextPath}/admin/cardsclient.html"><s:message code="page.menu.navigation.cards.customer" /></a></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><a href="${pageContext.request.contextPath}/admin/profil.html"><s:message code="page.menu.edit" /></a></li>
			<li><a href="${pageContext.request.contextPath}/admin/newclient.html"><s:message code="page.menu.create" /></a></li>
			<li><a href="${pageContext.request.contextPath}/logout.html"><i class="fa fa-sign-out fa-fw"></i> <s:message code="page.menu.logout" /></a></li>
			<li><a href="${pageContext.request.contextPath}/client/home.html"><s:message code="page.menu.client" /></a></li>



		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->

<script>

</script>