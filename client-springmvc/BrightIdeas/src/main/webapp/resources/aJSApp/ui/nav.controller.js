angular
	.module('BrightIdeas')
	.controller('NavCtrl', NavCtrl); 

function NavCtrl(){
	var vm = this; 
	
	vm.isCollapsed = true; 
}