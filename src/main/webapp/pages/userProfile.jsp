<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="active" value="Ne" />
<c:if test="${user.active}">
<c:set var="active" value="Da" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <title>Profil</title>
	
	    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="menu">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<a href="${contextPath}">Početna</a>
			<a class="logout-menu-option" onclick="document.forms['logoutForm'].submit()">Odjava</a>
		</div>
		<c:if test="${not empty successMessage}">
			<div class="success">${successMessage}</div>
		</c:if>
		<h2 class="heading">Korisnk ${user.firstName} ${user.lastName}</h2>
		<c:if test="${not empty userProfileForm.id}">
			<div class="side-menu">
				<p><a href="${contextPath}/users/${userProfileForm.id}">Profil</a></p>
				<p><a href="${contextPath}/users/${userProfileForm.id}/contact-infos">Kontakt podaci</a></p>
				<p><a href="${contextPath}/users/${userProfileForm.id}/permissions">Dopuštenja</a></p>
			</div>
		</c:if>
		<div class="main-div">
				<form:form class="form-user" method="POST" modelAttribute="userProfileForm">
					<form:hidden path="id"/>
					<form:hidden path="deleted"/>
					<table>
		                <tr>
		                    <td><form:label path="firstName">Ime:</form:label></td>
		                    <td><form:input class="form-control" path="firstName"/>
		                    	<p><form:errors cssClass="formError" path="firstName"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="lastName">Prezime:</form:label></td>
		                    <td><form:input class="form-control" path="lastName"/>
		                    	<p><form:errors cssClass="formError" path="lastName"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="email">Email:</form:label></td>
		                    <td><form:input class="form-control" path="email"/>
		                    	<p><form:errors cssClass="formError" path="email"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="username">Korisničko ime:</form:label></td>
		                    <td><form:input class="form-control" path="username" readonly="${usernameReadOnly}"/>
		                    	<p><form:errors cssClass="formError" path="username"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="password">Lozinka:</form:label></td>
		                    <td><input style="display:none;" type="password"></input>
		                    	<form:password class="form-control" path="password"/>
		                    	<p><form:errors cssClass="formError" path="password"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="active">Aktivan:</form:label><p></p></td>
		                    <td><form:checkbox class="form-control" path="active"/><p></p></td>
		                </tr>
		                <tr>
		                    <td><form:label path="type">Tip:</form:label></td>
		                    <td><form:select class="form-control" path="type">
		                    		<form:options items="${customerTypes}" />
		                    	</form:select>
		                    	<p><form:errors cssClass="formError" path="type"/></p>
		                    </td>
		                </tr>
		                <tr>
		                	<td align="right"></td>
		                    <td align="right"><button class="blue-button" type="submit">Spremi</button></td>
		                </tr>
	                </table>
				</form:form>
		</div>
	</body>
</html>