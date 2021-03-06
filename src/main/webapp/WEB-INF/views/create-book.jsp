<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create book</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/login-style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/for-books.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <form:form method="POST" modelAttribute="bookForm" class="form-signin">
        <h2 class="form-signin-heading">Create book</h2>
        <br>
        <br>
        <spring:bind path="bookTitle">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="inputTitle">Book Title</label>
                <form:input id="inputTitle" type="text" path="bookTitle" class="form-control" placeholder="Book Title" autofocus="true"/>
                <form:errors path="bookTitle"/>
            </div>
        </spring:bind>

        <spring:bind path="bookAuthor">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="inputAuthor">Book Author</label>
                <form:input id="inputAuthor" type="text" path="bookAuthor" class="form-control" placeholder="Book Author" autofocus="true"/>
                <form:errors path="bookAuthor"/>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="inputPrice">Book Price</label>
                <form:input id="inputPrice" type="text" path="price" class="form-control" placeholder="Book Price" autofocus="true"/>
                <form:errors path="price"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-warning btn-block" type="submit">Create</button>
        <br>
    </form:form>
    <h3><a href="${contextPath}/books" class="btn btn btn-danger">List Books</a></h3>
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
