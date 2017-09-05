<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath }/static/css/home.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/static/css/table.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="${pageContext.request.contextPath }/static/script/jquery.js" ></script>


<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
	
	<div id="header-css">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div id="content-css">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
		
	</div>
		<div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		
	</div>
</body>
</html>