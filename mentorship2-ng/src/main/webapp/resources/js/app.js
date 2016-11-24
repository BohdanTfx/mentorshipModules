var app = angular.module('app', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/users', {
		templateUrl : 'resources/views/users.html',
		controller : 'userController'
	}).otherwise({
		redirectTo : '/'
	});
});