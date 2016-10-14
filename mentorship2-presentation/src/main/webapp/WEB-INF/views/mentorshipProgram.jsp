<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentorship program</title>
</head>
<body>
	<h2>Mentorship program №${mentorshipProgram.id}</h2>
	<div>
		Title: <b>${mentorshipProgram.title}</b>
	</div>
	<div>
		Mentorship program head: <b>${mentorshipProgram.head.firstName}
			${mentorshipProgram.head.lastName}</b>
	</div>
	<div>
		Technology: <b>${mentorshipProgram.technology}</b>
	</div>
	<div>
		Location: <b>${mentorshipProgram.location}</b>
	</div>
	<c:if test="${mentorshipProgram.started eq true}">
		<div>
			Start info: <b>${mentorshipProgram.startDate}</b>
		</div>
	</c:if>
	<c:if test="${mentorshipProgram.finished eq true}">
		<div>
			Finish info: <b>${mentorshipProgram.endDate}</b>
		</div>
	</c:if>
	<ul>
		<c:forEach items="${mentorshipProgram.participants}" var="participant">
			<li>${participant.user.id}: <b>${participant.user.firstName}
					${participant.user.lastName}</b></li>
		</c:forEach>
	</ul>
</body>
</html>