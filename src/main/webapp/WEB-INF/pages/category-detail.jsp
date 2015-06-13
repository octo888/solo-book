
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<div class="row">

    <a href='<spring:url value="/categories/${category.id}/addbook.html"  />' class="btn btn-primary" >Добавить книгу</a>

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
                    <a href='<spring:url value="/users/${user.id}.html"/>'>
                        <c:out value="${book.name}" /> </a>
                </td>
                <td>
                    <a href='<spring:url value="/users/remove/${category.id}.html"  />' class="btn btn-danger triggerRemove">
                        Удалить </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>