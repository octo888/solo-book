<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>


<div class="row">
    <div class="media">

        <div class="col-sm-2">
            <div class="media-left thumbnail" id="book-img">
                <a href="/image/${book.image.id}.html" target="_blank">
                    <img src="/image/${book.image.id}.html" height="300" width="200" align="center"
                         class="img-responsive">
                </a>

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

            <p><c:out value="${book.description}"/></p>
        </div>

    </div>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <form role="form" class="form-inline" action="/${book.id}.html" method="post" style="max-width:150px">
            <div class="form-group">
                <label for="key">Позиция</label>
                <input name="key" id="key" type="number" class="form-control" min=1/>
            </div>

            <div class="form-group">
                <label for="selectTopList">Выберите список</label>

                <form:select path="toplists" name="selectTopList" cssClass="form-control">
                    <form:option value="NONE" label="--- Select ---"/>
                    <form:options items="${toplists}"/>
                </form:select>

            </div>

            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Добавить">
            </div>
        </form>
    </security:authorize>

</div>


