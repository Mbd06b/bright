//Building controllers AngularJS dataservice - http://websystique.com/springmvc/spring-mvc-4-angularjs-example/

angular
	.module('BrightIdeas')
	.controller('UserAdminCtrl', UserAdminCtrl);

//inject a dataservice

UserAdminCtrl.$inject = ['UserDataService', '$log', '$uibModal'];

function UserAdminCtrl(UserDataService, $log, $uibModal){
	var vm = this;
	
	//modal states
	vm.animationsEnabled = true; 
	
	
    vm.userObject  = {}; // set a template? 
	vm.users = []; 
	vm.user = {'email':'','firstName':'','lastName':'','password':''}; 
	vm.id = null; 
	vm.title = "Users"; 
	
   vm.status = {
			    isCustomHeaderOpen: false,
			    isFirstOpen: true,
			    isFirstDisabled: false
			  };
	
	initUsers();

	function initUsers(){
		return getUsers().then(function(){
			$log.info("Activated Users Controller"); 
		});
	}
	
	function getUsers() {
		return UserDataService.getUsers()
			.then(function(data) {
			 vm.users = data; 
			 return vm.users; 
		   });
	}
	

	vm.deleteUser = function(user) {
			return UserDataService.deleteUser(user.id)
				.then(function(response){
						$log.info(response);
						initUsers();
				});
		}
				
		
	vm.getUserById = function(id){
			return UserDataService.getUserById(id)
				.then(function(data){
					vm.userObject = data;
					return vm.userObject; 
				});			
		}
		
	

//----Modal Controls -----


  vm.openUpdateUserDialog = function (size, user) {
	   var modalInstance = $uibModal.open({
	      
		  animation: true,
	      ariaLabelledBy: 'modal-title',
	      ariaDescribedBy: 'modal-body',
	      templateUrl: 'resources/aJSApp/users/userUpdateDialog.html',
	      controller: 'UpdateUserModalCtrl',
	      controllerAs: 'vm',
	      size: size,
	      resolve: {
	        data: function () {
	        	//pass user to modal instance
	        	return user; 
	        }
	      }
	    });

	    modalInstance.result.then(function () {
	      //refresh user list only after submitUpdate(); 
	    	initUsers(); 	
	    }, function(res){
	    	//handles backdrop click;
	    });
	  }
	
	vm.openAddUserDialog = function (size){
		var modalInstance = $uibModal.open({
			animation: true,
			ariaLabelledBy: 'modal-title',
			ariaDescribedBy: 'modal-body',
			templateUrl: 'resources/aJSApp/users/createUserDialog.html',
			controller: 'CreateUserModalCtrl',
			controllerAs: 'vm',
			size: size,
			resolve: {
				data: function () {
				}
			}
		});
		
		 modalInstance.result.then(function () {
		      //refresh user list only after addUser(); 
		    	initUsers();    	
		}, function(res){
			//handles backdrop click.
		});
	}
	  
}

//------Modal Instance Controllers ---------------

angular
	.module('BrightIdeas')
	.controller('UpdateUserModalCtrl', UpdateUserModalCtrl) 
	 
UpdateUserModalCtrl.$inject = ['UserDataService', '$uibModalInstance', 'data', '$log'];
		
function UpdateUserModalCtrl(UserDataService, $uibModalInstance, data, $log){
	var vm = this;
	  vm.firstName = angular.copy(data.firstName); 
	  vm.user = angular.copy(data);
	  
	  vm.submitUpdate = function () {
		  
	     return UserDataService.updateUser(vm.user)
			    .then(function(data){
			    $log.info("Put Request Completes");
			    $log.info(data); 
				vm.user = data;
				 $uibModalInstance.close();
			});
	    $uibModalInstance.close();
	  };

	  vm.cancel = function () {
	    $uibModalInstance.close();
	  };

}		


angular
.module('BrightIdeas')
.controller('CreateUserModalCtrl', CreateUserModalCtrl) 
 
CreateUserModalCtrl.$inject = ['UserDataService', '$uibModalInstance', 'data', '$log'];
	
function CreateUserModalCtrl(UserDataService, $uibModalInstance, data, $log){
	var vm = this;
		
	vm.user = {'email':'','firstName':'','lastName':'','password':''};
	  
	  vm.submitCreateUser = function () {
		  
		     return UserDataService.createNewUser(vm.user)
				    .then(function(response){
				    $log.info("Create User Request Completes");
				    $log.info(response); 
					$uibModalInstance.close();
				});
			  
		    
		    $uibModalInstance.close();
		  };
	
	  vm.cancel = function () {
	    
	    $uibModalInstance.close();
	  };

}		
	