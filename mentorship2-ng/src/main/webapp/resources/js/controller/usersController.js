app.controller('usersController', function($scope, userService) {
	userService.getAllUsers().success(function(data, status, headers, config) {
		$scope.users = data.body;
	});
});