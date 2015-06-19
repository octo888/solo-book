<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../layouts/taglib.jsp" %>

<div class="row">
    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Категория</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>
                    <a href='<spring:url value="/admin/categories/${category.title}.html"/>'>
                        <c:out value="${category.name}"/> </a>
                </td>
                <td>
                    <a href='<spring:url value="/admin/categories/remove/${category.id}.html" />'
                       class="btn btn-danger triggerRemove">
                        Удалить </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Добавить категорию
    </button>

    <form:form commandName="category" cssClass="form-horizontal">
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Заполните форму</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Название:</label>

                            <div class="col-sm-8">
                                <form:input path="name" cssClass="form-control"/>
                                <form:errors path="name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Title:</label>

                            <div class="col-sm-8">
                                <form:input path="title" cssClass="form-control"/>
                                <form:errors path="title"/>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        <input type="submit" class="btn btn-primary" value="Сохранить"/>
                    </div>
                </div>
            </div>
        </div>
        <!-- end Modal -->
    </form:form>
</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Удалить категорию</h4>
            </div>
            <div class="modal-body">
                Вы уверены что хотите удалить выбранную категорию?
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