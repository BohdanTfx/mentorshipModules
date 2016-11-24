app.controller('userController', function($scope, $routeParams, userService) {
	userService.getUser($routeParams.userId).success(
			function(data, status, headers, config) {
				$scope.user = data.body;
			});
});