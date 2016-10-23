<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	<h1>Error ;(</h1>
	<div>${error.getClass().getSimpleName()}</div>
	<div>${error.message}</div>
</body>
</html>