<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<div class="row">
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>user name</th>
        <th>operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href='<spring:url value="/users/${user.id}.html"></spring:url>'>
                    <c:out value="${user.name}" /> </a>
            </td>
            <td>
                <a href='<spring:url value="/users/remove/${user.id}.html"  ></spring:url>' class="btn btn-danger triggerRemove">
                    remove </a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>