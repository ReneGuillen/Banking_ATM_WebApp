<%
    session.getAttribute("userName");
    %>
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
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="Home?userName=${userName}">Home</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="Transfer.jsp?userName=${userName}">Transfer</a></li>
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
                    <h1 class="text-uppercase text-white font-weight-bold">Apply For A New Loan</h1>
                    <hr class="divider my-4" />
                </div>
                <div class="col-lg-8 align-self-baseline">
                    <p class="text-white-75 ">Please fill up with your personal information</p>
                    <p class="text-white-75">Loan</p>
                    <form action="Home" method="post">
                        <input type="hidden" value="${userName}" name="userName">
                        <input class="form-control " id="InputFullName" placeholder="Full Name.." type="text" name="name">
                        <hr class="dividerfinal"/>
                        <input class="form-control " id="InputUsername" placeholder="Username.." type="text" name="userName">
                        <hr class="dividerfinal"/>
                        <input class="form-control " id="InputCredit" placeholder="Credit Score >= 700.." type="text" name="Credit Score">
                        <hr class="dividerfinal"/>
                        <input class="form-control " id="InputAmount" placeholder="Amount.." type="text" name="Amount">
                        <hr class="dividerfinal"/>
                        <input class="btn btn-primary btn-xl js-scroll-trigger" type="submit" value="Apply Now!" name="option">
                    </form>
                </div>
            </div>
        </div>
    </header>
</header>

</body>
</html>
