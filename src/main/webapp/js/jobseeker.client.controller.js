'use strict';

angular.module('snaplync').controller('JobSeekerController', ['$state','$rootScope','$scope','$location', '$http', '$filter',  
                                                         function($state, $rootScope, $scope, $location, $http, $filter) {
	
	
	
	
	$scope.industrySelected = function(industry) {
		for(var i=0; i< $rootScope.jobseeker.selectedIndustries.length; i++) {
			if(industry.id === $rootScope.jobseeker.selectedIndustries[i].id) {
				return true;
			}
		}
		return false;
	}
	
	$scope.onIndustrySelection = function(industry) {
		var isPresent = $scope.industrySelected(industry);
		if (!isPresent) {
			$rootScope.jobseeker.selectedIndustries.push(industry);
		} else {
			for(var i=0; i< $rootScope.jobseeker.selectedIndustries.length; i++) {
				if(industry.id === $rootScope.jobseeker.selectedIndustries[i].id) {
					$rootScope.jobseeker.selectedIndustries.splice(i, 1);
				}
			}
		} 
	}
	
	$scope.nextGoToRoles = function(event) {
		$state.transitionTo('dashboard.jobseeker.step2');
	}
	
	
	
	
	$scope.roleSelected = function(role) {
		for(var i=0; i< $rootScope.jobseeker.selectedRoles.length; i++) {
			if(role.id === $rootScope.jobseeker.selectedRoles[i].id) {
				return true;
			} 
		}
		return false;
	}
	
	$scope.onRoleSelection = function(role) {
		var isPresent = $scope.roleSelected(role);
		if (!isPresent) {
			$rootScope.jobseeker.selectedRoles.push(role);
		} else {
			for(var i=0; i< $rootScope.jobseeker.selectedRoles.length; i++) {
				if(role.id === $rootScope.jobseeker.selectedRoles[i].id) {
					$rootScope.jobseeker.selectedRoles.splice(i, 1);
				}
			}
		} 
	}
	
	$scope.goToskillsNext = function() {
		$state.transitionTo('dashboard.jobseeker.step3');
	}
	
	$scope.skillSelected = function(skill) {
		for(var i=0; i< $rootScope.jobseeker.selectedSkills.length; i++) {
			if(skill.id === $rootScope.jobseeker.selectedSkills[i].id) {
				return true;
			} 
		}
		return false;
	}
	
	$scope.onSkillSelection = function(skill) {
		var isPresent = $scope.skillSelected(skill);
		if (!isPresent) {
			$rootScope.jobseeker.selectedSkills.push(skill);
		} else {
			for(var i=0; i< $rootScope.jobseeker.selectedSkills.length; i++) {
				if(skill.id === $rootScope.jobseeker.selectedSkills[i].id) {
					$rootScope.jobseeker.selectedSkills.splice(i, 1);
				}
			}
		} 
	}
	
	$scope.goToStep4 = function() {
		$state.transitionTo('dashboard.jobseeker.step4');
	}
	
	$scope.goToStep5 = function() {
		$state.transitionTo('dashboard.jobseeker.step5');
	}
	
	$scope.goToComplete = function() {
		//console.log($rootScope.jobseeker.selectedState);
		var seeker = {experience: $rootScope.jobseeker.experience};
		seeker.userId = $rootScope.user.id;
		seeker.industries = [];
		seeker.roles = [];
		seeker.skills = [];
		seeker.city = [];
		seeker.state = [];
		
		for(var i=0; i< $rootScope.jobseeker.selectedState.length; i++) {
			seeker.state.push($rootScope.jobseeker.selectedState[i].id)
		}
		for(var i=0; i< $rootScope.jobseeker.selectedCity.length; i++) {
			seeker.city.push($rootScope.jobseeker.selectedCity[i].id)
		}
		for(var i=0; i< $rootScope.jobseeker.selectedSkills.length; i++) {
			seeker.skills.push($rootScope.jobseeker.selectedSkills[i].id)
		}
		for(var i=0; i< $rootScope.jobseeker.selectedIndustries.length; i++) {
			seeker.industries.push($rootScope.jobseeker.selectedIndustries[i].id)
		}
		for(var i=0; i< $rootScope.jobseeker.selectedRoles.length; i++) {
			seeker.roles.push($rootScope.jobseeker.selectedRoles[i].id)
		}
		//console.log(seeker);
		
		$scope.submitting = true;
		

		$http({
		    method: 'POST',
		    url: '/jobseeker',
		    data: seeker,
		    headers: {'Content-type': 'application/json'}
		    }).then(function(response){
				$rootScope.user = response.data;
			    $state.transitionTo('dashboard.jobseeker.home');
			    $scope.submitting = false;
			}, function errorCallback(response) {
				$scope.submitting = false;
			});
		
//		$http.post('/jobseeker', seeker).then(function(response){
//		    $rootScope.user = response.data;
//		    $state.transitionTo('dashboard.jobseeker.home');
//		    $scope.submitting = false;
//		}, function errorCallback(response) {
//			$scope.submitting = false;
//		    // called asynchronously if an error occurs
//		    // or server returns response with an error status.
//		  });
		
	}
	$scope.searchSkills = function($select) {
		if(!$select.search || $select.search == '') {
			return;
		}
		$http.get('/skill/search?name='+$select.search).then(function(response){
			    $scope.fetchedSkills = response.data;
			  });
	}
	$scope.fetchedStates = [];
	$scope.searchStates = function($select) {
		if(!$select.search || $select.search == '') {
			return;
		}
		//console.log($select);
		$http.get('/state/search?name='+$select.search).then(function(response){
			
				for(var i=0; i<$select.selected.length; i++) {
					for(var j=0; j<response.data.length; j++) {
						if($select.selected[i].name == response.data[j].name){
							response.data.splice(j, 1);
							break;
						}
					}
				}
			    
			$scope.fetchedStates = response.data;
		});
	}
	$scope.fetchedCities = [];
	$scope.searchCities = function($select) {
		if(!$select.search || $select.search == '') {
			return;
		}
		console.log($select);
		$http.get('/city/search?name='+$select.search).then(function(response){
			//console.log($select.selected);
			//console.log(response.data);
			
				for(var i=0; i<$select.selected.length; i++) {
					for(var j=0; j<response.data.length; j++) {
						if($select.selected[i].name == response.data[j].name){
							response.data.splice(j, 1);
							break;
						}
					}
				}
			    
			$scope.fetchedCities = response.data;
		});
	}
	/*$scope.$watch("jobseeker.selectedState",
            function handleFooChange( newValue, oldValue ) {
				if(newValue && newValue.cities.length > 0) {
					var changeCity = true;
					for(var i=0; i < newValue.cities.length; i++) {
						if($scope.jobseeker.selectedCity && $scope.jobseeker.selectedCity.id == newValue.cities[i].id) {
							changeCity = false;
						}
					}
					if($scope.jobseeker.selectedCity ==null || changeCity) { 
						$scope.jobseeker.selectedCity = newValue.cities[0];
					}
            	}
    });*/
	
	
}]);

