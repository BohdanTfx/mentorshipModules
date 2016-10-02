<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	<h2>User №${user.id}</h2>
	<div>
		First name: <b>${user.firstName}</b>
	</div>
	<div>
		Last name: <b>${user.lastName}</b>
	</div>
	<div>
		Job title: <b>${user.jobTitle}</b>
	</div>
</body>
</html>