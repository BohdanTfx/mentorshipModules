app.controller('userController', function($scope, userService) {
	$scope.users = {};

	userService.getAllUsers().success(function(data, status, headers, config) {
		$scope.users = data.body;
	});
});