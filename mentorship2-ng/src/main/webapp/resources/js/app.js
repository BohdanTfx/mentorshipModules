var app = angular.module('app', [ 'ui.router', 'ngResource' ]);

app.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/users');

	$stateProvider.state('users', {
		url : '/users',
		templateUrl : 'resources/views/users.html',
		controller : 'usersController'
	}).state('user', {
		url : '/user/:userId',
		templateUrl : 'resources/views/user.html',
		controller : 'userController'
	}).state('newUser', {
		url : '/users/create',
		templateUrl : 'resources/views/newUser.html',
		controller : 'newUserController'
	});
});