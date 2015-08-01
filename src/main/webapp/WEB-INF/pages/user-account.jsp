    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
    <%@ include file="../layouts/taglib.jsp" %>

    <h3 class="text-center">Добавить рецензию</h3>

    <form:form commandName="blog" cssClass="form-horizontal blogForm">

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Заголовок:</label>

            <div class="col-sm-8">
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name"/>
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Текст:</label>

            <div class="col-sm-8">
                <form:textarea path="description" cssClass="form-control" rows="7"/>
                <form:errors path="description"/>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-10">
                <input type="submit" value="Сохранить" class="btn btn-lg btn-primary pull-right"/>
            </div>
        </div>

    </form:form>

    <br/><br/>

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Рецензия</th>
            <th>Дата публикации</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${blogs}" var="item">
            <tr>

                <td>
                    <strong>
                        <a href='<spring:url value="/blogs/${item.id}.html"  />' target="_blank">
                            <c:out value="${item.name}"/>
                        </a>
                    </strong>
                </td>

                <td><c:out value="${item.getDateAsString()}"/></td>

                <td>
                    <a href='<spring:url value="/blogs/remove/${item.id}.html"  />' class="btn btn-danger triggerRemove">
                        Удалить </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div align="center">
        <nav>
            <ul class="pagination">
                <%--<li>
                    <a href="/blogs/page/${current - 1}.html" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>--%>

                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:set var="active" value="${i}"/>
                    <li class="${current == active ? 'active' : '' }"><a href="/account/page/${i}.html">${i}</a></li>
                </c:forEach>

                <%--<li>
                    <a href="/blogs/page/${current + 1}.html" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>--%>
            </ul>
        </nav>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Удалить запись</h4>
                </div>
                <div class="modal-body">
                    Удалить?
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
            $(".blogForm").validate(
                    {
                        rules: {
                            name: {
                                required: true,
                                minlength: 1
                            }
                        },
                        highlight: function (element) {
                            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                        },
                        unhighlight: function (element) {
                            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                        }
                    }
            );
        });
    </script>