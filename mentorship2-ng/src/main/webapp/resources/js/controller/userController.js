app.controller('userController', function($scope, $stateParams, userService) {
	userService.getUser($stateParams.userId).success(
			function(data, status, headers, config) {
				$scope.user = data.body;
			});
});