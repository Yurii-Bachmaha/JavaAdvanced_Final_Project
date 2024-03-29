<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title><spring:message code="certificate.title"></spring:message></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="css/addCertificate.css" rel="stylesheet" type="text/css">
</head>

<body style="background-color: #eee;">
    <jsp:include page="header.jsp" />
    <div class="container d-flex justify-content-center" style="margin-top: 10%">
        <div class="card p-4" style="width: 30%">
            <form:form method="POST" action="${contextPath}/addCertificate" enctype="form-data">
                <div class="certificate-input">
                    <h5><spring:message code="certificate.first_subject"></spring:message></h5>
                    <input type="number" class="form-control" name="firstSubject" style="margin-bottom: 15px; width: 70px;" />
                </div>
                <div class="certificate-input">
                    <h5><spring:message code="certificate.second_subject"></spring:message></h5>
                    <input type="number" class="form-control" name="secondSubject" style="margin-bottom: 15px; width: 70px;" />
                </div>
                <div class="certificate-input">
                    <h5><spring:message code="certificate.third_subject"></spring:message></h5>
                    <input type="number" class="form-control" name="thirdSubject" style="margin-bottom: 15px; width: 70px;" />
                </div>
                <div class="certificate-input">
                    <h5><spring:message code="certificate.sum_schools"></spring:message></h5>
                    <input type="number" class="form-control" name="sumSchoolsCerticifate" style="margin-bottom: 15px; width: 70px;" />
                </div>
                <div>
                    <button type="submit" class="btn btn-primary"><spring:message code="certificate.add_btn"></spring:message></button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form:form>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="js/main.js"></script>
</body>

</html>