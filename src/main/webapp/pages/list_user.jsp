<%--
  Created by IntelliJ IDEA.
  User: Solveen
  Date: 3/30/2022
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Lists</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">
</head>
<body class="img js-fullheight" style="background-image: url(images/bg3.png);">

<%@ include file="../include/navbar.jsp" %>
<br>

<div class="container">
    <div class="row">
        <div class="mx-auto" style="width: 200px;">
            <button type="button" class="btn btn-info px-3 button-i" onclick="window.location.href='User?page=addNewUsers';">
                Add User
            </button>
        </div>
    </div>
</div>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-12">

            <table class="zui-table zui-table-rounded">

                <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">User Name</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Password</th>
                    <th scope="col">Action</th>

                </tr>
                </thead>
                <%--        <%--%>
                <%--            ArrayList<User> user = (ArrayList<User>) request.getAttribute("UserTable");--%>
                <%--            for (User u: user)--%>
                <%--            {--%>
                <%--        %>--%>
                <tbody>
                <%--        <tr>--%>
                <%--            <td><%=u.getId()%></td>--%>
                <%--            <td><%=u.getUser_name()%></td>--%>
                <%--            <td><%=u.getFull_name()%></td>--%>
                <%--            <td><%=u.getPassword()%></td>--%>

                <%--        </tr>--%>

                <c:forEach items="${UserTable}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.user_name}</td>
                        <td>${user.full_name}</td>
                        <td>${user.password}</td>

                        <td>
                            <button type="button" class="btn btn-success px-3 button-i"
                                    onclick="window.location.href='User?page=UserDetails&id=${user.id}';">
                               User Details
                            </button>
                            &nbsp;&nbsp;&nbsp;&nbsp;

                        </td>
                    </tr>
                </c:forEach>

                <%--          <%}%>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="../include/footer.jsp" %>
<script src="js/jquery.min.js"></script>
<script src=js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>