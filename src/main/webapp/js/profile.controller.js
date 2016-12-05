'use strict';
var app = angular.module('snaplync', ['ngResource', 'ngCookies',  'ngAnimate',  'ngTouch',  'ngSanitize','ui.router', 'ui.select','ui.utils', 'ui.bootstrap','ng.httpLoader' ]);

angular.module('snaplync').controller('profileController', ['$state','$rootScope','$scope','$location', '$http', '$filter', '$window', '$compile','sharedProperties','Recruiters','loadlist',
                                                            function($state, $rootScope, $scope, $location, $http, $filter, $window, $compile,sharedProperties,Recruiters,loadlist) {

	console.log('inside profileController');
	
	//var vm = this;

	//var recruitersList = [];

	//$scope.recruiters = [];
	
	  $scope.loading = false;

	$scope.user = {
			salary: "" ,
			hike: ""
	}

	$scope.recruiters = recruiters;
	$scope.jobseeker_hike = jobseeker_hike;
	
	var actualSalary = (jobseeker_salary * 1000);
	
	$scope.jobseeker_salary = actualSalary;
	$scope.maxSalaryPossible=maxSalaryPossible;
	$scope.averageRaise=averageRaise;
	$scope.user.salary = jobseeker_salary;
	$scope.user.hike = jobseeker_hike;
	$scope.jobseeker = jobseeker;

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



	$scope.$on("updateItems",function(event, data){
		
		$scope.loading = false;
		$scope.recruiters = JSON.parse(data.recruiters);
		$scope.jobseeker_hike = data.jobseeker_hike;
		
		var actualSalary = (data.jobseeker_salary * 1000);
		
		$scope.jobseeker_salary = actualSalary;
		$scope.maxSalaryPossible=data.maxSalaryPossible;
		$scope.jobseeker = data.jobseeker;
		$scope.averageRaise=data.averageRaise;
		console.log($scope.recruiters);
		console.log($scope.loading);
		//$scope.$apply();
	});



	$scope.sendrise = function(){

		$scope.loading = true;
		
		console.log('sendrise started');
		
		var args =  $scope.user; 
		
		loadlist.loadItems(args,$scope);
		
		console.log('sendrise ended');
		
	}

//	$scope.sendrise = function(recruiters){
//
//		//$scope.recruiters = [];
//		
//		var args =  $scope.user; 
//		
//		console.log('inside sendrise');
//		//console.log($scope.recruiters);
//		
//		var response = $http({
//			method: 'POST',
//			url: '/saveRise',
//			headers: {'Content-type': 'application/json'},
//			data: {hike:args.hike,salary:args.salary},
//			headers: {'Content-type': 'application/json'}
//		});
//		
//		 response.success(function(response, status, headers, config){
//			 
//			 var mockDataForThisTest = "json=" + encodeURI(JSON.stringify([
//                                                                           {
//                                                                         	  "recruiterID" : 18,
//                                                                         	  "recruiterName" : "name",
//                                                                         	  "recruiterCompanyName" : "sdfsdf"}, 
//                                                                         	{
//                                                                         	  "recruiterID" : 19,
//                                                                         	  "recruiterName" : "sfdf",
//                                                                         	  "recruiterCompanyName" : "sfsf"} 
//                                                                         	]));
//			 
//			 console.log('inside success');
//			$scope.recruiters = mockDataForThisTest;
//			$scope.jobseeker_hike = response.jobseeker_hike;
//			$scope.jobseeker_salary = response.jobseeker_salary;
//			$scope.user.salary = response.jobseeker_salary;
//			$scope.user.hike = response.jobseeker_hike;
//			console.log($scope.recruiters);
//			//sharedProperties.setList(response.recruiters);
//			
//			//recruitersList = response.recruiters;
//			//updateScope();
//			
//			console.log('data has been set');
//		});
//		
//		response.error(function(data, status, headers, config) {
//						console.log('inside errorCallback');
//		});
//	};

//	$scope.sendrise = function(){
//	var args =  $scope.user; 

//	console.log('sendrise is started');
//	Recruiters.getList(args).
//	success(function (response) {
//	//console.log(response);
//	$scope.recruiters = response.recruiters;
//	})
//	.error(function (error) {
//	console.log('unable load data');
//	});

//	console.log('sendrise is over');
//	};



	//console.log($scope.recruiters);

}]);



app.service('sharedProperties', function () {

	//console.log('sharedProperties started');
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

app.service('loadlist', ['$http', '$rootScope',  function ($http,$rootScope) {

	this.loadItems = function (args, $scope) {

		//console.log('loadlist started');
		
		$http({
			url: '/saveRise',
			data: args,
			method: "POST"
		})
		.success(function (data, status, headers, config) {
			//$scope.recruiters = data.recruiters;
			
			//console.log(data.recruiters);
			$rootScope.$broadcast('updateItems', data);
		})
		.error(function (data, status, headers, config) {
			$rootScope.status = status;
		});

		//console.log('loadlist ended');
	}; 

}]);


app.directive('loading', function () {
    return {
        restrict: 'E',
        replace:true,
        template: '<p><img src="images/preloader.png"/></p>', // Define a template where the image will be initially loaded while waiting for the ajax request to complete
        link: function (scope, element, attr) {
            scope.$watch('loading', function (val) {
                val = val ? $(element).show() : $(element).hide();  // Show or Hide the loading image   
            }); 
        }
    }
});


app.factory('Recruiters', ['$http',  function ($http) { 

	//console.log('factory is started');

	var Recruiters = {};

	Recruiters.getList = function(args) {
		return $http({
			method: 'POST',
			url: '/saveRise',
			data: args,
			headers: {'Content-type': 'application/json'}
		});
	};

	return Recruiters;
}]);
