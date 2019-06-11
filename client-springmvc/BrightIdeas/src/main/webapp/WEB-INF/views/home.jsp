<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<tags:template>
	<jsp:attribute name="head">  
		<script type="text/javascript">
			// inline JavaScript here 
		</script>
  	</jsp:attribute>  
	<jsp:body>
		<tags:navigation /> 
		
	<div class="pageContainer">
		<ul class="nav nav-tabs">
			<li><a href="#!/" data-toggle="tab">Ideas</a><li>
			<li><a href="#!/createIdea"	data-toggle="tab">Create Idea</a></li>
			<li><a href="#" data-toggle="tab">Tasks</a>
			<li><a href="#!/admin" data-toggle="tab">Admin</a></li>
		</ul>
		
		<main data-ng-view>
		
		</main>

			</div>		
	
		        	
		
		<!-- Using Java JSTL library to pull in, and format date  -->
		<jsp:useBean id="date" class="java.util.Date"> 
		The date is: <fmt:formatDate value="${date}" type="both" />
		</jsp:useBean>
				
				
		</div>
	</jsp:body>
</tags:template>