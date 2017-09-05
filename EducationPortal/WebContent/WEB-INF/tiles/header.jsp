
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="name">Education Portal</div>

<div id="header-nav" role="navigation">
	<ul>
		<li><a href="${pageContext.request.contextPath }/">Home</a></li>
		<li><a >Institutions</a></li>
		<li><a href="${pageContext.request.contextPath }/review">Review</a></li>
		<li class="loginbutton">
		<sec:authorize
				access="!isAuthenticated()">Please
			</sec:authorize>
			 <sec:authorize access="isAuthenticated()">

				<form id="myform" 
					 action="${pageContext.request.contextPath }/j_spring_security_logout" 
					method="post">

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> 
						
					<a><input type="submit" class="linkButton" value="logout"></a>	
					<!--  <a onclick="document.getElementById('myForm').submit();">Logout</a> -->

				</form>
			</sec:authorize></li>

	</ul>


</div>

