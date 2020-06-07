<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<tags:template>
	<jsp:attribute name="head">
	
		<!-- REQUIRED Page-specific Libraries to Run Non-Angular Bootstrap for Login -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
			<style>
			/* Form Layout */
				.login-form-wrapper {
				  background: #fafafa;
				  margin: 3em auto;
				  padding: 0 1em;
				  max-width: 370px;
				}
				
				h2 {
				  text-align: center;
				  padding: 1em 0;
				}
				
				form {
				  padding: 0 1.5em;
				}
				
				.form-item {
				  margin-bottom: 0.75em;
				  width: 100%;
				}
				
				.form-item input {
				  background: #fafafa;
				  border: none;
				  border-bottom: 2px solid #e9e9e9;
				  color: #666;
				  font-family: 'Open Sans', sans-serif;
				  font-size: 1em;
				  height: 50px;
				  transition: border-color 0.3s;
				  width: 100%;
				}
				
				.form-item input:focus {
				  border-bottom: 2px solid #c0c0c0;
				  outline: none;
				}
				
				.button-panel {
				  margin: 2em 0 0;
				  width: 100%;
				}
				
				.button-panel .button {
				  background: #f16272;
				  border: none;
				  color: #fff;
				  cursor: pointer;
				  height: 50px;
				  font-family: 'Open Sans', sans-serif;
				  font-size: 1.2em;
				  letter-spacing: 0.05em;
				  text-align: center;
				  text-transform: uppercase;
				  transition: background 0.3s ease-in-out;
				  width: 100%;
				}
				
				.button:hover {
				  background: #ee3e52;
				}
				
				.form-footer {
				  font-size: 1em;
				  padding: 2em 0;
				  text-align: center;
				}
				
				.form-footer a {
				  color: #8c8c8c;
				  text-decoration: none;
				  transition: border-color 0.3s;
				}
				
				.form-footer a:hover {
				  border-bottom: 1px dotted #8c8c8c;
				}
		</style>  
		<script type="text/javascript">
			// inline JavaScript here 
		</script>
  	</jsp:attribute>  
	<jsp:body>
		<tags:navigation /> 
			
		      <div class="login-form-wrapper">
				<h2 class="text-center">Login</h2>
					<form:form method="POST" action="/BrightIdeas/login/" modelAttribute="user">
				    	<div class="form-item">		
			    			<form:label path="email">Email</form:label>
			    			<form:input path="email"  required="required" />
		    			</div>
		    			<div class="form-item">
			    			<form:label path="password">Password</form:label>
			    			<form:input path="password"  required="required" />
		    			</div>
		    			<div class="button-panel">
		    			  <input type="submit" title="Login" value="Login" />
		    			     <img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="/>
				    	</div>
					</form:form>
				 <div class="form-footer">
				    <p><a href="#">Forgot password?</a></p>
				    <br />
				    <div class="container">
					  <h4>Need an Account?</h4>
					  <!-- Trigger the modal with a button -->
					  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Register</button>
					
					
				
					  <!-- Modal -->
					  <div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					      <form:form method="POST" action="/BrightIdeas/addUser" modelAttribute="user">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">Register</h4>
					        </div>
					        <div class="modal-body">
					        
					            
							    	<table>
							    		<tr>
							    			<td><form:label path="email">Email</form:label></td>
							    			<td><form:input path="email"  required="required" /></td>
							    		</tr>
							    		<tr>
							    			<td><form:label path="password">Password</form:label></td>
							    			<td><form:input path="password"  required="required" /></td>
							    		</tr>
							    		<tr>
							    			<td><form:label path="firstName">First Name</form:label></td>
							    			<td><form:input path="firstName"  required="required" /></td>
							    		</tr>
							    		<tr>
							    			<td><form:label path="lastName">Last Name</form:label></td>
							    			<td><form:input path="lastName"  required="required" /></td>
							    		</tr>
							    	</table>
						    	
					        </div>
					        <div class="modal-footer">
					          <button type="submit" class="btn btn-primary">Register</button>
					          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					        </div>
					        </form:form>
					      </div>
					      
					    </div>
					  </div>
					  
					</div>
				  </div>
			</div>
			
			
			<br />
			<br />
			
			
	
	
	
		
		<!-- Using Java JSTL library to pull in, and format date  -->
		<jsp:useBean id="date" class="java.util.Date"> 
		The date is: <fmt:formatDate value="${date}" type="both" />
		</jsp:useBean>
				
				
	
	</jsp:body>
</tags:template>