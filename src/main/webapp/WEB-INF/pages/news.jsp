<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<div class="row">
  <c:forEach items="${news}" var="item">
    <div class="list-group">
      <a href="${item.link}" target="_blank" class="list-group-item">
        <h4 class="list-group-item-heading">${item.title}</h4>
        <small>${item.publishedDate}</small>
        <p class="list-group-item-text">${item.description}</p>
      </a>
    </div>
  </c:forEach>
</div>
