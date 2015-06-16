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
                <h4>Ярослав Гашек</h4>
            </div>
            <!-- end carousel caption -->
        </div>
        <!-- end item -->
    </div>
    <!-- end carousel-inner -->
</div>
<!-- end carousel slide -->

<div class="row" id="features">

    <%--@elvariable id="categories" type="java.util.List"--%>
    <c:forEach items="${categories}" var="category" >
        <div class="col-sm-3 feature">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title">${category.name}</h3>
                </div>
                <!-- end panel-heading -->

                <img src="resources/images/features/${category.title}.jpg" alt="${category.name}">


                <a href="<spring:url value="/category/${category.title}.html" /> "  class="btn btn-info btn-block">Открыть</a>

            </div>
            <!-- end panel -->
        </div>
        <!-- end col-sm-3 -->

    </c:forEach>

</div>
<!-- end #features -->

<div class="row" id="moreInfo">
    <div class="col-sm-6">
        <h3>Лучший книжный магазин Киева, по версии нашего сайта</h3>

        <div class="tabbable">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab">Section 1</a></li>
                <li><a href="#tab2" data-toggle="tab">Section 2</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="tab1">
                    <h4><span class="glyphicon glyphicon-map-marker"></span>Читай-город
                        <small>в первом Дрим-Тауне</small>
                    </h4>

                    <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d4249.257029723502!2d30.501406958876927!3d50.50887620150562!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1z0LTRgNC40Lwg0YLQsNGD0L0!5e1!3m2!1sru!2sua!4v1421352512391"
                            width="100%" height="300" frameborder="0" style="border:0"></iframe>

                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <!-- end tab-pane -->

                <div class="tab-pane" id="tab2">
                    <h4>A Left Floated Picture
                        <small>Using Placehold.it</small>
                    </h4>

                    <img src="http://placehold.it/140" class="thumbnail pull-left">

                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                    <hr>

                    <a href="#myModal" role="button" class="btn btn-warning" data-toggle="modal"><span
                            class="glyphicon glyphicon-hand-up"></span>Click for a modal window</a>

                    <div class="modal fade" id="myModal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" data-dismiss="modal">&times;</button>

                                    <h4 class="modal-title">A Modal Window</h4>
                                </div>
                                <!-- end modal-header -->

                                <div class="modal-body">
                                    <h4>Text in modal</h4>

                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                                    <h4>Popovers in modal</h4>
                                    <a href="#" class="btn btn-danger pop" data-toggle="popover" data-placement="top"
                                       data-original-title="You clicked it!" data-content="I knew you would.">Dont click
                                        this button</a>

                                    <h4>Tooltips in modal</h4>
                                    <a href="" data-original-title="Tooltip" rel="tooltip">This link</a> should have a
                                    tooltip, and so should <a href="#" data-original-title="Woohoo!" rel="tooltip">this
                                    one</a>!

                                    <hr>

                                    <p>
                                        <small class="text-muted">This form doesnt do anything</small>
                                    </p>

                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label" for="inputName">Name</label>

                                            <div class="col-lg-10">
                                                <input class="form-control" id="inputName" placeholder="Name"
                                                       type="text">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-lg-2 control-label" for="inputEmail">Email</label>

                                            <div class="col-lg-10">
                                                <input class="form-control" id="inputEmail" placeholder="Email"
                                                       type="email">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-lg-2 control-label" for="inputMessage">Message</label>

                                            <div class="col-lg-10">
                                                <textarea class="form-control" id="inputMessage" placeholder="Message"
                                                          rows="3"></textarea>
                                                <button class="btn btn-success pull-right" type="submit">Send!</button>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                                <!-- end modal-body -->

                                <div class="modal-footer">
                                    <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
                                    <button class="btn btn-primary" type="button">Save changes</button>
                                </div>
                                <!-- end modal-footer -->

                            </div>
                            <!-- modal-content -->
                        </div>
                        <!-- modal-dialog -->
                    </div>
                    <!-- end myModal -->

                </div>
                <!-- end tab pane -->
            </div>
            <!-- end tab-content -->
        </div>
        <!-- end tabbable -->
    </div>
    <!-- end col-sm-6 -->

    <div class="col-sm-6">
        <h3>Новости Книжного Мира</h3>

        <div class="list-group">
            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Kale</h4>

                <p class="list-group-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </a>

            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Carrots</h4>

                <p class="list-group-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </a>

            <a href="#" class="list-group-item">
                <h4 class="list-group-item-heading">Meat</h4>

                <p class="list-group-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </a>
        </div>
        <!-- end list-group -->

        <h5>A small heading</h5>

        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    </div>
    <!-- end col-sm-6 -->
</div>
<!-- end moreInfo -->

<div class="row" id="sm-carousel">
    <div class="col-12" id="wrap-sm-carousel">
        <div class="col-2"><a href="#" id="previous"><img src="/resources/images/previous.png"></a></div>
        <div class="col-2"><a href=""><img id="imgb1" src="" class="thumbnail img-responsive" align="middle"></a></div>
        <div class="col-2"><a href=""><img id="imgb2" src="" class="thumbnail img-responsive"></a></div>
        <div class="col-2"><a href=""><img id="imgb3" src="" class="thumbnail img-responsive"></a></div>
        <div class="col-2"><a href=""><img id="imgb4" src="" class="thumbnail img-responsive"></a></div>
        <div class="col-2"><a href="#" id="next"><img src="/resources/images/next.png"></a></div>
    </div>
</div>
<!-- end sm-carousel -->

		