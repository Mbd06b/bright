/**
 *  see users.dataservice.js for logic notations and references on dataservice pattern. 
 */
angular
	.module('BrightIdeas')
	.factory('IdeaDataService', IdeaDataService);

IdeaDataService.$inject = ['$http', '$log', 'AuthenticationService'];

function IdeaDataService($http, $log, AuthenticationService){
	var vm = this;  
	var isPrimed = false;
	var primePromise;
	var apiUrl = "/BrightIdeas/idea/";
	
	vm.activeUser = {};
	
	function getSessionUser() {
		return AuthenticationService.getSessionUser()
			.then(function(data) {
				 $log.info("getSessionUser complete... saving data");
			     $log.info(data); 
			     vm.actingUser = data; 
			 return vm.actingUser; 
		   });
	}0	
	
	
	function getIdeas(){
		return $http.get(apiUrl + 'ideas')
			.then(getIdeasComplete)
			.catch(getIdeasFailed);
		
		function getIdeasComplete(response){
			return response.data; 
		}
		function getIdeasFailed(error){
			$log.error('XHR Failed for getIdeas. ' + error.data); 
		}
	}
	
	
	function getIdeaById(id){
		return $http.get(apiUrl + id)
		   .then(getIdeaComplete)
		   .catch(getIdeaFailed);
		
		function getIdeaComplete(response){
			return response.data;
		}
		
		function getIdeaFailed(error){
			$log.error('XHR Failed for getIdea:' + id + " " + error.data); 
		}
	}
	
	function createNewIdea(idea){
		
		return getSessionUser()
			.then(postIdea); 
			
		
			function postIdea(){ 
				$log.info("Idea info: ");
				$log.info(idea); 
				idea.actingUser = vm.actingUser; 
				$log.info("postIdea url: " + apiUrl);
				$http.post(apiUrl, idea)
				.then(createIdea)
				.catch(createIdeaFailed);	
     		}
			function createIdea(repsonse){
				return response.data;
			}
			
			function createIdeaFailed(error){
				$log.error('XHR Failed for createNewIdea: ' + idea.title + ' ' + error.data);
			}
		
	}
	
	function deleteIdea(id){
		return $http.delete(apiUrl + id)
			.then(deleteIdeaComplete)
			.catch(deleteIdeaFailed);
		
		function deleteIdeaComplete(response){
			$log.info("Response Recieved");
			$log.info(response.data);
			return response.data
		}
		
		function deleteUserFailed(error){
			$log.error('XHR Failed for deleteIdea:' + id + " " + error.data);
		}
	}
	
	
	return {
		getSessionUser: getSessionUser,
		getIdeas     : getIdeas,
		getIdeaById  : getIdeaById,
		createNewIdea: createNewIdea,
		deleteIdea   : deleteIdea
	};
	
	
	
}