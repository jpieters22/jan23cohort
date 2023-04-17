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
<!-- Bootstrap CSS -->
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> -->
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- My CSS -->
<link rel='stylesheet' href='/styles.css'>
<script type = "text/javascript" src='/js/scripts.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container my-5 fs-5">
        <div class="d-flex justify-content-between align-items-center mb-5">
            <h2 class="display-3">${book.title}</h2>
            <a href="/books">back to dashboard</a>
        </div>
        <c:if test="${book.user.id == sessionScope.user_id}">
            <p><span class="text-danger">You</span> read <span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span></p>
            <p>Here are your thoughts:</p>
        </c:if>
        <c:if test="${book.user.id != sessionScope.user_id}">
            <p><span class="text-danger">${book.user.name}</span> read <span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span></p>
            <p>Here are ${book.user.name}'s thoughts:</p>
        </c:if>
        <p class="border-top border-bottom col-6 p-3 fst-italic fw-light">${book.thoughts}</p>
        <c:if test="${book.user.id == sessionScope.user_id}">
            <div class="mt-3 col-6 text-end">
                <a class="me-3" href="/books/${book.id}/edit">Edit</a>
                <form:form action="/books/${book.id}/delete" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <button class="btn btn-link fs-5">Delete</button>
                </form:form>
            </div>
        </c:if>
	</div>
</body>
</html>