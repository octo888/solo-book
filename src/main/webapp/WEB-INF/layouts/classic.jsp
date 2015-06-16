<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>

    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


    <!-- From resources -->

    <meta name="description" content="">

    <!-- Mobile viewport optimized -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/includes/css/bootstrap-glyphicons.css"
          rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/includes/css/styles.css" rel="stylesheet">


    <script src="${pageContext.request.contextPath}/resources/includes/js/modernizr-2.6.2.min.js"></script>

    <script src="http://code.jquery.com/jquery.js"></script>
    <script>
        window.jQuery
        || document
                .write('<script src="/resources/includes/js/jquery-1.8.2.min.js"><\/script>')
    </script>
    <!-- Bootstrap JS -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <!-- Custom JS -->
    <script src="${pageContext.request.contextPath}/resources/includes/js/script.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

    <!-- end resources -->


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
           prefix="tilesx" %>

<tilesx:useAttribute name="current"/>

<div class="container" id="main">

    <div class="navbar navbar-fixed-top" id="topNavbar" role="navigation">
        <div class="container">

            <button class="navbar-toggle"
                    data-target=".navbar-responsive-collapse" data-toggle="collapse"
                    type="button">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="index.html"><img
                    src="/resources/images/logo.png" alt="Your Logo"></a>

            <div class="nav-collapse collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav">
                    <li class="${current == 'index' ? 'active' : '' }"><a
                            href="<spring:url value="/index.html"></spring:url>">Главная</a></li>

                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown">ТОП<strong class="caret"></strong></a>

                        <ul class="dropdown-menu">
                            <li><a href="#">Топ Месяца</a></li>

                            <li><a href="#">Топ 100</a></li>

                            <li><a href="#">Хиты продаж</a></li>
                        </ul>
                        <!-- end dropdown menu --></li>

                    <li><a href="#">Рецензии</a></li>

                    <security:authorize access="hasRole('ROLE_ADMIN')" >

                        <li class="${current == 'users' ? 'active' : '' }"><a
                                href='<spring:url value="/users.html"></spring:url>'>Пользователи</a></li>

                        <li class="${current == 'categories' ? 'active' : '' }"><a
                                href='<spring:url value="/categories.html"></spring:url>'>Категории</a></li>

                        <li class="${current == 'categories' ? 'active' : '' }"><a
                                href='<spring:url value="/addbook.html"></spring:url>'>Добавить книгу</a></li>

                    </security:authorize>

                </ul>

                <form class="navbar-form pull-left">
                    <input type="text" class="form-control"
                           placeholder="Поиск..." id="searchInput">

                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
                <!-- navbar form -->

                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>МойПрофиль<strong
                            class="caret"></strong></a>

                        <ul class="dropdown-menu">
                            
                            <security:authorize access="! isAuthenticated()" >
                                <li><a href="<spring:url value="/login.html">
                                </spring:url>">Войти</a></li>

                                <li class="${current == 'register' ? 'active' : '' }"><a href="<spring:url value="/register.html">
                                </spring:url>">Регистрация</a></li>

                            </security:authorize>

                            <security:authorize access="isAuthenticated()" >
                                <li><a href="<spring:url value="/account.html" />">Профиль</a></li>
                                <li><a href="<spring:url value="/logout" />" id="logout"><span
                                        class="glyphicon glyphicon-off"></span>Выйти</a></li>
                            </security:authorize>
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

    <div class="wrapBody">
        <tiles:insertAttribute name="body"/>
    </div>



</div> <!-- end container #main -->

<tiles:insertAttribute name="footer"/>

</body>
</html>