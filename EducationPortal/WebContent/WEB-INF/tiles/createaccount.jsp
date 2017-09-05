<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<script type="text/javascript">
	function onLoad() {
		$("#password").keyup();
		$("#confpassword").keyup(checkPasswordMatch);
		$("#accform").submit(onSubmit);
		
	}
	function onSubmit(){
		var password = $("#password").val();
		var confpassword = $("#confpassword").val();
		
		if(password != confpassword){
			alert("Passwords do not match");
			return false;
		}else
			return true;
	}
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confpassword = $("#confpassword").val();

		if (password.length > 3 || confpassword.length > 3) {

			if (password == confpassword) {
				$("#passmatch").text("Password Match");
				$("#passmatch").addClass("valid");
				$("#passmatch").removeClass("error");
			} else {
				$("#passmatch").text("Password do no Match");
				$("#passmatch").addClass("error");
				$("#passmatch").removeClass("valid");
			}
		}
	}
	$(document).ready(onLoad);
</script>
<sf:form id="accform" method="post"
	action="${pageContext.request.contextPath}/inaccount"
	commandName="user">
	<table class="formtable">
		<tr>
			<td>Username:</td>
			<td><sf:input type="text" path="username" name="username" /><br />
			<sf:errors path="username" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><sf:input type="text" path="email" name="email" /><br />
			<sf:errors path="email" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><sf:input id="password" type="password" path="password"
					name="password" /><br />
			<sf:errors path="password" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td>Confirm password:</td>
			<td><input id="confpassword" type="password" name="confpassword" /><br />
			<div id="passmatch"></div></td>
		</tr>

		<tr>
			<td id="sbutton"><input type="submit" name="createacc"
				value="Create Account!!"></td>
		</tr>
	</table>

</sf:form>
