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
                            },
                            url: {
                                required: true,
                                url: true
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


    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Рецензия</th>
            <th>Дата публикации</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user.blogs}" var="item">
            <tr>

                <td>
                    <strong>
                        <a href="" target="_blank">
                            <c:out value="${item.name}"/>
                        </a>
                    </strong>
                </td>

                <td><c:out value="${item.publishedDate}"/></td>

                <td>
                    <a href='<spring:url value="/blogs/remove/${item.id}.html"  />' class="btn btn-danger triggerRemove">
                        Удалить </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <!-- Modal -->
    <div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
                </div>
                <div class="modal-body">
                    Really remove?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <a href="" class="btn btn-danger removeBtn">Remove</a>
                </div>
            </div>
        </div>
    </div>