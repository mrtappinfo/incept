var appRoutes = (function () {
	console.info('index started............');
	var rp;

	function update()
	{
		
		var routes = [
		              {path: '/recruiterform', roles: [null], route: {templateUrl: 'screens/recruiterform.html', title: "recruiterform", pageType: 'loginPage'}},
		              {path: '/', roles: ['admin'], route: {templateUrl: 'screens/recruiterform.html', pageType: 'darkPage', doNotDisplayInHistory: true}},
		             ];

		var otherwises = {
				'unknown': {redirectTo: '/'}
		};


		// cleanup
		rp.clear();

		for (var i = 0; i < routes.length; i++) {
				rp.when(routes[i].path, routes[i].route);
			
		}

		
	}

	function init(routeProvider) {
		rp = routeProvider;
		update();
	}

	return {'init': init, 'update': update};
})();

function safeApply($scope, fn) {
	if (!$scope.$$phase) {
		$scope.$apply(fn);
	}
	else {
		if (fn && typeof (fn) == 'function') {
			fn();
		}
	}
}
;
//function showProgress() {
//	$("#loading").show();
//	$("#layer").show();
//}
//function hideProgress() {
//	$("#loading").hide();
//	$("#layer").hide();
//}
