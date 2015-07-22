<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Список</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${toplists}" var="list">
            <tr>
                <td>
                    <a href='<spring:url value="/toplist/${list.title}.html"/>'>
                        <c:out value="${list.name}"/> </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
