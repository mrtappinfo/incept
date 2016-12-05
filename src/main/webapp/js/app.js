var app = angular.module('snaplync', ['ngResource', 'ngCookies',  'ngAnimate',  'ngTouch',  'ngSanitize','ui.router', 'ui.select','ui.utils', 'ui.bootstrap','ng.httpLoader' ]);
//'ui.utils', 'ui.select','ng.httpLoader'

angular.module('snaplync').config(['$locationProvider',function($locationProvider) {
	$locationProvider.hashPrefix('!');
	// $locationProvider.html5Mode(true);
}
]);
angular.module('snaplync').filter('trim', function() {
	return function(input, length) {
		if(length < 1) {
			length =1;
		}
		if(input!="undefined" && input!=null && input.length>length+3) {
			return input.substring(0,length) +"...";
		} else {
			return input;
		}
	};
});

angular.module('snaplync').run(function($rootScope) {

	$rootScope.user = user;
	$rootScope.session = session;
	$rootScope.industries = industries;
	$rootScope.roles = roles;
	$rootScope.skills = skills;


	$rootScope.jobseeker = {};
	if($rootScope.user.jobseeker) {
		$rootScope.jobseeker.selectedIndustries = $rootScope.user.jobseeker.industries;
		$rootScope.jobseeker.selectedRoles = $rootScope.user.jobseeker.roles;
		$rootScope.jobseeker.selectedSkills = $rootScope.user.jobseeker.skills;
		$rootScope.jobseeker.selectedState = $rootScope.user.jobseeker.state;
		$rootScope.jobseeker.selectedCity = $rootScope.user.jobseeker.city;
		$rootScope.jobseeker.experience = $rootScope.user.jobseeker.experience ? $rootScope.user.jobseeker.experience :6;
	} else {
		$rootScope.jobseeker={selectedIndustries:[],selectedRoles:[],selectedSkills:[],experience:6};
	}

	$rootScope.recruiter = {};
	if($rootScope.user.recruiter) {
		$rootScope.recruiter.selectedIndustries = $rootScope.user.recruiter.industries;
		$rootScope.recruiter.selectedRoles = $rootScope.user.recruiter.roles;
		$rootScope.recruiter.selectedSkills = $rootScope.user.recruiter.skills;
		$rootScope.recruiter.selectedStates = $rootScope.user.recruiter.states;
		$rootScope.recruiter.selectedCities = $rootScope.user.recruiter.cities;

		$rootScope.recruiter.maxCompensationYearly = $rootScope.user.recruiter.maxCompensationYearly;
		$rootScope.recruiter.minCompensationYearly = $rootScope.user.recruiter.minCompensationYearly;
		$rootScope.recruiter.maxCompensationMonthly = $rootScope.user.recruiter.maxCompensationMonthly;
		$rootScope.recruiter.minCompensationMonthly = $rootScope.user.recruiter.minCompensationMonthly;
		$rootScope.recruiter.maxCompensationHourly = $rootScope.user.recruiter.maxCompensationHourly;
		$rootScope.recruiter.minCompensationHourly = $rootScope.user.recruiter.minCompensationHourly;

		$rootScope.recruiter.maxCompensationYearly = $rootScope.user.recruiter.maxCompensationYearly ? $rootScope.user.recruiter.maxCompensationYearly :150000;
		$rootScope.recruiter.minCompensationYearly = $rootScope.user.recruiter.minCompensationYearly ? $rootScope.user.recruiter.minCompensationYearly :60000;

		$rootScope.recruiter.maxCompensationMonthly = $rootScope.user.recruiter.maxCompensationMonthly ? $rootScope.user.recruiter.maxCompensationMonthly :13000;
		$rootScope.recruiter.minCompensationMonthly = $rootScope.user.recruiter.minCompensationMonthly ? $rootScope.user.recruiter.minCompensationMonthly :7000;

		$rootScope.recruiter.maxCompensationHourly = $rootScope.user.recruiter.maxCompensationHourly ? $rootScope.user.recruiter.maxCompensationHourly :170;
		$rootScope.recruiter.minCompensationHourly = $rootScope.user.recruiter.minCompensationHourly ? $rootScope.user.recruiter.minCompensationHourly :50;

	} else {
		$rootScope.recruiter={selectedIndustries:[],selectedRoles:[],selectedSkills:[],selectedStates:[],selectedCities:[],maxCompensationYearly:150000,minCompensationYearly:60000,maxCompensationMonthly:13000,minCompensationMonthly:7000,maxCompensationHourly:170,minCompensationHourly:50};
	}

	$rootScope.$on('$stateChangeSuccess',function(){
		$("html, body").animate({ scrollTop: 0 }, 200);
	});

})

