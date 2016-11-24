app.service('userService', function($http, commons) {
	var service = this;

	service.getAllUsers = function() {
		return $http.get(commons.getServerUrl() + "api/users");
	}

	service.getUser = function(userId) {
		return $http.get(commons.getServerUrl() + "api/users/" + userId);
	}
});