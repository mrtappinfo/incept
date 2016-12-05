var mainAppModule = angular.module('mainApp', ['ngRoute']).config(['$routeProvider', function ($routeProvider) {

	appRoutes.init($routeProvider);
}]);

angular.module('modules', []);

console.info('recruiterform started............');

mainAppModule.controller("recruiterPageCtrl", ["$route","$scope", "$window", "$location", "$timeout",   function ($route,$scope, $window,$location, $timeout) {

	$scope.user = {
			recruiterID: "",
			recruiterName: "",
			recruiterCompanyID: "",
			recruiterEmail : "",
			recruiterCompanyID: "",
			recruiterCompanyName: "",
			recruiterQuality: "",
			recruiterPhoneNo: "",
			recruiterCity: "",
			recruiterState: "",
			recruiterClient1:"",
			recruiterClient2:"",
			recruiterClient3:"",
			recruiterClient4:"",
			recruiterClient5:"",
			isAcceptingEmail:"",
			isAcceptingPhone:"",
			recruiterLinkedInURL:"",
			recruiterCompanyURL:"",
			isVendorRecruiter:"",
			isVendorRecruiter:"",
			isActive:"",
			isVerified:"",
			recruiterRateMin:"",
			recruiterRateMax:"",
			recruiterIndustry1:"",
			recruiterIndustry2:"",
			recruiterIndustry3:"",
			recruiterIndustry4:"",
			recruiterSkill1:"",
			recruiterSkill2:"",
			recruiterSkill3:"",
			recruiterSkill4:"",
			recruiterSkill5:"",
			recruiterSkill6:"",
			recruiterSkill7:"",
			recruiterSkill8:"",
			recruiterSkill9:"",
			recruiterSkill10:"",
			recruiterRole1:"",
			recruiterRole2:"",
			recruiterRole3:"",
			recruiterRole4:"",
			recruiterRole5:"",
			recruiterOneYearSkill:"",
			recruiterTwoYearSkill:"",
			recruiterThreeYearSkill:"",
			recruiterFourYearSkill:"",
			recruiterFiveYearSkill:"",
			recruiterSixYearSkill:"",
			recruiterSevenYearSkill:"",
			recruiterEightYearSkill:"",
			recruiterNineYearSkill:"",
			recruiterTenYearSkill:"",
			recruiterPostingDate:"",
			recruiterExpirationDate:""

	};

	$scope.goBack = function () {

		$window.history.back();
	}

	$scope.saveUser = function () {

		var _args = $scope.user;

		api.execute('createRecruiterProfile', _args, function (result) {

			if (result.typ == "error") {

				alert(result.txt);
			}
			else {

				alert(result.txt);
				$window.location.reload();
			}
		}, function (err) {
			var data = {};
			data.typ = "error";
			data.txt = err.message || "Application failed to process the request, please contact support";
			alert(data.txt);

		});
	}

}]);
