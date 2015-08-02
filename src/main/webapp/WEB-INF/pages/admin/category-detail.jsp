
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../../layouts/taglib.jsp" %>

<div class="row">

    <a href='<spring:url value="/admin/addbook.html"  />' class="btn btn-primary" >Добавить книгу</a>

    <br/>
    <br/>
    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Название</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>
                    <a href='<spring:url value="/${book.id}.html"/>'>
                        <c:out value="${book.name}" /> </a>
                </td>
                <td>
                    <a href='<spring:url value="/admin/remove/book/${book.id}.html"  />' class="btn btn-danger triggerRemove">
                        Удалить </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

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
                <li class="${current == active ? 'active' : '' }">
                    <a href="/admin/categories/${category.title}/page/${i}.html">${i}</a>
                </li>
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