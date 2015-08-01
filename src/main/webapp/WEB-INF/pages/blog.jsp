<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<div class="row">
    <h4 align="middle"><b><c:out value="${blog.name}"/></b></h4>
    <h5 ><b>Автор: </b><c:out value="${blog.user.nickName}"/></h5>
    <h5 ><b>Дата публикации: </b><c:out value="${blog.getDateAsString()}"/></h5>
    <br/>
    <div class="col-sm-8 col-center-block" id="blog-text" >
        <p class="text-justify">${blog.description}</p>
    </div>
</div>