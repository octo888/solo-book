<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../layouts/taglib.jsp" %>


<form role="form" class="form-inline"  action="/admin/toplists/${toplist.title}.html" method="post" style="max-width:200px">

    <div class="form-group">
        <label for="key">Номер</label>
        <input name="key" id="key" type="number" class="form-control" />
    </div>
    <div class="form-group">
        <label for="selectedBook">Выберите книгу</label>
        <form:select path="books" name="selectedBook" cssClass="form-control" >
            <form:option value="NONE" label="--- Select ---" />
            <form:options items="${books}" />
        </form:select>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-primary" value="Добавить">
    </div>
</form>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Номер</th>
        <th>Название</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${toplist.books}" var="book">
        <tr>
            <td>
                <c:out value="${book.key}" />
            </td>
            <td>
                <a href='<spring:url value="/${book.value.id}.html"/>'>
                    <c:out value="${book.value.name}" /> </a>
            </td>

            <td>
                    <a href='<spring:url value="/admin/toplists/${toplist.title}/remove/book/${book.value.id}.html"  />' class="btn btn-danger triggerRemove">
                        Удалить </a>

            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>


