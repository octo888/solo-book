<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../layouts/taglib.jsp" %>


<form role="form" enctype="multipart/form-data" class="form-horizontal" action="/admin/day-image/add.html"
      method="post">

    <div class="form-group">
        <label for="imageName" class="col-sm-2 control-label">Подпись к картинке:</label>

        <div class="col-sm-8">
            <input type="text" id="imageName" class="form-control" name="name" placeholder="Подпись">
        </div>
    </div>


    <div class="form-group">
        <label for="dayImage" class="col-sm-2 control-label">Изображение:</label>

        <div class="col-sm-8">
            <input class="form-control" type="file" id="dayImage" name="image"></div>
    </div>
    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" class="btn btn-primary pull-right" value="Добавить">
        </div>
    </div>
</form>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Название</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dayImage}" var="day">
        <tr>
            <td>
                <a href='<spring:url value="/image/${day.image.id}.html"/>' target="_blank">
                    <c:out value="${day.name}"/> </a>
            </td>
            <td>
                <a href='<spring:url value="/admin/day-image/remove/${day.id}.html"  />'
                   class="btn btn-danger triggerRemove">
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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Удалить картинку</h4>
            </div>
            <div class="modal-body">
                Вы уверены что хотите удалить изображение?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <a href="" class="btn btn-danger removeBtn" >Удалить</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $(".triggerRemove").click(function(e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        });
    });
</script>