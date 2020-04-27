<%--
  Created by IntelliJ IDEA.
  User: Josue
  Date: 4/7/2020
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Josue Website</title>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
    <!-- Third party plugin CSS-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="styles.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index.jsp">ONLINE BANK</a><button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto my-2 my-lg-0">
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="index.jsp">Log In</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="About.jsp">About The Project</a></li>

            </ul>
        </div>
    </div>
</nav>

<header>
    <header class="masthead">
        <div class="container h-100">
            <div class="row h-100 align-items-center justify-content-center text-center">
                <div class="col-lg-10 align-self-end">
                    <div class="alert text-white">
                        <strong>${message}</strong>
                    </div>
                    <h1 class="text-uppercase text-white font-weight-bold">Create A New Account</h1>
                    <hr class="divider my-4" />
                </div>
                <div class="col-lg-8 align-self-baseline">
                    <p class="text-white-75 ">Please fill up with your information</p>
                    <p class="text-white-75">SIGN UP</p>
                    <form action="register" method="post">
                        <input class="form-control " id="InputUsername" placeholder="Username.." type="text" name="username">
                        <hr class="dividerfinal"/>
                        <input class="form-control " id="InputEmail" placeholder="Email.." type="text" name="email">
                        <hr class="dividerfinal"/>
                        <input class="form-control " id="InputPassword" placeholder="Password.." type="password" name="password">
                        <hr class="dividerfinal"/>
                        <input class="btn btn-primary btn-xl js-scroll-trigger" type="submit" value="Create Account">
                    </form>
                </div>
            </div>
        </div>
    </header>
</header>

</body>
</html>
