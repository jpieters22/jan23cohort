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
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
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
        <h1>Welcome to the WOS MART Store</h1>
        <h2>All Recipes</h2>
        <div class="row">
        	<c:forEach items="${ allFood }" var="item">
        		<div class="column">
        			<h3>${ item.name }</h3>
        			<img src="${ item.img }" alt="${ item.name }" />
        			<button><a href="item/${ item.id }/view">View</a></button>
        		</div>
        	</c:forEach>
        </div>
        <h2>All Notes</h2>
        <div class="row">
        	<c:forEach items="${ allNote }" var="item">
        		<div class="column">
        			<h3>${ item.title }</h3>
        			<button><a href="item/${ item.id }/view">View</a></button>
        		</div>
        	</c:forEach>
        </div>
        <h2>All Links</h2>
        <div class="row">
        	
        	<c:forEach items="${ allLink }" var="item">
        		<div class="column">
        			<h3>${ item.title }</h3>
        			<button><a href="item/${ item.id }/view">View</a></button>
        		</div>
        	</c:forEach>
        </div>
        <h2>All Stickers</h2>
                <div class="row">
        	
        	<c:forEach items="${ allStick }" var="item">
        		<div class="column">
        			<h3>${ item.name }</h3>
        			<img src="${ item.img }" alt="${ item.name }" />
        			<button><a href="item/${ item.id }/view">View</a></button>
        		</div>
        	</c:forEach>
        </div>
        <h2>All Squishies</h2>
                <div class="row">
        	
        	<c:forEach items="${ allSquish }" var="item">
        		<div class="column">
        			<h3>${ item.name }</h3>
        			<img src="${ item.img }" alt="${ item.name }" />
        			<button><a href="item/${ item.id }/view">View</a></button>
        		</div>
        	</c:forEach>
        </div>
        <h2>All Puppies</h2>
                <div class="row">
        	
        	<c:forEach items="${ allPup }" var="item">
        		<div class="column">
        			<h3>${ item.name }</h3>
        			<img src="${ item.img }" alt="${ item.name }" />
        			<button><a href="item/${ item.id }/view">View</a></button>
        		</div>
        	</c:forEach>
        </div>
    </main>
    <footer>
        <img src="/images/bee.png" alt="">
    </footer>
    <script src="/js/script.js"></script>
</body>
</html>