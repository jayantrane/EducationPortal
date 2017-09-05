<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				
<table id="reports-table"> 
<tr>
	<th>Time</th><th>Prescription</th><th>Remark</th></tr>
	<c:forEach var="report" items="${myreports}">
<tr><td>${report.time}</td><td>${report.prescription}</td><td>${report.remark}</td></tr>
	</c:forEach>
</table>

