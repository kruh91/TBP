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
		<h2 class="heading">Kontakt informacije - ${user.firstName} ${user.lastName}</h2>
		<div class="side-menu">
			<p><a href="${contextPath}/users/${user.id}">Profil</a></p>
			<p><a href="${contextPath}/users/${user.id}/contact-infos">Kontakt podaci</a></p>
			<p><a href="${contextPath}/users/${user.id}/permissions">Dopuštenja</a></p>
		</div>
		<div class="main-div">
			<div><a href="${contextPath}/users/${user.id}/add-contact-info" class="blue-button">Dodaj kontakt</a></div>
			<table style="width: 300px;">
			<c:forEach items="${user.contactInfos}" var="contactInfo">
				<c:if test="${not empty contactInfo.address}">
		            <tr>
		            	<td style="width: 50%;">Adresa:</td>
		                <td>${contactInfo.address}</td>
		            </tr>
	            </c:if>
	            <c:if test="${not empty contactInfo.town}">
		            <tr>
		            	<td>Mjesto:</td>
		                <td>${contactInfo.town}</td>
		            </tr>
	            </c:if>
	            <c:if test="${not empty contactInfo.postalCode}">
		            <tr>
		            	<td>Poštanski broj:</td>
		                <td>${contactInfo.postalCode}</td>
		            </tr>
	            </c:if>
	            <c:if test="${not empty contactInfo.phone}">
		            <tr>
		            	<td>Telefon:</td>
		                <td>${contactInfo.phone}</td>
		            </tr>
	            </c:if>
	            <c:if test="${not empty contactInfo.mobile}">
		            <tr>
		            	<td>Mobitel:</td>
		                <td>${contactInfo.mobile}</td>
		            </tr>
	            </c:if>
	            <tr class="contact-info-button-row">
                	<td>
                		<form action="${contextPath}/contact-infos/${contactInfo.id}/delete" method="POST">
                			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                			<input type="hidden" name="id" value="${contactInfo.id}"/>
                			<button class="black-button" type="submit" onclick="return confirm('Jeste li sigurni da želite obrisati kontakt?')">Obriši</button>
                		</form>
                	</td>
                    <td><a href="${contextPath}/contact-infos/${contactInfo.id}" class="blue-button">Promjeni</a></td>
                </tr>
	        </c:forEach>
			</table>
		</div>
	</body>
</html>