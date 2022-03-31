<%--
  Created by IntelliJ IDEA.
  User: Solveen
  Date: 3/30/2022
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark shadow-5-strong">
    <a class="navbar-brand" href="#">Levi</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="User?page=goToDashboard">Dashboard <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="User?page=UserLists">Users List</a>
            </li>
        </ul>
    </div>
    <div class="navbar-nav">
        <a class="nav-link" href="User?page=logoutUsers">Log out</a>
    </div>
</nav>
</body>
</html>
