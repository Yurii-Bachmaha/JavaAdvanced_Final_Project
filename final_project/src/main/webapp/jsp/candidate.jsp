<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title><spring:message code="candidate.page_title"></spring:message></title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="css/candidate.css" rel="stylesheet" type="text/css">
</head>

<body style="background-color: #eee;">
<jsp:include page="header.jsp" />
	<div class="container">
	</div>
		<c:choose>
		<c:when test="${mode == 'VIEW_CANDIDATE'}">
			<div style="margin: auto; margin-top: 5%;width: 75%">
				<table class="table">
					<thead class="bg-primary">
						<tr>
							<th>Id</th>
							<th><spring:message code="candidate.first_name"></spring:message></th>
							<th><spring:message code="candidate.last_name"></spring:message></th>
							<th><spring:message code="candidate.view_btn"></spring:message></th>
							<th><spring:message code="candidate.delete_btn"></spring:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="candidate" items="${candidates}">				
							<tr>
								<td>${candidate.id}</td>
								<td>${candidate.firstName}</td>
								<td>${candidate.lastName}</td>								
								<td><a class = "btn btn-info btn-sm" href="viewProfileCandidates?userId=${candidate.id}"><spring:message code="candidate.view_href"></spring:message></a></td>							
								<td><a class = "btn btn-info btn-sm delete-candidate" href = "deleteCandidate?userId=${candidate.id}"><spring:message code="candidate.delete_href"></spring:message></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:when test="${mode == 'VIEW_FACULTY'}">
			<div style="margin: auto; margin-top: 5%;width: 75%">
				<table class="table">
					<thead class="bg-primary">
						<tr>
							<th>Id</th>
							<th><spring:message code="candidate.faculty_name"></spring:message></th>
							<th><spring:message code="candidate.number_of_seats"></spring:message></th>
							<th><spring:message code="candidate.minimum_pass_score"></spring:message></th>
							<th><spring:message code="candidate.view_candidate"></spring:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="faculty" items="${faculties}">
							<tr>
								<td>${faculty.id}</td>
								<td>${faculty.name}</td>
								<td>${faculty.numberOfStudents}</td>
								<td>${faculty.minimumPassingScore}</td>
								<td><a href = "candidates?facultyId=${faculty.id}"><spring:message code="candidate.view_candidate"></spring:message></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
	</c:choose>
	<script src="js/main.js"></script>
</body>

</html>