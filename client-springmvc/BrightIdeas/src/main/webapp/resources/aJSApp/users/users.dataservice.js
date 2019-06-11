//dataservice factory JohnPapa Style   https://github.com/johnpapa/angular-styleguide/blob/master/a1/README.md#style-y060
//Other reference for this design pattern - http://websystique.com/springmvc/spring-mvc-4-angularjs-example/

angular
    .module('BrightIdeas')
    .factory('UserDataService', UserDataService);

UserDataService.$inject = ['$http', '$log'];

function UserDataService( $http, $log ){
	var isPrimed = false;
	var primePromise;
	
	return {
		getUsers     : getUsers,
		getUserById  : getUserById,
		createNewUser: createNewUser,
		updateUser   : updateUser,
		deleteUser   : deleteUser
	};
	
	//When ready to move to the Provider. 
	//var apiUrl = "http://localhost:7000/api/user/";
	var apiUrl= "/BrightIdeas/user/"
	
	//this is a simple GET request "promise" object using the $http service
	function getUsers(){
		return $http.get(apiUrl + 'users')
		   .then(getUsersComplete)  
		   .catch(getUsersFailed);  
		
		// this callback will be called asynchronously when the response is available
		function getUsersComplete(response){
			return response.data; 
		}
		
		// this callback will be called asynchronously when error occurs
		function getUsersFailed(error){
			$log.error('XHR Failed for getUsers. ' + error.data); 
		}
	}
	
	
	function getUserById(id){
		return $http.get(apiUrl + id)
		   .then(getUserComplete)
		   .catch(getUserFailed);
		
		function getUserComplete(response){
			return response.data;
		}
		
		function getUserFailed(error){
			$log.error('XHR Failed for getUser:' + id + " " + error.data); 
		}
	}
	
	
	
	function createNewUser(user){
		return $http.post(apiUrl, user)
		   .then(createUser)
		   .catch(createUserFailed);
		
		function createUser(response){
			return response.data;
		}
		
		function createUserFailed(error){
			$log.error('XHR Failed for addUser:' + user.firstName + " " + error.data); 
		}
		
	}
	
	
	function updateUser(user){
		return $http.put(apiUrl, user)
		   .then(updateUser)
		   .catch(updateUserFailed);
		
		function updateUser(response){
			return response.data;
		}
		
		function updateUserFailed(error){
			$log.error('XHR Failed for updateUser:' + user.id + " " + error.data); 
		}
	}
	
	
	function deleteUser(id){
		return $http.delete(apiUrl + id)
		   .then(deleteUserComplete)
		   .catch(deleteUserFailed);
		
        function deleteUserComplete(response){
        	$log.info("Response Recieved");
        	$log.info(response.data);
        	return response.data;
        }
        
        function deleteUserFailed(error){
        	$log.error('XHR Failed for deleteUser:' + id + " " + error.data);
        }
	}
	
	

	
}
	

	
