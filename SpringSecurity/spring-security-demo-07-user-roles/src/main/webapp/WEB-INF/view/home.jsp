<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome to the Home Page</h1>
	
	<hr>
		User:<security:authentication 
				property="principal.username"
			/>
			<br/>
		Role(s):<security:authentication 
				property="principal.authorities"
				/>
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- Adding a link to point to /leaders ... for managers -->
	
		<p>
			<a href="${pageContext.request.contextPath }/leaders">Leadership meeting</a>
			(Only for managers)
		</p>
	</security:authorize>
	<hr>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- Adding a link to point to /systems ... for admins -->
	
	<p>
		<a href="${pageContext.request.contextPath }/systems">IT Systems Meeting</a>
		(Only for admin)
	</p>
	
	<hr>
	</security:authorize>
	<!-- Logout Button -->
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>