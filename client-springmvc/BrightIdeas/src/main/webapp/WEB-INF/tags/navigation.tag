<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:directive.attribute name="navigation" required="false" fragment="true"/>

<%@ tag language="java" pageEncoding="UTF-8"%>
	<nav class="navbar navbar-default" data-ng-controller="NavCtrl">
	    <div class="container-fluid">
	      <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-ng-click="isCollapsed = !isCollapsed" aria-expanded="true">
	          <span class="sr-only">Toggle navigation</span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	          <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="landing">BrightIdeas</a>
	      </div>
	
	      <div class="navbar-collapse uib-collapse in" data-uib-collapse="isCollapsed" aria-expanded="true">
	        <ul class="nav navbar-nav">
	          <li class="active"><a href="home">Home<span class="sr-only">(current)</span></a></li>
	          <li>
	          	<form class="navbar-form navbar-left" role="search">
		          <div class="form-group">
		            <input type="text" class="form-control" placeholder="Search">
		          </div>
		          <button type="submit" class="btn btn-default">Submit</button>
		        </form>
	          </li>
	        </ul>
	       
	       
		       
			      <ul class="nav navbar-nav navbar-right">
			       <c:choose>
			       
		             <c:when test="${empty user}">
			           <li><a href="login">Login</a></li>
			    	 </c:when>
			    	 
			         <c:otherwise>  
				          <li class="uib-dropdown" data-uib-dropdown>
					         <a href="#" class="uib-dropdown-toggle" data-uib-dropdown-toggle role="button" aria-expanded="false"><c:out value="${ name }" /><span class="caret"></span></a>
					         <ul class="uib-dropdown-menu" role="menu">
						        <li><a href="#">Your Ideas</a></li>
						        <li><a href="#">Your Tasks</a></li>
						        <li class="divider"></li>
						        <li><a href="#!/admin">Admin</a></li>
						        <li class="divider"></li>
						        <li><a href="login/logout">Logout</a></li>
					        </ul>
				          </li>
			          </c:otherwise>
			       
			         </c:choose>
			         
			        </ul>
	      </div>
	    </div>
	  </nav>