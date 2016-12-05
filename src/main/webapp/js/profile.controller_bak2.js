'use strict';
var app = angular.module('snaplync', ['ngResource', 'ngCookies',  'ngAnimate',  'ngTouch',  'ngSanitize','ui.router', 'ui.select','ui.utils', 'ui.bootstrap','ng.httpLoader' ]);

angular.module('snaplync').controller('profileController', ['$state','$rootScope','$scope','$location', '$http', '$filter', '$window', '$compile','sharedProperties',
                                                            function($state, $rootScope, $scope, $location, $http, $filter, $window, $compile,sharedProperties) {

	console.log('inside profileController');
	
	var recruitersList = [];
	
	$scope.user = {
			salary: "" ,
			hike: ""
	}
	$scope.jobseeker_hike = jobseeker_hike;
	$scope.jobseeker_salary = jobseeker_salary;
	$scope.maxSalaryPossible=maxSalaryPossible;
	$scope.user.salary = jobseeker_salary;
	$scope.user.hike = jobseeker_hike;

	$scope.sendmessage = function(action){
		
		$http({
			method: 'POST',
			url: '/sendEmail',
			data: action,
			headers: {'Content-type': 'application/json'}
		}).then(function(response){

		}, function errorCallback(response) {
			//$scope.submitting = false;
		});
	};

	$scope.sendrise = function(){

		var args =  $scope.user; 
		
		console.log('inside sendrise');
		//console.log($scope.recruiters);
		
		var response = $http({
			method: 'POST',
			url: '/saveRise',
			headers: {'Content-type': 'application/json'},
			data: {hike:args.hike,salary:args.salary},
			headers: {'Content-type': 'application/json'}
		});
		
		 response.success(function(response, status, headers, config){
			 
			 console.log('inside success');
			//$scope.recruiters = response.recruiters; 
			$scope.jobseeker_hike = response.jobseeker_hike;
			$scope.jobseeker_salary = response.jobseeker_salary;
			$scope.user.salary = response.jobseeker_salary;
			$scope.user.hike = response.jobseeker_hike;
			
			sharedProperties.setList(response.recruiters);
			
			//recruitersList = response.recruiters;
			//updateScope();
			
			console.log('data has been set');
		});
		
		response.error(function(data, status, headers, config) {
						console.log('inside errorCallback');
		});
		
		
		console.log('sendrise is over');
	};
	
	/*$scope.$watch(ammountOfFinishedOrders,function(newVal){
		 $scope.data = [
		      newVal, 4, 1, 3, 2, 1, 4
		    ];
		});*/
	
	  function updateScope() {
		
		console.log('inside  of updateScope');
		//console.log(sharedProperties.getList());
		
		$scope.recruiters = recruitersList;
		//$scope.recruiters = sharedProperties.getList();
	    
		console.log($scope.recruiters);
		
		console.log('outside of updateScope');
		//$scope.$apply();
		// your code here
	};
	
	//console.log($scope.recruiters);
	
}]);

angular.module('snaplync').controller('templatecontroller', ['$state','$rootScope','$scope','$location', '$http', '$filter', '$window', '$compile','sharedProperties',
                                                            function($state, $rootScope, $scope, $location, $http, $filter, $window, $compile,sharedProperties) {
	console.log('templatecontroller');
	
	$scope.recruiters = recruiters;
	
	if(sharedProperties.getList()){
	
		console.log('getList check pass');
		
	$scope.recruiters = sharedProperties.getList();
	
	}else{
		console.log('getList cfaoils');
		$scope.recruiters = recruiters;
	}

}]);

app.service('sharedProperties', function () {
	
	console.log('sharedProperties started');
    var list = [];
  
    console.log(list);
    
    return {
  
        getList: function() {
            return list;
        },
        setList: function(name) {
            list = name;
        }
       
    };
    
    
});
