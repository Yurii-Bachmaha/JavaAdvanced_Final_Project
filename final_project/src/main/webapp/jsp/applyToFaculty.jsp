<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Apply to faculty</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body style="background-color: #eee;">
    <jsp:include page="header.jsp" />

    <div>
        <div class="w3-container d-flex flex-wrap">
            <c:if test="${not empty faculties}">
                <c:forEach items="${faculties}" var="currentFaculties">
                    <div class="card" style="width: 28%; margin: 2%;">
                    
                        <div class="w3-container w3-center d-flex flex-column justify-content-between"
                            style="height: 150px">
                            <h3>Name faculty: ${currentFaculties.name}</h3>
                            <p>Number of seats: ${currentFaculties.numberOfStudents}</p>
                            <p>Minimum passing score: ${currentFaculties.minimumPassingScore}</p>
                        </div>

                        <form:form action="${contextPath}/applyToFaculty" method="POST" enctype="multipart/form-data">                       
                            <input type="hidden" value="${currentFaculties.id}" name="facultyId">        
                            <c:choose>
                            	<c:when test="${subjectsViewer <= currentFaculties.minimumPassingScore}">                          		
    								<input type="submit" class="btn btn-danger" style="width: 100%" disabled="disabled" value="Your overall score is not enough!">							
                            	</c:when>
                            	<c:when test="${subjectsViewer > currentFaculties.minimumPassingScore}">
                            		<input id = "applyToFaculty" type="submit" class="btn btn-primary" style="width: 100%" value="+ apply to faculty">
                            	</c:when>                           	
                            </c:choose>                                                  	                        	                       	                                                    
                        </form:form>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>