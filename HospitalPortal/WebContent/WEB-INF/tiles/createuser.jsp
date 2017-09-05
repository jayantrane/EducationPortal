<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/selectdoctorshowhide.js">

	</script>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/increateuser" commandName="user">
		<table class = "formtable">
		
			
			<tr>
			<td>Name:</td>
				<td><sf:input type="text" path="name" name="name"/><br/><sf:errors path="name"  cssClass="error"></sf:errors></td>
				
			</tr>
			<tr>
			<td>User Name:</td>
				<td><sf:input type="text" path="username" name="username"/><br/><sf:errors path="username"  cssClass="error"></sf:errors></td>
				
			</tr>
			<tr>
				<td>Password:</td>
				<td><sf:input type="password" path="password" name="password"/><br/><sf:errors path="password"  cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><sf:input type="text"  path="age" name="age" value=" "/><br/><sf:errors path="age"  cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><input type="radio"   name="type" id="patient" value="patient" onClick="validateRadio()" />Patient<br/>
				<input type="radio"  name="type" id="doctor" value="doctor" onClick="validateRadio()"/>Doctor<br/>
				</td>
			</tr>
			
			<tr id="selectdoctor">
				<td>Select Doctor:</td>
				<td>
					<select name="doctorname">
						<c:forEach var="name" items="${names}">
							<option>${name }</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			
			<tr>
				<td  id="sbutton" ><input type="submit" name="AddUser" value="Add User"></td>
			</tr>
		</table>

	</sf:form>
	