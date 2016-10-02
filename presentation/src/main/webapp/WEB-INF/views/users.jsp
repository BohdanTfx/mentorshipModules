<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
	<h1>List of users.</h1>
	<c:forEach items="${users}" var="user">
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
	</c:forEach>
</body>
</html>