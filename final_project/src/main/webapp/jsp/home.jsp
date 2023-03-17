<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <p class="text-muted mb-4">Age: ${userViewer.age}</p>
            <div class="d-flex justify-content-center mb-2 flex-column">                                 			                      
              <button id="applyTo" type="button" class="btn btn-primary mb-2" onclick="action()" >Apply for admission</button>                         
              <button id="certificate" type="button" class="btn btn-outline-primary ms-1" onclick="location.href='/addCertificate'">Add certificate</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	<script type="text/javascript">
	function action() {

	    var button = document.getElementById('applyTo');

	    if (${ subjectsViewer == null }) {
	        button.disabled = true;
	        button.innerHTML = "Add a certificate first";
	        button.classList.add("btn-danger");
	    } else {
	        button.style.visibility = 'visible';
	        redirect();
	    }
	}
	function redirect() {
	    location.href = '/applyToFaculty'
	}
	</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>