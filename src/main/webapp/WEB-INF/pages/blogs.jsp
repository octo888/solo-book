<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<security:authorize access="isAnonymous()">
    <div class="alert alert-info">Для того, что бы добавить собственную рецензию, зарегистрируйтесь и зайдите в свой
        профиль
    </div>
</security:authorize>

<div class="row">
    <c:forEach items="${blogs}" var="item">
        <div class="list-group">
            <a href="<spring:url value="/blogs/${item.id}.html"/>" class="list-group-item">
                <h4 class="list-group-item-heading">${item.name}</h4>
                <h5 class="list-group-item-heading">${item.publishedDate}</h5>
                <h5 class="list-group-item-heading"><i>${item.user.nickName}</i></h5>
                <p class="list-group-item-text hideOverflow">${item.description}</p>

            </a>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <br/>
                <h5 class="list-group-item-heading"><a href='<spring:url value="/blogs/remove/${item.id}.html" />'
                                                       class="pull-right triggerRemove">
                    Удалить </a></h5>
                <br/>
            </security:authorize>
        </div>
    </c:forEach>
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
                <li class="${current == active ? 'active' : '' }"><a href="/blogs/page/${i}.html">${i}</a></li>
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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Удалить категорию</h4>
            </div>
            <div class="modal-body">
                Вы уверены что хотите удалить данную запись?
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

