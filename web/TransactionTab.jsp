<%--
  Created by IntelliJ IDEA.
  User: Josue
  Date: 4/9/2020
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Main</title>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
    <!-- Third party plugin CSS-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="styles.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container">
        <h1 class="navbar-brand js-scroll-trigger" >Welcome ${userName}</h1>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto my-2 my-lg-0">
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="Home">Home</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="index.jsp">Log Out</a></li>
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
                        <strong>${alert}</strong>
                    </div>
                    <h1 class="text-white-balance">Your recent transactions:</h1>
                    <hr class="divider my-4" />
                </div>
                <form action="Home" method="post">
                    <input type="hidden" value="${userName}" name="userName">
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <p class="text-white-75 font-weight-bold">Enter Amount and Select Transaction: </p>
                    <hr class="divider my-4" />
                </form>
            </div>
        </div>
    </header>
</header>
</body>
</html>
