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
<h3 class="h3">Back to the welcome <a href="${contextPath}/welcome">Back</a></h3>
<br/>
<br/>


<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <a href="${contextPath}/create-book" class="btn btn btn-success pull-right"><b>+</b> Add new book.</a>
            <h3 class="h3 center-block">Book List</h3>
        <c:if test="${!empty listBooks}">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><a href="${contextPath}/book-info/${book.id}" target="_blank">${book.bookTitle}</a></td>
                <td>${book.bookAuthor}</td>
                <td>${book.price}</td>
                <td class="text-center">
                    <a href="<c:url value='${contextPath}/edit/${book.id}'/>" class='btn btn-info btn-xs'>Edit</a>
                    <a href="<c:url value='${contextPath}/delete/${book.id}'/>" class="btn btn-danger btn-xs"> Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
       </c:if>
    </div>
</div>

<!-- scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

