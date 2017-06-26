
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<meta charset="utf-8">

<tiles:insertAttribute name="include" />

	<title>
		<tiles:importAttribute name="appTitle" /> 
		<s:message code="${appTitle}" />
	</title>
</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"	style="margin-bottom: 0">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu" />
		</nav>



		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							<tiles:importAttribute name="pageTitle" />
							<s:message code="${pageTitle}" />
						</h1>
					</div>
					<tiles:insertAttribute name="content" />
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->


	</div>


	


	<tiles:insertAttribute name="footer" />

</body>
</html>