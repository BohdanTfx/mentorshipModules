app.service('commons', function() {
	var service = this;

	service.getServerUrl = function() {
		return "http://localhost:8081/";
	}
});