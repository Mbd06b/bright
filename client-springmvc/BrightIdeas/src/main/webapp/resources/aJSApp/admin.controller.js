
angular
	.module('BrightIdeas')
	.controller('AdminCtrl', AdminCtrl); 

AdminCtrl.$inject = ['$http'];

function AdminCtrl($http){
	var vm = this; 
	
	
	/* TODO get ideasJSON from spring to replace the simplified placeholder below
	http.get('ideasJSON').then(function(response){
		scope.ideas = response.data; 
	});

	*/
	vm.usersJSON = {};
	
	vm.getUsersJSON = function(){
	
		$http({
			method : 'GET',
			url    : '/BrightIdeas/getAllUsers',
			data   : vm.usersJSON
			}).then(function(response){
				console.log("GET 'getAllUsers' Successful")
				vim.usersJSON = response.data;
			}, function (error){
				console.log(error); 
				}); 
			
		}
		

	
	vm.ideasJSON = [
		{"title":"titlePlaceholder","subtitle":"subtitlePlaceholder","story":"storyPlaceholder"}
		];
	
	
	vm.postIdea = function(){
		
		$http({
			  method  : 'POST',
			  url     : '/BrightIdeas/addIdea',
			  data    : vm.ideasJSON 
			 }).then(function(response) {
			     console.log("Post Successful??");
			     vm.ideasJSON = response.data; 
			      }, function (error){ 
			    	  console.log(error); 
			         });
	}
	
	
	vm.newIdea = {"title":"","subtitle":"","story":""};

	
	
	vm.addIdea = function(){
		vm.ideasJSON.push(angular.copy(vm.newIdea));
		vm.newIdea.title = '';
		vm.newIdea.subtitle = ''; 
		vm.newIdea.story = '';
		
		/* TODO ADD to ideasJSON for return to Spring
		* build entevery
		* scope.ideas.push(scope.enteredIdea);redIdea JSON for deli
		*/
	}
}