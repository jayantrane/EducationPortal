<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<p><h2>Hi Users</h2>


<table id="user-table"> 
<tr>
	<th>ID</th><th>User Name </th><th>Password</th><th>Role</th><th>Age</th><th>Type</th></tr>
	<c:forEach var="user" items="${users}">
<tr><td>${user.id}</td><td>${user.username}</td><td>${user.password}</td><td>${user.role}</td><td>${user.age}</td><td>${user.type}</td></tr>
	</c:forEach>
</table>
