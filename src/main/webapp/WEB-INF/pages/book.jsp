<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>


<div class="row">
    <div class="media">

        <div class="col-sm-2">
        <div class="media-left thumbnail" id="book-img">
            <img src="http://placehold.it/150x200">
            <div class="caption">
                <h5>Оценка: ${book.rate}</h5>
                <form role="form" action="/rate/${book.id}.html"
                      class="form-inline" style="max-width:100px">
                    <div class="input-group">

                        <input class="form-control" type="number" name="rate" min=1 max=5 step=1 data-size="xs"
                               data-rtl="false">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Go!</button>
                    </span>
                    </div>
                </form>
            </div>

        </div>
        </div>
        <div class="media-heading">
            <h4><b>Название: </b> <c:out value="${book.name}"/></h4>
            <h4><b>Автор: </b><c:out value="${book.authorName}"/></h4>
        </div>

        <div class="media-body">
            <h4><b>Описание:</b></h4>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>

    </div>


</div>
