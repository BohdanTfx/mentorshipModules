<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logs</title>
</head>
<body>
	<h2>Logs</h2>
	<c:forEach items="${logs}" var="log">
		<div>
			<h3>${log.title}</h3>
			<div>
				Logged date:<b>${log.logDate}</b>, with action type of <i>"${log.type}"</i>
			</div>
			<b>Data</b>
			<div>${log.description}</div>
		</div>
	</c:forEach>
</body>
</html>