
angular
	.module('BrightIdeas')
	.controller('IdeasAdminCtrl', IdeasAdminCtrl); 

IdeasAdminCtrl.$inject = ['IdeaDataService', '$log', '$uibModal'];

function IdeasAdminCtrl(IdeaDataService, $log, $uibModal){
	var vm = this; 
	
	//modal states
	vm.animationsEnabled = true; 

	vm.status = {
			    isCustomHeaderOpen: false,
			    isFirstOpen: true,
			    isFirstDisabled: false
	 };
	
	
    vm.ideaObject  = {}; 
	vm.ideas = []; 
	vm.newIdea = {'title':'','subtitle':'','story':'', 'actingUser':''}; 
	vm.title = "Ideas"; 

	
	initIdeas(); 
	
	function initIdeas(){
		return getIdeas().then(function(){
			$log.info("Activated Ideas Controller"); 
		});
	}
	
	function getIdeas() {
		return IdeaDataService.getIdeas()
			.then(function(data) {
				vm.ideas = data; 
				return vm.ideas; 
			}); 
	}
	
	vm.deleteIdea = function(idea){
		return IdeaDataService.deleteIdea(idea.id)
			.then(function(response){
				$log.info(response);
				initIdeas(); 
			})
	}
	
	
	
	
	vm.submitCreateIdea = function(){
		return IdeaDataService.createNewIdea(vm.newIdea)
			.then(function(response){
				$log.info("Create Idea Request Completes");
				$log.info(response);
				vm.clearForm(); 
				initIdeas(); 
			}) 
	}
	
	
	vm.getIdeaById = function(id){
			return IdeaDataService.getIdeaById(id)
				.then(function(data){
					vm.ideaObject = data;
					return vm.ideaObject; 
				});			
		}

	
	vm.clearForm = function(){
		vm.newIdea.title = '';
		vm.newIdea.subtitle = ''; 
		vm.newIdea.story = ''; 
	}
	
	//----Modal Controls -----


	  vm.openUpdateIdeaDialog = function (size, idea) {
		   var modalInstance = $uibModal.open({
		      
			  animation: true,
		      ariaLabelledBy: 'modal-title',
		      ariaDescribedBy: 'modal-body',
		      templateUrl: 'resources/aJSApp/ideas/ideaUpdateDialog.html',
		      controller: 'UpdateIdeaModalCtrl',
		      controllerAs: 'vm',
		      size: size,
		      resolve: {
		        data: function () {
		        	//pass idea to modal instance
		        	return idea; 
		        }
		      }
		    });

		    modalInstance.result.then(function () {
		      //refresh user list only after submitUpdate(); 
		    	initIdeas(); 	
		    }, function(res){
		    	//handles backdrop click;
		    });
		  }
		
		vm.openAddIdeaDialog = function (size){
			var modalInstance = $uibModal.open({
				animation: true,
				ariaLabelledBy: 'modal-title',
				ariaDescribedBy: 'modal-body',
				templateUrl: 'resources/aJSApp/ideas/createIdeaDialog.html',
				controller: 'CreateIdeaModalCtrl',
				controllerAs: 'vm',
				size: size,
				resolve: {
					data: function () {
					}
				}
			});
			
			 modalInstance.result.then(function () {
			      //refresh Idea list only after addUser(); 
			    	initIdeas();    	
			}, function(res){
				//handles backdrop click.
			});
		}
		  
	}

	//------Modal Instance Controllers ---------------

	angular
		.module('BrightIdeas')
		.controller('UpdateIdeaModalCtrl', UpdateIdeaModalCtrl) 
		 
	UpdateIdeaModalCtrl.$inject = ['IdeaDataService', '$uibModalInstance', 'data', '$log'];
			
	function UpdateIdeaModalCtrl(IdeaDataService, $uibModalInstance, data, $log){
		var vm = this;
		  vm.title = angular.copy(data.title); 
		  vm.idea = angular.copy(data);
		  
		  vm.submitUpdate = function () {
			  
		     return IdeaDataService.updateIdea(vm.idea)
				    .then(function(data){
				    $log.info("Put Request Completes");
				    $log.info(data); 
					vm.idea = data;
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
	.controller('CreateIdeaModalCtrl', CreateIdeaModalCtrl) 
	 
	CreateIdeaModalCtrl.$inject = ['IdeaDataService', '$uibModalInstance', 'data', '$log'];
		
	function CreateIdeaModalCtrl(IdeaDataService, $uibModalInstance, data, $log){
		var vm = this;
			
		vm.idea = {'title':'','subtitle':'','story':''};
		  
		  vm.submitCreateUser = function () {
			  
			     return IdeaDataService.createNewIdea(vm.idea)
					    .then(function(response){
					    $log.info("Create Idea Request Completes");
					    $log.info(response); 
						$uibModalInstance.close();
					});
				  
			    
			    $uibModalInstance.close();
			  };
		
		  vm.cancel = function () {
		    
		    $uibModalInstance.close();
		  };

	}		

