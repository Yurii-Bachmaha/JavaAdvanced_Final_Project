<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title><spring:message code="403.title"></spring:message></title>
</head>

<body>
    <div class="container mt-5 d-flex flex-column align-items-center">
        <div class="alert alert-danger mt-5"><spring:message code="403.message"></spring:message></div>
        <form action="/logout" method="post">
            <input type="submit" class="btn btn-primary btn-block" value="<spring:message code="403.btn"></spring:message>" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</body>

</html>