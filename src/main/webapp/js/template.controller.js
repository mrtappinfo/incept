'use strict';
var app = angular.module('snaplync', ['ngResource', 'ngCookies',  'ngAnimate',  'ngTouch',  'ngSanitize','ui.router', 'ui.select','ui.utils', 'ui.bootstrap','ng.httpLoader' ]);

angular.module('snaplync').controller('profileController', ['$state','$rootScope','$scope','$location', '$http', '$filter', '$window', '$compile','sharedProperties',
                                                            function($state, $rootScope, $scope, $location, $http, $filter, $window, $compile,sharedProperties) {

console.log('templatecontroller');
	
	if(sharedProperties.getList()){
	
		console.log('getList check pass');
		
	$scope.recruiters = sharedProperties.getList();
	
	}else{
		console.log('getList cfaoils');
		$scope.recruiters = recruiters;
	}
	
}]);
