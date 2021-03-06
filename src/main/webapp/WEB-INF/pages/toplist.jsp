<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
  <thead>
  <tr>
    <th>Номер</th>
    <th>Название</th>

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


    </tr>
  </c:forEach>
  </tbody>
</table>
