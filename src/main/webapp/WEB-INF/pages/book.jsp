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
            <h4><b>Категория: </b><c:out value="${book.category.name}"/></h4>

            <a href="<spring:url value="/account/userbooklist/${book.id}.html"/>" class="btn btn-success">
                Добавить в свой список</a>

        </div>

        <div class="media-body">
            <h4><b>Описание:</b></h4>

            <p><c:out value="${book.description}"/></p>
        </div>

    </div>

</div>

<security:authorize access="hasRole('ROLE_ADMIN')">

    <c:if test="${message eq true}">
        <div class="alert alert-danger">Книга содержится в списках:
            <c:forEach items="${lists}" var="list">
                "${list.name}",
            </c:forEach>
            Вам следует прежде удалить либо заменить ее там
        </div>
    </c:if>

    <div class="row">
        <form role="form" class="form-inline" style="margin-left: 10%" action="/${book.id}.html" method="post">
            <div class="form-group">

                <div class="col-sm-1">
                    <label for="key">Позиция в списке</label>
                </div>
                <div class="col-sm-2">
                    <input name="key" id="key" type="number" class="form-control" min=1/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1" for="selectTopList">Выберите список</label>

                <div class="col-sm-4">
                    <form:select path="toplists" name="selectTopList" cssClass="form-control">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${toplists}"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group col-sm-2">
                <input type="submit" class="btn btn-primary" value="Добавить">
            </div>
        </form>
    </div>
    <a href="/admin/remove/book/${book.id}.html" class="btn btn-danger triggerRemove">Удалить книгу</a>
    <br/>
</security:authorize>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Удалить книгу</h4>
            </div>
            <div class="modal-body">
                Вы уверены что хотите удалить книгу?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <a href="" class="btn btn-danger removeBtn">Удалить</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".triggerRemove").click(function (e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
    });
</script>

