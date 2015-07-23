<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>


<c:if test="${error == true}">
    <div class="alert alert-info">По Вашему запросу ничего не найдено</div>
</c:if>


<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Название</th>
        <th>Автор</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${result}" var="book">
        <tr>
            <td>
                <a href='<spring:url value="/${book.id}.html"/>'>
                    <c:out value="${book.name}"/> </a>
            </td>
            <td>
                <c:out value="${book.authorName}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

