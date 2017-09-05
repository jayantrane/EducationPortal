<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath }/static/home.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/static/table.css" rel="stylesheet" type="text/css" />
<title>Reviews</title>
</head>
<body>
 <header >
			Education Portal			
			<div id="loginbutton">
				Login
			</div>
		</header>
<c:forEach var="review" items="${reviews}">

<table> 
<p>Name:${review.name}<br />
Email:${review.email}<br />
College:${review.college}<br />
Feedback:${review.feedback}<br /> 
</p>
</table>
	</c:forEach>
			<footer>
		<br/>
		<br/>
		<hr/>
			&copy;Copyright Jayant Rane,2017
			
		</footer>
</body>
</html>