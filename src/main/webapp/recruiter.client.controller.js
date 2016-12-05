'use strict';

angular.module('snaplync').controller('RecruiterController', ['$state','$rootScope','$scope','$location', '$http', '$filter',  
                                                         function($state, $rootScope, $scope, $location, $http, $filter) {
	
	
	
	
	$scope.industrySelected = function(industry) {
		for(var i=0; i< $rootScope.recruiter.selectedIndustries.length; i++) {
			if(industry.id === $rootScope.recruiter.selectedIndustries[i].id) {
				return true;
			}
		}
		return false;
	}
	
	$scope.onIndustrySelection = function(industry) {
		var isPresent = $scope.industrySelected(industry);
		if (!isPresent) {
			$rootScope.recruiter.selectedIndustries.push(industry);
		} else {
			for(var i=0; i< $rootScope.recruiter.selectedIndustries.length; i++) {
				if(industry.id === $rootScope.recruiter.selectedIndustries[i].id) {
					$rootScope.recruiter.selectedIndustries.splice(i, 1);
				}
			}
		} 
	}
	
	$scope.goToStep2 = function(event) {
		$state.transitionTo('dashboard.recruiter.step2');
	}
	
	
	
	
	$scope.roleSelected = function(role) {
		for(var i=0; i< $rootScope.recruiter.selectedRoles.length; i++) {
			if(role.id === $rootScope.recruiter.selectedRoles[i].id) {
				return true;
			} 
		}
		return false;
	}
	
	$scope.onRoleSelection = function(role) {
		var isPresent = $scope.roleSelected(role);
		if (!isPresent) {
			$rootScope.recruiter.selectedRoles.push(role);
		} else {
			for(var i=0; i< $rootScope.recruiter.selectedRoles.length; i++) {
				if(role.id === $rootScope.recruiter.selectedRoles[i].id) {
					$rootScope.recruiter.selectedRoles.splice(i, 1);
				}
			}
		} 
	}
	
	$scope.goToStep3 = function() {
		$state.transitionTo('dashboard.recruiter.step3');
	}
	
	
	$scope.goToStep4 = function() {
		$state.transitionTo('dashboard.recruiter.step4');
	}
	$scope.goToComplete = function() {
		var recruiter = {};
		recruiter.userId = $rootScope.user.id;
		recruiter.industries = [];
		recruiter.roles = [];
		recruiter.skills = [];
		recruiter.states = [];
		recruiter.cities = [];
		for(var i=0; i< $rootScope.recruiter.selectedSkills.length; i++) {
			recruiter.skills.push($rootScope.recruiter.selectedSkills[i].id)
		}
		for(var i=0; i< $rootScope.recruiter.selectedIndustries.length; i++) {
			recruiter.industries.push($rootScope.recruiter.selectedIndustries[i].id)
		}
		for(var i=0; i< $rootScope.recruiter.selectedRoles.length; i++) {
			recruiter.roles.push($rootScope.recruiter.selectedRoles[i].id)
		}
		for(var i=0; i< $rootScope.recruiter.selectedCities.length; i++) {
			recruiter.cities.push($rootScope.recruiter.selectedCities[i].id)
		}
		for(var i=0; i< $rootScope.recruiter.selectedStates.length; i++) {
			recruiter.states.push($rootScope.recruiter.selectedStates[i].id)
		}
		recruiter.minCompensationYearly = $rootScope.recruiter.minCompensationYearly;
		recruiter.maxCompensationYearly = $rootScope.recruiter.maxCompensationYearly;
		
		recruiter.minCompensationMonthly = $rootScope.recruiter.minCompensationMonthly;
		recruiter.maxCompensationMonthly = $rootScope.recruiter.maxCompensationMonthly;
		
		recruiter.minCompensationHourly = $rootScope.recruiter.minCompensationHourly;
		recruiter.maxCompensationHourly = $rootScope.recruiter.maxCompensationHourly;
		
		$scope.submitting = true;
		$http.post('/recruiter', recruiter).then(function(response){
		    $rootScope.user = response.data;
		    $state.transitionTo('dashboard.recruiter.home');
		    $scope.submitting = false;
		}, function errorCallback(response) {
			$scope.submitting = false;
		});
		
	}
	$scope.fetchedSkills = [];
	$scope.fetchedStates = [];
	$scope.fetchedCities = []	
	
	$scope.searchSkills = function($select) {
		if(!$select.search || $select.search == '') {
			return;
		}
		$http.get('/skill/search?name='+$select.search).then(function(response){
			    $scope.fetchedSkills = response.data;
			  });
	}
	$scope.searchStates = function($select) {
		if(!$select.search || $select.search == '') {
			return;
		}
		$http.get('/state/search?name='+$select.search).then(function(response){
			    $scope.fetchedStates = response.data;
		});
	}
	$scope.searchCities= function($select) {
		if(!$select.search || $select.search == '') {
			return;
		}
		$http.get('/city/search?name='+$select.search).then(function(response){
			    $scope.fetchedCities = response.data;
		});
	}
	
	
	
}]);

