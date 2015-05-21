<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>

    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


    <!-- From resources -->

    <meta name="description" content="">

    <!-- Mobile viewport optimized -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Bootstrap CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="/resources/includes/css/bootstrap-glyphicons.css"
          rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/includes/css/styles.css" rel="stylesheet">


    <script src="/resources/includes/js/modernizr-2.6.2.min.js"></script>

    <script src="http://code.jquery.com/jquery.js"></script>
    <script>
        window.jQuery
        || document
                .write('<script src="/resources/includes/js/jquery-1.8.2.min.js"><\/script>')
    </script>
    <!-- Bootstrap JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <!-- Custom JS -->
    <script src="/resources/includes/js/script.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

    <!-- end resources -->


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
           prefix="tilesx" %>

<tilesx:useAttribute name="current"/>

<div class="container" id="main">
    <div class="navbar navbar-fixed-top">
        <div class="container">

            <button class="navbar-toggle"
                    data-target=".navbar-responsive-collapse" data-toggle="collapse"
                    type="button">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="index.html"><img
                    src="resources/images/logo.png" alt="Your Logo"></a>

            <div class="nav-collapse collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.html">Главная</a></li>

                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown">ТОП<strong class="caret"></strong></a>

                        <ul class="dropdown-menu">
                            <li><a href="#">Топ Месяца</a></li>

                            <li><a href="#">Топ 100</a></li>

                            <li><a href="#">Хиты продаж</a></li>
                        </ul>
                        <!-- end dropdown menu --></li>

                    <li><a href="new.html">Новинки</a></li>

                    <li><a href="blog.html">Рецензии</a></li>
                </ul>

                <form class="navbar-form pull-left">
                    <input type="text" class="form-control"
                           placeholder="Search this site..." id="searchInput">

                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
                <!-- navbar form -->

                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>MyAccount<strong
                            class="caret"></strong></a>

                        <ul class="dropdown-menu">
                            <li><a href="#">Войти</a></li>

                            <li><a href="#">Регистрация</a></li>

                            <li class="divider"></li>

                            <li><a href="#" id="logout"><span
                                    class="glyphicon glyphicon-off"></span>Выйти</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- end nav pull right -->

            </div>
            <!-- end nav-collapse -->

        </div>
        <!-- end container -->
    </div>
    <!-- end navbar -->


    <tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>


<hr>

<tiles:insertAttribute name="footer"></tiles:insertAttribute>


</body>
</html>