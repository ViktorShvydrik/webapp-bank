<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

 <!-- Navigation -->
	 <div class="navbar-header">
                 <a class="navbar-brand" href="#"><s:message code="application.title.bms" /></a>
            </div>
           
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                 <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <s:message code="page.menu.header.language" /> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                             <a href="?language=en_US">
           						 <s:message code="application.language.en" />
       						 </a>
        
       						
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="?language=ru_RU">
           						 <s:message code="application.language.ru" />
       						 </a>
                        </li>
                        
                    </ul>
                </li>
                
                 
                 <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="my_profil.html"><i class="fa fa-user fa-fw"></i> <s:message code="page.menu.header.profile" /></a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logout.html"><i class="fa fa-sign-out fa-fw"></i> <s:message code="page.menu.logout" /></a>
                        </li>
                    </ul>
                    </li>
                    <!-- /.dropdown-user -->
            </ul>
            <!-- /.navbar-top-links -->
                    