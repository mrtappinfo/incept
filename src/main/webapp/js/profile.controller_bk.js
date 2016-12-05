'use strict';
var app = angular.module('snaplync', ['ngResource', 'ngCookies',  'ngAnimate',  'ngTouch',  'ngSanitize','ui.router', 'ui.select','ui.utils', 'ui.bootstrap','ng.httpLoader' ]);

angular.module('snaplync').controller('profileController', ['$state','$rootScope','$scope','$location', '$http', '$filter', '$window', '$compile','dataService',
                                                            function($state, $rootScope, $scope, $location, $http, $filter, $window, $compile,dataService) {

	console.log('inside profileController');
	
	var recruitersList = [];
	
	$scope.user = {
			salary: "" ,
			hike: ""
	}

	$scope.recruiters = recruiters;
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
		
		dataService.post({
		      url: '/saveRise',
		      data: args  
		    }).then(function(response) {
		    	
		    	$scope.recruiters = response.data.recruiters;
		    	$scope.jobseeker_hike = response.data.jobseeker_hike;
				$scope.jobseeker_salary = response.data.jobseeker_salary;
				$scope.user.salary = response.data.jobseeker_salary;
				$scope.user.hike = response.data.jobseeker_hike;

		    }, function() {console.log('inside errorCallback');});
		 		
		
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
//			angular.extend($scope.recruiters, response.recruiters);
//			
//			recruitersList = response.recruiters;
//			$scope.jobseeker_hike = response.jobseeker_hike;
//			$scope.jobseeker_salary = response.jobseeker_salary;
//			$scope.user.salary = response.jobseeker_salary;
//			$scope.user.hike = response.jobseeker_hike;
//
//			//self.setRecruiters(response.recruiters); 
//			console.log(recruitersList);
//			//console.log($scope.recruiters);
//			console.log($scope.jobseeker_hike);
//			console.log($scope.jobseeker_salary);
////			
////			return {
////		    	recruiterList: function () {
////		    		 return: response.recruiters;
////		           // return context + "/recruiter/rest/";
////		        }
////		    };
//		    
//		    //$scope.$parent.recruiters = response.recruiters;
//		});
//		
//		response.error(function(data, status, headers, config) {
//						console.log('inside errorCallback');
//		});
		
		
		//$scope.$apply();
	};
	
	
	app.service('dataService', function dataservice($http) {
		  return {
			    get: get,
			    post: post
			  };

			  function get(req) {
			    var req = {
			      method: 'GET',
			      url: req.url,
			      params: req.params
			    };

			    return $http(req)
			      .then(fetchCompleteSuccess)
			      .catch(fetchCompleteFailed);

			    function fetchCompleteSuccess(response) {
			      return response.data;
			    }

			    function fetchCompleteFailed(error) {
			      return error;
			    }
			  }

			  function post(req) {
			    var req = {
			      method: 'POST',
			      url: req.url,
			      data: req.data
			    };

			    return $http(req)
			      .then(submitCompleteSuccess)
			      .catch(submitCompleteFailed);

			    function submitCompleteSuccess(response) {
			      return response.data;
			    }

			    function submitCompleteFailed(error) {
			      logger.error('XHR Failed for getAvengers.' + error.data);
			    }
			  }
	});
	
	//$scope.recruiters = recruitersList;
	//console.log($scope.recruiters);
	/*$scope.sendrise = function () {

		var _args = $scope.user;

		console.log('inside sendrise');
		api.execute('saveRise', _args, function (response) {
			console.info(response);
			recruitersList = response.recruiters;
			$scope.jobseeker_hike = response.jobseeker_hike;
			$scope.jobseeker_salary = response.jobseeker_salary;
			$scope.user.salary = response.jobseeker_salary;
			$scope.user.hike = response.jobseeker_hike;
			
		}, function (err) {
			var data = {};
			data.typ = "error";
			data.txt = err.message || "Application failed to process the request, please contact support";
			alert(data.txt);

		});
		
		$scope.recruiters = recruitersList;
	}*/
	
	//$scope.recruiters = recruitersList;
//	app.directive('recelements', function($compile) {
//		
//		console.log('inside recelements directive');
//		
//		  return {
//		
//			  scope: {
//		      demoDisplay: "=", //import referenced model to our directives scope
//		      demoDays: "="
//		    },
//		    templateUrl: 'template.html',
//		    link: function(scope, elem, attr, ctrl) {
//		    	
//		    	scope.$apply(function() {
//		    		console.log('inside link');
//                    var content = $compile(templateUrl)(scope);
//                    element.append(content);
//               })
//               
//		      /*
//		      scope.$watch('demoDisplay', function() { // watch for when model changes
//
//		        elem.html("") //remove all elements
//
//		        angular.forEach(scope.demoDisplay, function(d) { //iterate list
//		          var s = scope.$new(); //create a new scope
//		          angular.extend(s, d); //copy data onto it
//		          console.log(scope.demoDays);
//
//		          var template = '';
//		          elem.append($compile(template)(s)); // compile template & append
//		        });
//		      }, true) //look deep into object
//		      */
//		    }
//		  }
//		})
}]);
