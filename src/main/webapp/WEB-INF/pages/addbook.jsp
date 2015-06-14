<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>



<form:form commandName="addBook"
           cssClass="form-horizontal" >

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Название:</label>
        <div class="col-sm-8">
            <form:input path="name" cssClass="form-control" />
            <form:errors path="name" />
        </div>
    </div>

    <div class="form-group">
        <label for="authorName" class="col-sm-2 control-label">Автор:</label>
        <div class="col-sm-8">
            <form:input path="authorName" cssClass="form-control" />
            <form:errors path="authorName" />
        </div>
    </div>

    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">Описание:</label>
        <div class="col-sm-8">
            <form:input path="description" cssClass="form-control" />
            <form:errors path="description" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="Сохранить" class="btn btn-lg btn-primary pull-right" />
        </div>
    </div>

</form:form>
