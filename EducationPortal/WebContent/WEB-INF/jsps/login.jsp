<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Page</title>
<link href="${pageContext.request.contextPath }/static/home.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/static/table.css"
	rel="stylesheet" type="text/css" />
</head>
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	<c:if test="${param.err != null }">
		<header> Education Portal
		<div id="loginbutton">Login</div>
		</header>

		<p class="error">Enter correct username or password for login</p>

	</c:if>
	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table class="formtable">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>

		</table>
	</form>

	<p>
		<a href=${pageContext.request.contextPath}/createaccount>Sign up
			for FREE!!!</a>
	</p>

	<footer> <br />
	<br />
	<hr />
	&copy;Copyright Jayant Rane,2017 </footer>
</body>
</html>