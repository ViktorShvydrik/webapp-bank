<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
    <head>
    <tiles:insertAttribute name="include" />

		<title>
			<tiles:importAttribute name="appTitle" /> 
			<s:message code="${appTitle}" />
		</title>
	 </head>

    <body>
    <tiles:insertAttribute name="content" />
    
    
    
    <tiles:insertAttribute name="footer" />
    </body>
</html>
