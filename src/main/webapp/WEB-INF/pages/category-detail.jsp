
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<div class="row">

    <a href='<spring:url value="/categories/${category.title}/addbook.html"  />' class="btn btn-primary" >Добавить книгу</a>

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Название</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${category.books}" var="book">
            <tr>
                <td>
                    <a href='<spring:url value="/category/${category.title}/${book.id}.html"/>'>
                        <c:out value="${book.name}" /> </a>
                </td>
                <td>
                    <a href='<spring:url value="/categories/${category.title}/remove/book/${book.id}.html"  />' class="btn btn-danger triggerRemove">
                        Удалить </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Удалить книгу</h4>
            </div>
            <div class="modal-body">
                Вы уверены что хотите удалить книгу?
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