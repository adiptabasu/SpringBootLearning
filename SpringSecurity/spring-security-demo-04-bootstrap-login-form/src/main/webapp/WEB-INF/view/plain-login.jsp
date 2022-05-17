<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
</head>
<body>
	<div class="login-card">
		<h3>My Custom Login Page</h3>
		<form:form 
			action="${pageContext.request.contextPath }/authenticateTheUser"
			method="POST"
		>
			<c:if test="${param.error !=null}">
				<i class="login-error-message">Sorry! You entered invalid Credentials</i>
			</c:if>
			<table>
				<tr>
					<p>
						<td>User Name:</td>
						<td><input type="text" name="username"/></td>
					</p>
				</tr>
				<tr>
					<p>
						<td>Password:</td>
						<td><input type="password" name="password"/></td>
					</p>
				</tr>
				<tr>
					<td></td>
					<td>
						<input class="btn-primary" type="submit" value="Login"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>