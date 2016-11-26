app.controller('userController', function($scope, $stateParams, $log, commons,
		userService) {
	$scope.edit = {}
	$scope.edit.mode = false;

	$scope.switchEditMode = function() {
		$scope.edit.mode = !$scope.edit.mode;
	}

	$scope.updateUser = function() {
		if (userService.isValidUser($scope.userClone)) {
			userService.updateUser($stateParams.userId, $scope.userClone)
					.success(function(data, status, headers, config) {
						$scope.user = commons.createClone($scope.userClone);
						$scope.switchEditMode();
					});
		}
	}

	userService.getUser($stateParams.userId).success(
			function(data, status, headers, config) {
				$scope.user = data.body;
				$scope.userClone = commons.createClone($scope.user);
				$scope.userClone.dateOfBirth = new Date(
						$scope.userClone.dateOfBirth);
			});
});