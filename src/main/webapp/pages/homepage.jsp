<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <title>Korisnici</title>
	
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
		<div class="main-div">
			<h2 class="heading">Korisnici</h2>
			<div><a href="${contextPath}/users/add-user" class="blue-button">Dodaj korisnika</a></div>
			<table>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><a href="${contextPath}/users/${user.id}">${user.firstName} ${user.lastName}</a> - ${user.email}</td>
					<td align="center" style="width: 100px;">
						<form action="${contextPath}/users/${user.id}/delete" method="POST">
                			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                			<input type="hidden" name="id" value="${user.id}"/>
                			<input type="submit" class="delete-button" type="submit" onclick="return confirm('Jeste li sigurni da želite obrisati korisnika?')" />
                		</form>
               		</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</body>
</html>