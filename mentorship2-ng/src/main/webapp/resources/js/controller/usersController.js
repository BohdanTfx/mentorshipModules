app.controller('usersController', function($scope, $state, userService) {
	userService.getAllUsers().success(function(data, status, headers, config) {
		$scope.users = data.body;
	});

	$scope.goToUser = function(userId) {
		$state.go('user', {
			userId : userId
		});
	}

	$scope.deleteUser = function(user) {
		userService.deleteUser(user.id).success(
				function(data, status, headers, config) {
					var index = $scope.users.indexOf(user);
					$scope.users.splice(index, 1);
				});
	}
});