<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title><spring:message code="add.title"></spring:message></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<jsp:include page="header.jsp" />

<body style="background-color: #eee;">
    <div class="container d-flex justify-content-center" style="margin-top: 10%">
        <div class="card p-4">
            <div class="form-group">
            	<form:form method="POST" modelAttribute="facultyForm">
                	<h2 class="mb-3"><spring:message code="add.title"></spring:message></h2>
                		<div class="form-group">
                			<input id="one" class="form-control" type="text" name="name" placeholder="<spring:message code='add.faculty_name' />"></input>
                		</div>
                		<div class="form-group">
                			<input id="two" class="form-control" type="number" name="numberOfStudents" placeholder="<spring:message code='add.number_of_students' />"></input>
                		</div>
                		<div class="form-group">
                			<input id="three" class="form-control" type="number" name="minimumPassingScore" placeholder="<spring:message code='add.minimum_pass_score' />"></input>
                		</div>																		
						<button id="button" type="submit" class="btn btn-primary" disabled><spring:message code='add.submit_btn' /></button>
				</form:form>                                                
            </div>
        </div>
    </div>
    <script type="text/javascript">
    var input1 = document.getElementById('one');
    var input2 = document.getElementById('two');
    var input3 = document.getElementById('three');
    var btn = document.getElementById('button');

    input1.addEventListener("input", validate);
    input2.addEventListener("input", validate);
    input3.addEventListener("input", validate);
    
    function validate(){
    	if(input1.value === "" || input2.value === "" || input3.value === ""){
            btn.setAttribute("disabled","disabled");
        } else {
        	btn.removeAttribute("disabled");  
        }
    } 
    </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="js/main.js"></script>
</body>

</html>