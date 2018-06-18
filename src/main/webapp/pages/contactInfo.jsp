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
	
	    <title>Kontakt info</title>
	
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
			<spring:hasBindErrors name="contactInfoForm">
		        <c:forEach items="${errors.globalErrors}" var="errorMessage">
                    <div class="error">${errorMessage.defaultMessage}</div>
		        </c:forEach>
			</spring:hasBindErrors>
		<h2 class="heading">Kontakt informacija - ${user.firstName} ${user.lastName}</h2>
		<div class="side-menu">
			<p><a href="${contextPath}/users/${user.id}">Profil</a></p>
			<p><a href="${contextPath}/users/${user.id}/contact-infos">Kontakt podaci</a></p>
			<p><a href="${contextPath}/users/${user.id}/permissions">Dopuštenja</a></p>
		</div>
		<div class="main-div">
				<form:form class="form-user" method="POST" action="${action}" modelAttribute="contactInfoForm">
					<form:hidden path="id"/>
					<form:hidden path="userId"/>
					<table>
		                <tr>
		                    <td><form:label path="address">Adresa:</form:label></td>
		                    <td><form:input class="form-control" path="address"/>
		                    	<p><form:errors cssClass="formError" path="address"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="town">Mjesto:</form:label></td>
		                    <td><form:input class="form-control" path="town"/>
		                    	<p><form:errors cssClass="formError" path="town"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="postalCode">Poštanski broj:</form:label></td>
		                    <td><form:input class="form-control" path="postalCode"/>
		                    	<p><form:errors cssClass="formError" path="postalCode"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="country">Država:</form:label></td>
		                    <td><form:input class="form-control" path="country"/>
		                    	<p><form:errors cssClass="formError" path="country"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="phone">Telefon:</form:label></td>
		                    <td><form:input class="form-control" path="phone" />
		                    	<p><form:errors cssClass="formError" path="phone"/></p>
		                    </td>
		                </tr>
		                <tr>
		                    <td><form:label path="mobile">Mobitel:</form:label></td>
		                    <td><form:input class="form-control" path="mobile" />
		                    	<p><form:errors cssClass="formError" path="mobile"/></p>
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