<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication
		property="principal.username" />
</security:authorize>


<sf:form method="post"
	action="${pageContext.request.contextPath}/inpatientreport">
	<table class="formtable">
		<tr>
			<td>Select Patient:</td>
			<td><select name="patientreport">
					<c:forEach var="name" items="${patientnames}">
						<option>${name}</option>
					</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td colspan="2" ><input type="submit" name="select patient"
				value="Select Patient"></td>
		</tr>
	</table>
</sf:form>