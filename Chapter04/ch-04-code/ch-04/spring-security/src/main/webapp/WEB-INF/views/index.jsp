<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security Configuration</title>
</head>
<body>
	<h1>${title}</h1>
	<h2>${message}</h2>
	
	<form action='<spring:url value="/logout"/>' method="post">
		<input value="Logout" type="submit">
	</form>
</body>
</html>
