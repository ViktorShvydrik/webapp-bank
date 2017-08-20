<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>	

<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
 <script>
$(document).ready(function(){
 
  function formSwitch(e) {
    var self = $(this),
        form = $('div');
    
    if(form.hasClass('back-visible')) 
    {
       self.siblings($('h2')).html('<s:message code="page.index.account" />');
       self.html('<s:message code="page.index.registration" />');
       form.removeClass('back-visible');
    } else {
      self.siblings($('h2')).html('<s:message code="page.index.registered" />');
      self.html('<s:message code="page.index.login" />');
      form.addClass('back-visible');
    }
    
    e.preventDefault();
  }
  
  $('#form-switch').on('click', formSwitch);
  
});
</script>