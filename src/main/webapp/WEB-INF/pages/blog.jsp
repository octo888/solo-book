<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<h4><b><c:out value="${blog.name}"/></b> </h4>
<h4><b>Автор: </b><c:out value="${blog.user.name}"/></h4>
<h4><b>Дата публикации: </b><c:out value="${blog.publishedDate}"/></h4>

<p>${blog.description}</p>
