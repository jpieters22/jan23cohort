<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fruit Store</h1>

<table class="table">
<tr>
<th>Name</th>
<th>Price</th>
</tr>
<tr>
<c:forEach var="fruits" items = "${items}">
<tr>
<td>
<p><c:out value= "${fruits.name}"></c:out></p>
</td>
</tr>
<tr>
<td>
<p><c:out value= "${fruits.price}"></c:out></p>
</td>
</tr>
</c:forEach>
</tr>
</table>
</body>
</html>