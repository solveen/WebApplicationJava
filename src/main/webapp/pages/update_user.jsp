<%--
  Created by IntelliJ IDEA.
  User: Solveen
  Date: 3/30/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">
<body>


<html>
<head>
    <title>Update User</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<%@ include file="../include/navbar.jsp" %>
<body class="img js-fullheight" style="background-image: url(images/bg4.jpg);">
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Update users here</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <h3 class="mb-4 text-center">Update users details</h3>
                    <form action="User?page=UpdateUsers&id=${user.id}" method="Post">
                        <input type="hidden" name="id" value="${user.id}">
                        <div class="form-group">

                            <input type="text" class="form-control" value="${user.user_name}" placeholder="Username" name="user_name" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" value="${user.full_name}" placeholder="Full name" name="full_name" required>
                        </div>
                        <div class="form-group">
                            <input id="password-field" type="password" value="${user.password}" class="form-control" placeholder="Password" name="password"
                                   required>
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary submit px-3">Update user</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</section>




<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>


</body>
</html>