<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../layouts/taglib.jsp" %>


<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Добавить новостной ресурс
</button>


<form:form commandName="newsblog" cssClass="form-horizontal newsBlogForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Новый ресурс</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Название:</label>
                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control" />
                            <form:errors path="name" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="url" class="col-sm-2 control-label">URL:</label>
                        <div class="col-sm-10">
                            <form:input path="url" cssClass="form-control" />
                            <form:errors path="url" />
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                    <input type="submit" class="btn btn-primary" value="Сохранить" />
                </div>
            </div>
        </div>
    </div>
</form:form>

</<br/><br/>

<ul class="nav nav-tabs">
    <c:forEach items="${newsblogs}" var="blog">
        <li><a href="#blog_${blog.id}" data-toggle="tab"><c:out value="${blog.name}" /></a></li>
    </c:forEach>
</ul>

<div class="tab-content">
    <c:forEach items="${newsblogs}" var="blog">
        <div class="tab-pane" id="blog_${blog.id}">
            <h1><c:out value="${blog.name}" /></h1>
            <p>

                <a href="<spring:url value="/admin/newsblog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">Удалить</a>

                <c:out value="${blog.url}" /></p>

            <table class="table table-bordered table-hover table-striped">
                <thead>
                <tr>
                    <th>date</th>
                    <th>item</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${blog.items}" var="item">
                    <tr>
                        <td><c:out value="${item.publishedDate}" /></td>
                        <td>
                            <strong>
                                <a href="<c:out value="${item.link}" />" target="_blank">
                                    <c:out value="${item.title}" />
                                </a>
                            </strong>
                            <br />
                                ${item.description}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabelRemove" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabelRemove">Удалить ресурс</h4>
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
    $(document).ready(function() {
        $('.nav-tabs a:first').tab('show'); // Select first tab
        $(".triggerRemove").click(function(e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
        $(".newsBlogForm").validate(
                {
                    rules: {
                        name: {
                            required : true,
                            minlength : 1
                        },
                        url: {
                            required : true,
                            url: true
                        }
                    },
                    highlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    });
</script>