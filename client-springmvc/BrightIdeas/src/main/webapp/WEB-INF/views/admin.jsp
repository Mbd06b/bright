<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tags:template>
	<jsp:attribute name="head">  
		<script type="text/javascript">
			// inline JavaScript here 
		</script>
		
		<style>
		
		</style>
  	</jsp:attribute>  
	<jsp:body>
		<tags:navigation /> 
	
	<div data-ng-controller="UserAdminCtrl as vm">
		<h2>{{vm.title}}</h2>
		  <table class="table table-hover">
			<thead>
				<th scope="col">id</th>
				<th scope="col">email</th>
				<th scope="col">Name</th>
				<th socpe="col"></th>
			</thead>
			<tbody> 
				<tr data-ng-repeat="user in vm.users track by $index">
					<th scope="row">{{user.id}}</th>
					<td>{{user.email}}</td>
					<td>{{user.firstName}} {{user.lastName}}</td>
					<td>
					<button type="button" class="btn btn-primary btn-sm" data-ng-click="vm.openUpdateUserDialog('sm', user)">edit</button> 
					<button type="button" class="btn btn-danger btn-sm" data-ng-click="vm.deleteUser(user)">delete</button>
					</td>
				</tr>
				<tr>
					 <th>Add User</th>
					 <td></td>
					 <td></td>
				 	 <td><button type="button" class="btn btn-default btn-md" data-ng-click="vm.openAddUserDialog('sm')">+</button></td>
				</tr>
			</tbody>
		  </table>

		  
		  <h4>Inspect user data:</h4>
		  <form>
		  	<label>Enter Id:<input type="text" data-ng-model="vm.id"></label>
		  	<button type="submit" class="btn btn-default btn-md" data-ng-click="vm.getUserById(vm.id)" formnovalidate>Submit</button>
		  </form>
		    <pre>{{vm.userObject}}</pre>
			
			
			
	 </div>
		
		
	 
	</jsp:body>
</tags:template>