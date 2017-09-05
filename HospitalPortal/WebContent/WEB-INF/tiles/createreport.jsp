<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/datetime.js">

	</script>

<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication
		property="principal.username" />
</security:authorize>

<sf:form method="post"
	action="${pageContext.request.contextPath}/increatereport"
	commandName="report">
	<table class="formtable">
		<tr>
			<td>Select Patient:</td>
			<td><select name="patientname">
					<c:forEach var="name" items="${patientnames}">
						<option>${name}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
		<tr>
			<td>Time:</td>
			<td><sf:input type="text" path="time" name="time" /><br /> <sf:errors
					path="time" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td><input type="date" id="dt" onchange="mydate1();" /> <input
				type="text" id="ndt" onclick="mydate();" /></td>
			<td><input type="button" Value="Date" onclick="mydate();" /></td>
		</tr>
		<tr>
			<td>Prescription:</td>
			<td><sf:input type="text" path="prescription"
					name="prescription" /><br /> <sf:errors path="prescription"
					cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td>Remark:</td>
			<td><sf:input type="text" path="remark" name="remark" /><br />
				<sf:errors path="remark" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
		<tr>
			<td id="sbutton"><input type="submit" name="AddReport"
				value="Add Report"></td>
		</tr>
	</table>

</sf:form>
