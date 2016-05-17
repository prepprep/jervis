<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome this is your page</title>
</head>
<body>
	<c:url var="url" value="/resources/text.txt" />
	<spring:url var="springUrl" value="/resources/text.txt"
		htmlEscape="true" />
	<h1 style="color:gray"> There are just <span style="color:red">${time}</span>  days left!</h1>
	<br>Spring URL: ${springUrl}
	<br> JSTL URL: ${url}
	<br> This is my test: ${abc}


	<c:forEach var="counter" begin="0" end="4" step="1">
		<c:set var="myCount" value="${counter}" />
		<c:out value="${myCount}" />
		<br>
		<%
		    out.println("Category: " + pageContext.findAttribute("myCount"));
		%>

	</c:forEach>

</body>
</html>