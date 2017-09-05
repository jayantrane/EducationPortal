<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

				
<table id="reports-table"> 
<tr>
	<th>Time</th><th>Prescription</th><th>Remark</th></tr>
	<c:forEach var="report" items="${reports}">
<tr><td>${report.time}</td><td>${report.prescription}</td><td>${report.remark}</td></tr>
	</c:forEach>
</table>

    