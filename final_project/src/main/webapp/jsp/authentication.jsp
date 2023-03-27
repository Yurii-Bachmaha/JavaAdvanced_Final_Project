<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title><spring:message code="auth.page_title"></spring:message></title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data">
            	<h2><spring:message code="auth.create_title"></spring:message></h2>
            		<div class="form-group">             
                        <input type="text" name="firstName" class="form-control" placeholder='<spring:message code="auth.first_name"></spring:message>'>
                    </div>
                    <div class="form-group">             
                        <input type="text" name="lastName" class="form-control" placeholder='<spring:message code="auth.last_name"></spring:message>'>
                    </div>
                    <div class="form-group">             
                        <input type="text" name="email" class="form-control" placeholder='<spring:message code="auth.email"></spring:message>'>
                    </div>
                    <div class="form-group">             
                        <input type="number" name="age" class="form-control" placeholder='<spring:message code="auth.age"></spring:message>'>
                    </div>
                    <div class="form-group">             
                        <input type="password" name="password" class="form-control" placeholder='<spring:message code="auth.password"></spring:message>'>
                    </div>
                    <div class="form-group">             
                        <input type="password" name="passwordConfirm" class="form-control" placeholder='<spring:message code="auth.password_confirm"></spring:message>'>
                    </div>
                    <div class="form-group">             
                        <input type="file" name="encodedImage" class="form-control">
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="auth.sign_up"></spring:message></button>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
        	</div>

        <div class="form-container sign-in-container">
            <form method="POST" action="${contextPath}/authentication" class="form-signin login">
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <h1><spring:message code="auth.sign_in"></spring:message></h1>
                    <span>${message}</span>
                    <input name="email" type="text" class="form-control" placeholder='<spring:message code="auth.email"></spring:message>' autofocus="true" />
                    <input name="password" type="password" class="form-control" placeholder='<spring:message code="auth.password"></spring:message>' />
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button type="submit"><spring:message code="auth.sign_in"></spring:message></button>
                </div>
            </form>
        </div>

        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1><spring:message code="auth.sign_in_overlay_header"></spring:message></h1>
                    <p><spring:message code="auth.sign_in_overlay_p"></spring:message></p>
                    <button class="ghost" id="signIn"><spring:message code="auth.sign_in"></spring:message></button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1><spring:message code="auth.sign_up_overlay_header"></spring:message></h1>
                    <p><spring:message code="auth.sign_up_overlay_p"></spring:message></p>
                    <button class="ghost" id="signUp"><spring:message code="auth.sign_up"></spring:message></button>
                </div>
            </div>
        </div>
    </div>
    
	<div>		
		<label><spring:message code="auth.choose_lang"></spring:message></label>
			<select id="locales">	
				<option value="ua"><spring:message code="auth.ukrainian"></spring:message></option>				
				<option value="en"><spring:message code="auth.english"></spring:message></option>				
			</select>
	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

</body>

</html>