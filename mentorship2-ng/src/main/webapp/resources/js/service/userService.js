app.service('userService', function($http, commons) {
	var service = this;

	service.getAllUsers = function() {
		return $http.get(commons.getServerUrl() + "api/users");
	}

	service.getUser = function(userId) {
		return $http.get(commons.getServerUrl() + "api/users/" + userId);
	}

	service.deleteUser = function(userId) {
		return $http({
			method : 'DELETE',
			url : commons.getServerUrl() + "api/users/" + userId
		});
	}

	service.updateUser = function(userId, user) {
		return $http({
			method : 'PUT',
			url : commons.getServerUrl() + "api/users/" + userId,
			data : user
		});
	}

	service.createUser = function(user) {
		return $http.post(commons.getServerUrl() + "api/users", user);
	}

	service.isValidUser = function(user) {
		function isValidField(field) {
			return !(field == undefined || field == null || field === '');
		}

		for ( var param in user) {
			if (user.hasOwnProperty(param))
				if (!isValidField(user[param])) {
					return false;
				}
		}
		return true;
	}
});