'use strict';

angular.module('snaplync').controller('RecruiterController', ['$state','$rootScope','$scope','$location', '$http', '$filter',  
                                                         function($state, $rootScope, $scope, $location, $http, $filter) {
	
	$rootScope.user = {
			email : ""
	};

	$rootScope.goBack = function () {
		$window.history.back();
	}

	$rootScope.signUp = function () {
		
		alert($rootScope.user);
		var email = $rootScope.user;

		$http({
		    method: 'POST',
		    url: '/save',
		    data: {email:email},
		    }).then(function(response){
				//$rootScope.user = response.data;
			   // $state.transitionTo('/index');
			    $scope.submitting = false;
			}, function errorCallback(response) {
				$scope.submitting = false;
			});
	}

}]);
