<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hi!</title>
</head>
<body>
	<h2>Login!</h2>
	<form
		action="http://localhost:8080/auth/login"
		method="post">
		<div>
			<label for="username">Username:</label> <input name="username"
				type="text" id="username" />
		</div>
		<div>
			<label for="password">Password:</label> <input name="password"
				type="password" id="password" />
		</div>
		<button type="submit">Submit!</button>
	</form>
</body>
</html>