angular.module('snaplync').config(['httpMethodInterceptorProvider','$httpProvider', function (httpMethodInterceptorProvider, $httpProvider) {

	httpMethodInterceptorProvider.whitelistDomain('/');


}]);

angular.module('snaplync').config(['$stateProvider','$urlRouterProvider',
                                   function($stateProvider, $urlRouterProvider) {

	console.log("stateProvider initialized!");
	if(user.isRecruiter) {
		if(user.recruiter == null) {
			$urlRouterProvider.otherwise('/dashboard/recruiter/step1');
		} else {
			$urlRouterProvider.otherwise('/dashboard/recruiter/home');
		}
	} else {                               		

		if(user.jobseeker == null) {
			$urlRouterProvider.otherwise('/dashboard/jobseeker/step1');
		} else {
			$urlRouterProvider.otherwise('/dashboard/jobseeker/home');
		}
	}

	$stateProvider.
	state('dashboard', {
		url: '/dashboard',
		templateUrl: '/views/dashboard.client.view.html'
	}).
	state('dashboard.jobseeker', {
		url: '/jobseeker',
		templateUrl: '/views/jobseeker.client.view.html'
	}).
	state('dashboard.jobseeker.step1', {
		url: '/step1',
		templateUrl: '/views/jobseeker/jobseeker1.client.view.html'
	}).
	state('dashboard.jobseeker.step2', {
		url: '/step2',
		templateUrl: '/views/jobseeker/jobseeker2.client.view.html'
	}).
	state('dashboard.jobseeker.step3', {
		url: '/step3',
		templateUrl: '/views/jobseeker/jobseeker3.client.view.html'
	}).
	state('dashboard.jobseeker.step4', {
		url: '/step4',
		templateUrl: '/views/jobseeker/jobseeker4.client.view.html'
	}).
	state('dashboard.jobseeker.step5', {
		url: '/step5',
		templateUrl: '/views/jobseeker/jobseeker5.client.view.html'
	}).
	state('dashboard.jobseeker.home', {
		url: '/home',
		templateUrl: '/views/jobseeker/jobseekerhome.client.view.html'
	}).
	state('dashboard.jobseeker.search', {
		url: '/search',
		templateUrl: '/views/jobseeker/jobseekerSearchRecruiter.client.view.html'
	}).

	state('dashboard.recruiter', {
		url: '/recruiter',
		templateUrl: '/views/recruiter.client.view.html'
	}).
	state('dashboard.recruiter.step1', {
		url: '/step1',
		templateUrl: '/views/recruiter/recruiter1.client.view.html'
	}).
	state('dashboard.recruiter.step2', {
		url: '/step2',
		templateUrl: '/views/recruiter/recruiter2.client.view.html'
	}).
	state('dashboard.recruiter.step3', {
		url: '/step3',
		templateUrl: '/views/recruiter/recruiter3.client.view.html'
	}).
	state('dashboard.recruiter.step4', {
		url: '/step4',
		templateUrl: '/views/recruiter/recruiter4.client.view.html'
	}).
	state('dashboard.recruiter.home', {
		url: '/home',
		templateUrl: '/views/recruiter/recruiterhome.client.view.html'
	})


}]);

angular.module("snaplync").controller("mainController", function($scope) {
	console.log("mainController initialized!");
});
