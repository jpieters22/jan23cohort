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
<title>Dashboard</title>
</head>
<body>
	<div class="container my-5 fs-5">
        <div class="row">
            <div class="col">
                <h2 class="display-4">Welcome, ${theUser.firstName}</h2>
                <p>Books from everyone's shelves:</p>
            </div>
            <div class="col d-flex flex-column justify-content-around align-items-end">
                <a href="/logout">Logout</a>
                <a href="/books/new">Add a book!</a>
            </div>
        </div>
        <table class="table table-striped border mt-3">
            <thead>
                <th scope="col">ID</th>
                <th scope="col">Title</th>
                <th scope="col">Author Name</th>
                <th scope="col">Posted By</th>
            </thead>
            <tbody>
                <c:forEach var="book" items="${allBooks}">
                    <tr>        
                        <td>${book.id}</td>
                        <td><a href="/books/${book.id}">${book.title}</a></td>
                        <td>${book.author}</td>
                        <td>${theUser.firstName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
</body>
</html>