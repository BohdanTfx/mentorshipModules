<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentors list</title>
</head>
<body>
	<h2>Mentors list</h2>
	<c:forEach items="${mentors}" var="mentor">
		<h3>Mentor №${mentor.id}</h3>
		<div>
			First name: <b>${mentor.user.firstName}</b>
		</div>
		<div>
			Last name: <b>${mentor.user.lastName}</b>
		</div>
		<div>
			Job title: <b>${mentor.user.jobTitle}</b>
		</div>
		<div>
			Mentorship program: <b>${mentor.mentorshipProgram.title}</b>
		</div>
	</c:forEach>
</body>
</html>