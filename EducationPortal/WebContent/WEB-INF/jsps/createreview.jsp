<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath }/static/home.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/static/table.css" rel="stylesheet" type="text/css" />
<title>Add Review</title>
</head>
<body>
 <header >
			Education Portal			
			<div id="loginbutton">
				Login
			</div>
		</header>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/increate" commandName="review">
		<table class = "formtable">
			<tr>
				<td>Your Name:</td>
				<td><sf:input type="text" path="name" name="name"/><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input type="text" path="email" name="email"/><br/><sf:errors path="email"  cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>College:</td>
				<td><sf:input type="text" path="college" name="college"/><br/><sf:errors path="college"  cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Feedback:</td>
				<td><sf:input type="text" path="feedback" name="feedback"/><br/><sf:errors path="feedback"  cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td><input type="submit" name="Add Review" value="Add Review"></td>
			</tr>
		</table>

	</sf:form>
			<footer>
		<br/>
		<br/>
		<hr/>
			&copy;Copyright Jayant Rane,2017
			
		</footer>
</body>
</html>