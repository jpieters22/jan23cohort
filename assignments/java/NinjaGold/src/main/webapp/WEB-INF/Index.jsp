<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
	<header>
		<h1>Ninja Gold</h1>
	</header>
	
	<main>
	
	<div class="goldCount">
		<h2>Your Gold: <span id="count"><c:out value="${count}"></c:out></span></h2>
		<button><a href="/reset">Reset</a></button>
	</div>
	
	<div class="row">
		<div id="farm">
			<h2>Farm</h2>
			<p>(Earns 10-20 gold)</p>
			<form action="/gold/farm" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
		<div id="cave">
			<h2>Cave</h2>
			<p>(Earns 5-10 gold)</p>
			<form action="/gold/cave" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
		<div id="house">
			<h2>House</h2>
			<p>(Earns 2-5 gold)</p>
			<form action="/gold/house" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
		<div id="quest">
			<h2>Quest</h2>
			<p>(Earns/Takes 0-50 gold)</p>
			<form action="/gold/quest" method="post">
				<button>Find Gold!</button>
			</form>
		</div>
	</div>
	
	<div id="activities">
		<h2>Activities</h2>
		<div class="activitiesLoop">
			<c:if test="${count == 0}">
				<c:out value="${activity}"/>
			</c:if>
			<c:if test = "${count != 0}">
				<c:forEach var = "i" items="${activity}">
					<c:if test="${i.contains('earned')}">
						<p style="color: green;"><c:out value = "${i}"/></p>
					</c:if>
					<c:if test="${i.contains('lost')}">
						<p style="color: red;"><c:out value = "${i}"/></p>
					</c:if>
				</c:forEach>
			</c:if>
		</div>
	</div>
	</main>

</body>
</html>