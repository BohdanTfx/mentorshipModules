app.service('commons', function() {
	var service = this;

	service.getServerUrl = function() {
		return "http://localhost:8081/";
	}

	service.createClone = function(obj) {
		var clone = {};
		for ( var param in obj) {
			if (obj.hasOwnProperty(param)) {
				clone[param] = obj[param];
			}
		}
		return clone;
	}
});