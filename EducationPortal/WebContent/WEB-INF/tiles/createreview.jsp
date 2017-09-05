<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/increate" commandName="review">
		<table class = "formtable">
			<tr>
				<td>Your Name:</td>
				<td><sf:input type="text" path="name" name="name" size="100" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
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
				<td><sf:textarea  path="feedback" name="feedback" rows="8" cols="100"/><br/><sf:errors path="feedback"  cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td  id="sbutton" ><input type="submit" name="Add Review" value="Add Review"></td>
			</tr>
		</table>

	</sf:form>
	