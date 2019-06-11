/**
 * 
 */
angular
    .module('BrightIdeas')
    .config(config);

config.$inject = ['$routeProvider'];

function config($routeProvider) {
    $routeProvider
        .when('/createIdea', {
            templateUrl: 'resources/aJSApp/ideas/createIdea.html',
            controller: 'IdeasAdminCtrl', 
        	controllerAs: 'vm'
        })
        .when('/',{
        	templateUrl: 'resources/aJSApp/userDashboard.html',        	
        })
        .when('/admin', {
        	templateUrl: 'resources/aJSApp/adminDashboard.html',
        });
}