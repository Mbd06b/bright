angular
    .module('BrightIdeas')
    .factory('AuthenticationService', AuthenticationService);

AuthenticationService.$inject = ['$http', '$log'];

function AuthenticationService( $http, $log ){
	var isPrimed = false;
	var primePromise;
	var clientUrl = "/BrightIdeas/login/sessionUser";
	
	//this is a simple GET request "promise" object using the $http service
	function getSessionUser(){
		return $http.get(clientUrl)
		   .then(getUserComplete)  
		   .catch(getUserFailed);  
		
		// this callback will be called asynchronously when the response is available
		function getUserComplete(response){
			$log.info("getUserComplete(), returning response...");
			$log.info(response.data); 
			return response.data; 
		}
		
		// this callback will be called asynchronously when error occurs
		function getUserFailed(error){
			$log.error('XHR Failed for getSessionUser. ' + error.data); 
		}
	}
	
	
	return {
		getSessionUser     : getSessionUser,
	};
	
}
	
