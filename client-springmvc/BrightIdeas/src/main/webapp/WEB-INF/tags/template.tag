<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<jsp:directive.attribute name="head" required="false" fragment="true"/>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" href="<c:url value="/resources/favicon.ico" />" type="image/ico" sizes="16x16">
		<title> BrightIdeas </title>

		<c:url value="/" var="baseUrl" />
		<c:set value="${fn:length(baseUrl)}" var="baseUrlLen" />
		<c:set var="baseUrl" value="${fn:substring(baseUrl, 0, baseUrlLen - 1)}"/>
		
		
		<!-- USE CDN RESOURCES for AngularJs with Angular Bootstrap UI Library Source: https://angular-ui.github.io/bootstrap/-->
		<link data-require="bootstrap-css@3.3.7" data-semver="3.3.7" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
		 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
		 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-resource.js"></script>
		 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-animate.js"></script>
		 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-touch.js"></script>
		 <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.14.3/ui-bootstrap-tpls.min.js"></script>
		 
		 
		
		

		
	<jsp:invoke fragment="head" />
	</head>
	<body data-ng-app="BrightIdeas"> 
		<jsp:doBody />
		
				<script type="text/javascript" src="${baseUrl}/resources/project.js" ></script>
		
		<!--  Angular JS App Resources -->
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/brightIdeas.module.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/brightIdeas.config.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/ui/nav.controller.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/authentication.dataservice.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/ideas/ideas.dataservice.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/users/users.dataservice.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/ideas/ideas.controller.js"></script>
		<script type="text/javascript" src="${baseUrl}/resources/aJSApp/users/users.controller.js"></script>	
	</body>
</html>