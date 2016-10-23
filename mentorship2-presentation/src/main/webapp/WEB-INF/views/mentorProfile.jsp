<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentor</title>
</head>
<body>
	<h2>Mentor №${mentor.id}</h2>
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
	<h3>Mentees</h3>
	<c:forEach items="${mentor.mentees}" var="mentee">
		<h4>${mentee.id}</h4>
		<div>
			First name: <b>${mentee.user.firstName}</b>
		</div>
		<div>
			Last name: <b>${mentee.user.lastName}</b>
		</div>
		<div>
			Job title: <b>${mentee.user.jobTitle}</b>
		</div>
	</c:forEach>
</body>
</html>