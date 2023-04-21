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
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/js/components/nav.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>WOS Mart</title>
</head>
<body>
	<header>
        <pre>
            <c:import url="/resources/ascii.txt" />
        </pre>
        <nav-component></nav-component>
	</header>
    <main>
        <h1>Welcome ${ theUser.firstName }</h1>
        <h2>Here is what you have saved to your WOS Mart Cart</h2>
       	<table>
       		<tr>
       			<th colspan="3">Recipes</th>
       		</tr>
            <tr>
                <th>Title</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
			<c:forEach items="${ theCart }" var="cart">
				<c:if test="${ user_id == cart.cartOwner.id }">
					<c:if test="${ cart.category == 'Food' }">
						<tr>
							<td>${ cart.name }</td>
							<td><img src="${ cart.img }" alt="${ cart.name }" /></td>
							<td><button><a href="/cart/${ cart.id }/view">View</a></button></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
            <tr>
                <th colspan="3">Notes</th>
            </tr>
            <tr>
                <th>Title</th>
                <th colspan="2">Actions</th>
            </tr>
			<c:forEach items="${ theCart }" var="cart">
				<c:if test="${ user_id == cart.cartOwner.id }">
					<c:if test="${ cart.category == 'Note' }">
						<tr>
							<td>${ cart.name }</td>
							<td colspan="2"><button><a href="/cart/${ cart.id }/view">View</a></button></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
			<tr>
                <th colspan="3">Links</th>
            </tr>
            <tr>
                <th>Title</th>
                <th colspan="2">Actions</th>
            </tr>
			<c:forEach items="${ theCart }" var="cart">
				<c:if test="${ user_id == cart.cartOwner.id }">
					<c:if test="${ cart.category == 'Link' }">
						<tr>
							<td>${ cart.name }</td>
							<td colspan="2"><button><a href="/cart${ cart.id }/view">View</a></button></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
            <tr>
                <th colspan="3">Puppies</th>
            </tr>
            <tr>
                <th>Name</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
			<c:forEach items="${ theCart }" var="cart">
				<c:if test="${ user_id == cart.cartOwner.id }">
					<c:if test="${ cart.category == 'Puppy' }">
						<tr>
							<td>${ cart.name }</td>
							<td><img src="${ cart.img }" alt="${ cart.name }" /></td>
							<td><button><a href="/cart/${ cart.id }/view">View</a></button></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
            <tr>
                <th colspan="3">Squishies</th>
            </tr>
            <tr>
                <th>Name</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
			<c:forEach items="${ theCart }" var="cart">
				<c:if test="${ user_id == cart.cartOwner.id }">
					<c:if test="${ cart.category == 'Squish' }">
						<tr>
							<td>${ cart.name }</td>
							<td><img src="${ cart.img }" alt="${ cart.name }" /></td>
							<td><button><a href="/cart/${ cart.id }/view">View</a></button></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
            <tr>
                <th colspan="3">Stickers</th>
            </tr>
            <tr>
                <th>Title</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
			<c:forEach items="${ theCart }" var="cart">
				<c:if test="${ user_id == cart.cartOwner.id }">
					<c:if test="${ cart.category == 'Sticker' }">
						<tr>
							<td>${ cart.name }</td>
							<td><img src="${ cart.img }" alt="${ cart.name }" /></td>
							<td><button><a href="/cart/${ cart.id }/view">View</a></button></td>
						</tr>
					</c:if>
				</c:if>
			</c:forEach>
       	</table>
    </main>
    <footer>
        <img src="/images/bee.png" alt="">
    </footer>
    <script src="/js/script.js"></script>
</body>
</html>