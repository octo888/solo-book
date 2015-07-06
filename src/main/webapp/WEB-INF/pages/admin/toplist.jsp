<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../layouts/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Список</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${toplist}" var="list">
        <tr>
            <td>
                <a href='<spring:url value="/admin/toplist/${list.title}.html"/>'>
                    <c:out value="${list.name}"/> </a>
            </td>
            <td>
                <a href='<spring:url value="/admin/toplist/remove/${list.id}.html" />'
                   class="btn btn-danger triggerRemove">
                    Удалить </a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
