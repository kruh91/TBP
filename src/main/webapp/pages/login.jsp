<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <title>Prijava</title>
	
	    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="main-div">
		    <form method="POST" action="${contextPath}/login" class="form-signin">
		        <h2 class="heading">Prijava</h2>
		
		        <div class="form-group ${error != null ? 'has-error' : ''}">
		            <span>${message}</span>
		            <span>${error}</span>
		            <input name="username" type="text" class="form-control" placeholder="Korisničko ime" autofocus/>
		            <input name="password" type="password" class="form-control" placeholder="Lozinka"/>
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		            <p>
					<button class="blue-button" type="submit">Prijava</button>
				</p>
		        </div>
		    </form>
		</div>
	</body>
</html>