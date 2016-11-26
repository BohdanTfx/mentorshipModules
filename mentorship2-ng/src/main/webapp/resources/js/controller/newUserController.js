app.controller('newUserController',
		function($scope, $log, $state, userService) {
			$scope.user = {};
			$scope.user.firstName = '';
			$scope.user.lastName = '';
			$scope.user.dateOfBirth = '';
			$scope.user.jobTitle = 'JUNIOR';

			$scope.createUser = function() {
				if (userService.isValidUser($scope.user)) {
					userService.createUser($scope.user).success(
							function(data, status, headers, config) {
								$state.go('users');
							});
				}
			}
		});