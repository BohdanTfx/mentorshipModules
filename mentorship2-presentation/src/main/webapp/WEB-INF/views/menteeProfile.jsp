<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentee</title>
</head>
<body>
	<h2>Mentee №${mentee.id}</h2>
	<blockquote>Mentor: ${mentee.mentor.user.firstName}
		${mentee.mentor.user.lastName} (${mentee.mentor.user.jobTitle})</blockquote>
	<div>
		First name: <b>${mentee.user.firstName}</b>
	</div>
	<div>
		Last name: <b>${mentee.user.lastName}</b>
	</div>
	<div>
		Job title: <b>${mentee.user.jobTitle}</b>
	</div>
	<div>
		Mentorship program: <b>${mentee.mentorshipProgram.title}</b>
	</div>
	<div>Active: ${mentee.active eq true ? 'Yes' : 'No'}</div>
	<c:if test="${mentee.started eq true}">
		<div>
			Start info: <b>${mentee.startedDate}</b>
		</div>
	</c:if>
	<c:if test="${mentee.finished eq true}">
		<div>
			Finish info: <b>${mentee.endDate}</b>
		</div>
	</c:if>
</body>
</html>