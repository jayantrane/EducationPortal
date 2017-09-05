<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/reportisdoctor.js">
<!--

//-->
</script>
<input type="hidden" id="isdoctor" value='${isdoctor}'/>
			<div id="patients-div">
						<a href="${pageContext.request.contextPath }/createreport">Create a Report</a>
			</div>
			
			<div id="reports-div">
			<a href="${pageContext.request.contextPath }/patients">See Reports</a>
			
			</div>
			
			<div id="myreports-div">
			
			<a href="${pageContext.request.contextPath }/myreports">See my Reports</a>
			</div>
