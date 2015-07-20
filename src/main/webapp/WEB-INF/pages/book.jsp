<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>


<div class="row" >
    <div class="media" >

        <div class="media-left" >
            <img src="http://placehold.it/100x150" class="media-object pull-left">
        </div>
            <div class="media-heading">
                <h4><b>Название: </b> <c:out value="${book.name}"/></h4>
                <h4><b>Автор: </b><c:out value="${book.authorName}"/></h4>
            </div>

        <div class="media-body" >
            <h4><b>Описание:</b></h4> <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <form role="form" action="/category/${category.title}/rate/${book.id}.html" class="form-inline">
            <div class="form-group">
                <input id="input-id" type="number" name="rate" min=0 max=5 step=1 data-size="xs" data-rtl="false">
            </div>
            <div class="form-group">
                <input type="submit" value="Rate">
            </div>
        </form>
    </div>

    <c:forEach items="${book.rates}" var="rate">
        <h4>${rate}</h4>
    </c:forEach>

    <h4>${book.rate}</h4>
</div>
