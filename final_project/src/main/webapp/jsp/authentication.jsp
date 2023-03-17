<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Authentication</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data">
            	<h2>Create your account</h2>
            		<div class="form-group">             
                        <input type="text" name="firstName" class="form-control" placeholder="First name">
                    </div>
                    <div class="form-group">             
                        <input type="text" name="lastName" class="form-control" placeholder="Last name">
                    </div>
                    <div class="form-group">             
                        <input type="text" name="email" class="form-control" placeholder="Email">
                    </div>
                    <div class="form-group">             
                        <input type="number" name="age" class="form-control" placeholder="Age">
                    </div>
                    <div class="form-group">             
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">             
                        <input type="password" name="passwordConfirm" class="form-control" placeholder="Password confirm">
                    </div>
                    <div class="form-group">             
                        <input type="file" name="encodedImage" class="form-control">
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
        	</div>

        <div class="form-container sign-in-container">
            <form method="POST" action="${contextPath}/authentication" class="form-signin login">
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <h1>Sign in</h1>
                    <span>${message}</span>
                    <input name="email" type="text" class="form-control" placeholder="Email" autofocus="true" />
                    <input name="password" type="password" class="form-control" placeholder="Password" />
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button type="submit">Sign In</button>
                </div>
            </form>
        </div>

        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="js/login.js"></script>

</body>

</html>