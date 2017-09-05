<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="login-div">
	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST' onload='document.f.username.focus();'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table id="centered">
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
</div>
<div id="createaccount-div">
	<p>
	<div id="signup-text">
		To access hospital portal <br /> Please create an account <br /> 
	</div>
	<br /> <br /> <a id="createaccount-link"
		href=${pageContext.request.contextPath}/createuser>Create an
		account</a>
	
</div>
