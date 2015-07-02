
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    New blog
</button>


<form:form commandName="blog" cssClass="form-horizontal blogForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">New blog</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Заголовок:</label>
                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control" />
                            <form:errors path="name" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Текст:</label>
                        <div class="col-sm-10">
                            <form:input path="description" cssClass="form-control" />
                            <form:errors path="description" />
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save" />
                </div>
            </div>
        </div>
    </div>
</form:form>

<br /><br />

<script type="text/javascript">
    $(document).ready(function() {
        $(".triggerRemove").click(function(e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
        $(".blogForm").validate(
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




            <table class="table table-bordered table-hover table-striped">
                <thead>
                <tr>
                    <th>date</th>
                    <th>item</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.blogs}" var="item">
                    <tr>
                        <td><c:out value="${item.publishedDate}" /></td>
                        <td>
                            <strong>
                                <a href="<%--<c:out value="${item.link}" />--%>" target="_blank">
                                    <c:out value="${item.name}" />
                                </a>
                            </strong>
                            <br />
                                ${item.description}
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