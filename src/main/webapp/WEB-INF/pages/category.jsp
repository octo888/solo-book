<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

<div class="row" id="features" >

    <c:forEach items="${category.books}" var="book">
        <div class="col-sm-3 feature">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title">${book.name}</h3>
                </div>
                <!-- end panel-heading -->

                <a href="/index.html" target="_blank" class="btn btn-info btn-block" >Открыть</a>

            </div>
            <!-- end panel -->
        </div>
        <!-- end col-sm-3 -->
    </c:forEach>
</div>
<!-- end row -->

