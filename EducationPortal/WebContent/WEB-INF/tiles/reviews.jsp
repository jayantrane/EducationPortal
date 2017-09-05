<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table id="review-table"> 
<thead>
	<td>Name</td><td>Email</td><td>College</td><td>Feedback</td></thead>
	<c:forEach var="review" items="${reviews}">
<tr><td>${review.name}</td><td>${review.email}</td><td>${review.college}</td><td>${review.feedback}</td></tr>
	</c:forEach>
</table>

