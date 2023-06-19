<%@ page isELIgnored = "false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>This is what you entered</h2>
<p>Name: <c:out value="${customer.name}"></c:out></p>
<p>Country: <c:out value="${customer.country}"></c:out></p>
</body>
</html>