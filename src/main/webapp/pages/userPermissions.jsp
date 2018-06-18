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
	
	    <title>Dopuštenja</title>
	
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
		<h2 class="heading">Dopuštenja - ${user.firstName} ${user.lastName}</h2>
		<div class="side-menu">
			<p><a href="${contextPath}/users/${user.id}">Profil</a></p>
			<p><a href="${contextPath}/users/${user.id}/contact-infos">Kontakt podaci</a></p>
			<p><a href="${contextPath}/users/${user.id}/permissions">Dopuštenja</a></p>
		</div>
		<div class="main-div">
				<form:form class="form-user" method="POST" modelAttribute="userPermissionsForm">
					<form:hidden path="userId"/>
					<table>
					<c:forEach items="${allPermissions}" var="permission">
			            <tr>
			            	<td>${permission.name}</td>
			                <td><form:checkbox path="permissions" value="${permission.id}" /></td>
			            </tr>
			        </c:forEach>
		                <tr>
		                	<td align="right"></td>
		                    <td align="right"><button class="blue-button" type="submit">Spremi</button></td>
		                </tr>
	                </table>
				</form:form>
		</div>
	</body>
</html>