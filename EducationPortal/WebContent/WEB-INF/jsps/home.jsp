<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath }/static/home.css"
	rel="stylesheet" type="text/css" />
<title>Education Portal</title>
</head>

<body>

	<header> Education Portal
	<div id="loginbutton">Login</div>
	</header>

	<div id="center">
		<div id="box1">
			<a href="${pageContext.request.contextPath }/createreview">Create
				a Review</a>
		</div>

		<div id="box2">
			<a href="${pageContext.request.contextPath }/reviews">See Reviews</a>

			<p>
			<form
				action="${pageContext.request.contextPath }/j_spring_security_logout"
				method="post">

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="submit" value="logout">

			</form>

		</div>

	</div>

	<footer> <br />
	<br />
	<hr />
	&copy;Copyright Jayant Rane,2017 </footer>



</body>
</html>
