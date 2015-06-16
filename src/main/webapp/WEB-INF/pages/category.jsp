<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<div class="row" id="categoryBooks">

    <c:forEach items="${category.books}" var="book">

        <div class="col-sm-2">
            <div class="panel" id="categoryPanel">

                <a href=""><img src="http://placehold.it/100x150" class="img-responsive thumbnail" alt="${book.name}"></a>

                <!--<div class="panel-footer">-->
                <h5 data-toggle="tooltip" data-placement="right" title="${book.name}">
                    <a href="<spring:url value="/category/${category.title}/${book.id}.html"/>">${book.name}</a></h5>
                <!--</div>-->
            </div>
        </div>
        <!-- end col-sm-2 -->

    </c:forEach>

</div>
<!-- end row -->

