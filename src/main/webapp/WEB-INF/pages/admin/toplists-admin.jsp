<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../layouts/taglib.jsp" %>


    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Добавить список
    </button>

    <form:form commandName="toplist" cssClass="form-horizontal">
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
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label">Title:</label>

                            <div class="col-sm-8">
                                <form:input path="title" cssClass="form-control"/>
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


    <br />

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Список</th>
            <th>Действие</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${toplists}" var="list">
            <tr>
                <td>
                    <a href='<spring:url value="/admin/toplists/${list.title}.html"/>'>
                        <c:out value="${list.name}"/> </a>
                </td>

                    <td>
                        <a href='<spring:url value="/admin/toplists/rename/${list.id}.html" />'
                           class="btn btn-info triggerRename">
                            Переименовать</a>
                    </td>

                    <td>
                        <a href='<spring:url value="/admin/toplists/remove/${list.id}.html" />'
                           class="btn btn-danger triggerRemove">
                            Удалить </a>
                    </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <!-- Modal Remove-->
    <div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Удалить список</h4>
                </div>
                <div class="modal-body">
                    Вы уверены что хотите удалить выбранный список?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                    <a href="" class="btn btn-danger removeBtn">Удалить</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalRename" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Переименовать список</h4>
                </div>

                <form role="form" class="form-horizontal" action="" method="post">
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Название: </label>

                            <div class="col-sm-10">
                                <input id="test" type="text" name="name" class="form-control"/>
                            </div>
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                        <input type="submit" class="btn btn-primary" value="Сохранить"/>
                    </div>

                </form>
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
            $(".triggerRename").click(function (e) {
                e.preventDefault();
                $("#modalRename .form-horizontal").attr("action", $(this).attr("href"));
                $("#modalRename").modal();
            });
        });
    </script>