angular.module('snaplync').controller('RecruiterStep4Controller', ['$state','$rootScope','$scope','$location', '$http', '$filter',  
                                                              function($state, $rootScope, $scope, $location, $http, $filter) {
	var minHourlySlider = $('#minHourly').slider({
			ticks: [10,50,90,130,170,210],
			ticks_labels: ['10 $/hr','50 $/hr','90 $/hr','130 $/hr','170 $/hr','210 $/hr'],
			ticks_snap_bounds: 10,
			value: $rootScope.recruiter.minCompensationHourly,
			tooltip: 'hide'
	});
	minHourlySlider.on('change', function(ev) {
		$rootScope.recruiter.minCompensationHourly = minHourlySlider.slider('getValue');
		$scope.$apply();
	});
	
	var maxHourlySlider = $('#maxHourly').slider({
			ticks: [10,50,90,130,170,210],
			ticks_labels: ['10 $/hr','50 $/hr','90 $/hr','130 $/hr','170 $/hr','210 $/hr'],
			ticks_snap_bounds: 10,
			value: $rootScope.recruiter.maxCompensationHourly,
			tooltip: 'hide'
	});
	maxHourlySlider.on('change', function(ev) {
		$rootScope.recruiter.maxCompensationHourly = maxHourlySlider.slider('getValue');
		$scope.$apply();
	});
	
	
	
	
	
	
	var minMonthlySlider = $('#minMonthly').slider({
			ticks: [3000,7000,10000,13000,16000,19000,22000],
			ticks_labels: ['3K','7K','10K','13K','16K','19K','22K'],
			ticks_snap_bounds: 10,
			value: $rootScope.recruiter.minCompensationMonthly,
			tooltip: 'hide'
	});
	minMonthlySlider.on('change', function(ev) {
		$rootScope.recruiter.minCompensationMonthly = minMonthlySlider.slider('getValue');
		$scope.$apply();
	});
	
	var maxMonthlySlider = $('#maxMonthly').slider({
			ticks: [3000,7000,10000,13000,16000,19000,22000],
			ticks_labels: ['3K','7K','10K','13K','16K','19K','22K'],
			ticks_snap_bounds: 10,
			value: $rootScope.recruiter.maxCompensationMonthly,
			tooltip: 'hide'
	});
	maxMonthlySlider.on('change', function(ev) {
		$rootScope.recruiter.maxCompensationMonthly = maxMonthlySlider.slider('getValue');
		$scope.$apply();
	});
	
	
	
	
	
	
	
	
	
	var minYearlySlider = $('#minYearly').slider({
			ticks: [30000,60000,90000,120000,150000,180000,210000,240000],
			ticks_labels: ['30K','60K','90K','120K','150K','180K','210K','240K'],
			ticks_snap_bounds: 10,
			value: $rootScope.recruiter.minCompensationYearly,
			tooltip: 'hide'
	});
	minYearlySlider.on('change', function(ev) {
		$rootScope.recruiter.minCompensationYearly = minYearlySlider.slider('getValue');
		$scope.$apply();
	});
	
	var maxYearlySlider = $('#maxYearly').slider({
			ticks: [30000,60000,90000,120000,150000,180000,210000,240000],
			ticks_labels: ['30K','60K','90K','120K','150K','180K','210K','240K'],
			ticks_snap_bounds: 10,
			value: $rootScope.recruiter.maxCompensationYearly,
			tooltip: 'hide'
	});
	maxYearlySlider.on('change', function(ev) {
		$rootScope.recruiter.maxCompensationYearly = maxYearlySlider.slider('getValue');
		$scope.$apply();
	});

	
}]);
