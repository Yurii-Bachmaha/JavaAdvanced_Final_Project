<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>${userViewer.firstName} ${userViewer.lastName}`s profile</title>
</head>

<body style="background-color: #eee;">
<jsp:include page="header.jsp" />
<section>
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
            <img src="data:image/jpg;base64, ${userViewer.encodedImage}" alt="avatar"
              class="rounded-circle img-fluid" style="width: 150px;">
            <h5 class="my-3">${userViewer.firstName} ${userViewer.lastName}</h5>
            <p class="text-muted mb-1">${userViewer.email}</p>
            <p class="text-muted mb-4"><spring:message code="home.age"></spring:message> ${userViewer.age} <spring:message code="home.age_txt"></spring:message></p>
            <security:authorize access="hasRole('APPLICANT')">
            	<div class="d-flex justify-content-center mb-2 flex-column">                                 			                      
              		<button id="applyTo" type="button" class="btn btn-primary mb-2" onclick="action()" ><spring:message code="home.apply_for_admission_btn"></spring:message></button>                         
              		<button id="addCertificate" type="button" class="btn btn-outline-primary ms-1" onclick="add()"><spring:message code="home.add_certificate_btn"></spring:message></button>
            	</div>
            </security:authorize>                        
          </div>          
        </div>
      </div>
      <c:choose>
    	<c:when test="${mode == 'VIEW_CANDIDATE'}">
        	<div class="col-lg-4">
            	<div class="card text-center justify-center">
                	<h4 class="my-3"><spring:message code="home.certificate_title"></spring:message></h4>
                	<p class="text-muted"><spring:message code="home.first_subject"></spring:message> ${subjectsViewer.firstSubject}</p>
                	<p class="text-muted"><spring:message code="home.second_subject"></spring:message> ${subjectsViewer.secondSubject}</p>
                	<p class="text-muted"><spring:message code="home.third_subject"></spring:message> ${subjectsViewer.thirdSubject}</p>
                	<p class="text-muted"><spring:message code="home.sum_schools"></spring:message> ${subjectsViewer.sumSchoolsCerticifate}</p>
                	<p class="text-muted"><spring:message code="home.total"></spring:message> ${subjectsViewer.totalGrades}</p>
            	</div>
        	</div>
    	</c:when>
	  </c:choose>
    </div>
  </div>
</section>
	<script type="text/javascript">
	function action() {

	    var button = document.getElementById('applyTo');

	    if (${ subjectsViewer == null }) {
	        button.disabled = true;
	        button.innerHTML = "<spring:message code="home.add_certificate_warn"></spring:message>";
	        button.classList.add("btn-danger");
	    }else {
	    	 location.href = '/applyToFaculty';
	    }
	}
	
	function add() {

	    var button = document.getElementById('addCertificate');

	    if (${ subjectsViewer != null }) {
	        button.disabled = true;
	        button.innerHTML = "<spring:message code="home.certificate_added_warn"></spring:message>";
	        button.classList.add("btn-outline-danger");
	        button.style.background = "#dc3545";
	        button.style.color = "white";
	    }else {
	    	location.href = '/addCertificate';
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