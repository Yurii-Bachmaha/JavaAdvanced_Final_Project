<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Create faculty</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<jsp:include page="header.jsp" />

<body style="background-color: #eee;">
    <div class="container d-flex justify-content-center" style="margin-top: 10%">
        <div class="card p-4">
            <div class="form-group">
                <form:form method="POST" modelAttribute="facultyForm">
                    <h2 class="mb-3">Create faculty</h2>
                    <spring:bind path="name">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="text" class="form-control" path="name" placeholder="Name faculty" autofocus="true"></form:input>
                            <form:errors path="name"></form:errors>
                        </div>
                    </spring:bind>
                    <spring:bind path="numberOfStudents">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input type="number" class="form-control" path="numberOfStudents" placeholder="Number of students" autofocus="true"></form:input>
                            <form:errors path="numberOfStudents"></form:errors>
                        </div>
                    </spring:bind>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>