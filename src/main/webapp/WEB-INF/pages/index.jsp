<%@ include file="../layouts/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="carousel slide" id="bigCarousel">

    <!-- indicators -->
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#bigCarousel"></li>
        <li data-slide-to="1" data-target="#bigCarousel"></li>
        <li data-slide-to="2" data-target="#bigCarousel"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active" id="slide1">
            <div class="carousel-caption">
                <p>Good friends, good books and a sleepy conscience: this is
                    the ideal life.</p>
                <h4>Mark Twain</h4>
            </div>
            <!-- end carousel caption -->
        </div>
        <!-- end item -->

        <div class="item" id="slide2">
            <div class="carousel-caption">
                <p>Мы любим людей, которым мы сделали добро, а не тех, кто
                    сделал его нам. Этот закон давно поняли женщины и удачно его
                    используют.</p>
                <h4>Виктор Пелевин</h4>
            </div>
            <!-- end carousel caption -->
        </div>
        <!-- end item -->

        <div class="item" id="slide3">
            <div class="carousel-caption">
                <p>В сумасшедшем доме каждый мог говорить все, что взбредет
                    ему в голову, словно в парламенте.</p>
                <h4>Бравый солдат Швейк</h4>
            </div>
            <!-- end carousel caption -->
        </div>
        <!-- end item -->
    </div>
    <!-- end carousel-inner -->
</div>
<!-- end carousel slide -->

<div class="row" id="features">

    <c:forEach items="${globalCategories}" var="category">
        <div class="col-sm-3 feature">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title"><c:out value="${category.name}"/></h3>
                </div>
                <!-- end panel-heading -->

                <img src="${pageContext.request.contextPath}/resources/images/features/${category.title}.jpg" alt="${category.name}">


                <a href="<spring:url value="/category/${category.title}.html" /> " class="btn btn-info btn-block">Открыть</a>

            </div>
            <!-- end panel -->
        </div>
        <!-- end col-sm-3 -->

    </c:forEach>

</div>
<!-- end #features -->

<div class="row" id="moreInfo">
    <div class="col-sm-6">
        <h3>Рекомендуемый для посещения книжный магазин в Киеве</h3>

        <div class="tabbable">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab">Section 1</a></li>
                <%--<li><a href="#tab2" data-toggle="tab">Section 2</a></li>--%>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="tab1">
                    <h4><span class="glyphicon glyphicon-map-marker"></span>Буква
                        <small>в первом Дрим-Тауне</small>
                    </h4>

                    <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d4249.257029723502!2d30.501406958876927!3d50.50887620150562!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1z0LTRgNC40Lwg0YLQsNGD0L0!5e1!3m2!1sru!2sua!4v1421352512391"
                            width="100%" height="300" frameborder="0" style="border:0"></iframe>

                    <p>В этом месте я еще не придумал контент, который бы мне нравился
                        и выглядел адекватно на первой странице</p>

                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <!-- end tab-pane -->

            </div>
            <!-- end tab-content -->
        </div>
        <!-- end tabbable -->
    </div>
    <!-- end col-sm-6 -->

    <div class="col-sm-6">
        <h3 align="middle">News Of The Book World</h3>

        <c:forEach items="${news}" var="news">
            <div class="list-group">
                <a href="${news.link}" class="list-group-item" target="_blank">
                    <h4 class="list-group-item-heading">${news.title}</h4>
                    <small>${news.publishedDate}</small>
                    <p class="list-group-item-text">${news.description}</p>
                </a>
            </div>
        </c:forEach>
        <!-- end list-group -->
        <a href="<spring:url value='/news.html'/> " class="pull-right">more news...</a>
    </div>
    <!-- end col-sm-6 -->
</div>
<!-- end moreInfo -->

<div class="row" id="sm-carousel">
    <h3 align="middle" style="color: #999999">Топ Месяца</h3>
    <div class="col-12" id="wrap-sm-carousel">
        <div class="col-2"><a href="#" id="previous"><img src="${pageContext.request.contextPath}/resources/images/previous.png"></a></div>
        <div class="col-2"><a href="" id="link1"><img id="img1" src="" class="thumbnail img-responsive" align="middle"></a>
        </div>
        <div class="col-2"><a href="" id="link2"><img id="img2" src="" class="thumbnail img-responsive"></a></div>
        <div class="col-2"><a href="" id="link3"><img id="img3" src="" class="thumbnail img-responsive"></a></div>
        <div class="col-2"><a href="" id="link4"><img id="img4" src="" class="thumbnail img-responsive"></a></div>
        <div class="col-2"><a href="#" id="next"><img src="${pageContext.request.contextPath}/resources/images/next.png"></a></div>
    </div>
</div>
<!-- end sm-carousel -->


<script type="text/javascript">
    $(document).ready(function () {

        var images = ${pluginImages};
        var links = ${pluginLinks};
        var currentBook = 0;

        $("#img1").attr("src", images[currentBook]);
        $("#img2").attr("src", images[currentBook + 1]);
        $("#img3").attr("src", images[currentBook + 2]);
        $("#img4").attr("src", images[currentBook + 3]);

        $("#link1").attr("href", links[currentBook]);
        $("#link2").attr("href", links[currentBook + 1]);
        $("#link3").attr("href", links[currentBook + 2]);
        $("#link4").attr("href", links[currentBook + 3]);


        $("#previous").click(function () {
            if (currentBook != 0) {
                currentBook--;
                $("#img1").attr("src", images[currentBook]);
                $("#img2").attr("src", images[currentBook + 1]);
                $("#img3").attr("src", images[currentBook + 2]);
                $("#img4").attr("src", images[currentBook + 3]);

                $("#link1").attr("href", links[currentBook]);
                $("#link2").attr("href", links[currentBook + 1]);
                $("#link3").attr("href", links[currentBook + 2]);
                $("#link4").attr("href", links[currentBook + 3]);
            }
            return false;
        });
        $("#next").click(function () {
            if (currentBook != images.length - 4) {
                currentBook++;
                $("#img1").attr("src", images[currentBook]);
                $("#img2").attr("src", images[currentBook + 1]);
                $("#img3").attr("src", images[currentBook + 2]);
                $("#img4").attr("src", images[currentBook + 3]);

                $("#link1").attr("href", links[currentBook]);
                $("#link2").attr("href", links[currentBook + 1]);
                $("#link3").attr("href", links[currentBook + 2]);
                $("#link4").attr("href", links[currentBook + 3]);

            }
            return false;
        });
    });
</script>
		