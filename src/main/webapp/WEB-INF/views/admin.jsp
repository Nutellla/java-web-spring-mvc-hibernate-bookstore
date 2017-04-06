<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/login-style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/for-books.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="row">
              <div class="col-md-9">

                  <form id="logoutForm" method="post" action="${contextPath}/logout">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  </form>

                  <h2 class="h2">Admin Page ${pageContext.request.userPrincipal.name}
                      | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
                  </h2>

                  <div class="panel panel-primary">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-list"></span>Sortable Lists
                            <div class="pull-right action-buttons">
                                <div class="btn-group pull-right">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        <span class="glyphicon glyphicon-cog" style="margin-right: 0px;"></span>
                                    </button>
                                    <ul class="dropdown-menu slidedown">
                                        <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>Edit</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-trash"></span>Delete</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <c:if test="${!empty listUsersForm}">
                            <c:forEach items="${listUsersForm}" var="user">

                            <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <div class="checkbox">
                                        <input type="checkbox" id="checkbox" />
                                        <label for="checkbox">
                                            ${user.username}
                                        </label>
                                    </div>
                                    <div class="pull-right action-buttons">
                                        <a href="#"><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a href="#" class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                                    </div>
                                </li>
                            </ul>
                        </div>

                            </c:forEach>
                        </c:if>

                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-md-6">
                                    <h6>
                                        Total Count <span class="label label-info">2</span></h6>
                                </div>
                                <div class="col-md-6">
                                    <ul class="pagination pagination-sm pull-right">
                                        <li class="disabled"><a href="javascript:void(0)"><<</a></li>
                                        <li class="active"><a href="javascript:void(0)">1 <span class="sr-only">(current)</span></a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="javascript:void(0)">>></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                  <a href="${contextPath}/books" class="btn btn btn-danger pull-right">Books</a>
                  <a href="${contextPath}/welcome" class="btn btn btn-info pull-right">Log out with Admin Panel</a>
              </div>
            </div>
        <!-- end if auto login -->
    </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>