angular.module('snaplync').controller('JobSeekerStep4Controller', ['$state','$rootScope','$scope','$location', '$http', '$filter',  
                                                              function($state, $rootScope, $scope, $location, $http, $filter) {
		
	console.log($rootScope.jobseeker.experience);	
	var expslide = $('#jobexp').slider({
			ticks: [0,2, 4, 6, 8,10, 12, 14, 16, 18, 20],
			ticks_labels: ['0 yrs', '2 yrs', '4 yrs', '6 yrs', '8 yrs', '10 yrs', '12 yrs', '14 yrs', '16 yrs', '18 yrs', '20 yrs'],
			ticks_snap_bounds: 10,
			value: $rootScope.jobseeker.experience,
			tooltip: 'hide'
		});
		expslide.on('change', function(ev) {
		
			$rootScope.jobseeker.experience = expslide.slider('getValue');
			$scope.$apply();
		});

	
}]);

angular.module('snaplync').controller('JobSeekerSearchController', ['$state','$rootScope','$scope','$location', '$http', '$filter',  
                                                                   function($state, $rootScope, $scope, $location, $http, $filter) {
     		
     		
     	var expslide = $('#compensation').slider({
     			ticks: [200,300, 400, 500, 600,700, 800, 900, 1000, 1100, 1200],
     			ticks_labels: ['200', '300', '400', '500', '600', '700', '800', '900', '1000', '1100', '1200'],
     			ticks_snap_bounds: 10,
     			value: $rootScope.jobseeker.compensation,
     			tooltip: 'hide'
     		});
     		expslide.on('change', function(ev) {
     		
     			$rootScope.jobseeker.compensation = expslide.slider('getValue');
     			$scope.$apply();
     		});

     	
     }]);
