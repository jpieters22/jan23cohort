<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for validation -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<header>
<h1>Hello</h1>
</header>

<main>
<form:form action="/createStudent" method="post" modelAttribute="studentForm">
<section>
<label for="firstName">First Name</label>
<input type="text" name="firstName" />
<form:errors path="firstName" class="text-warning"/>
</section>

<section>
<label for="lastName">Last Name</label>
<input type="text" name="lastName" />
<form:errors path="lastName" class="text-warning"/>
</section>

<section>
<label for="age">Age</label>
<input type="number" name="age" />
<form:errors path="age" class="text-warning"/>
</section>

<section>
<label for="studentId">Student ID#</label>
<input type="number" name="studentId" />
<form:errors path="studentId" class="text-warning"/>
</section>

<button>Add Student</button>
</form:form>
</main>


</body>
</html>