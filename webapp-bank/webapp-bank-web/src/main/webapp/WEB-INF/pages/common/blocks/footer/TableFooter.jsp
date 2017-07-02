<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>	
	
	
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.js"></script>
    
    <script>
    $(document).ready(function() {
    	var lang = '<s:message code="language.table" />';
    	var URL = '${pageContext.request.contextPath}/resources/i18n/'+lang+'.json';
        $('#dataTables').DataTable({
        	language: {
                url: URL
            }
        });
    });
    </script>