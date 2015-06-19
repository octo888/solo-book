<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../../layouts/taglib.jsp"%>

<!--
<form  enctype="multipart/form-data" css="form-horizontal"  action="/add" method="post">

    <div class="form-group"><input type="text" class="form-control" name="name" placeholder="Name"></div>
    <div class="form-group"><input type="text" class="form-control" name="category" placeholder="Category"></div>
    <div class="form-group">Image: <input type="file" name="image"></div>

    <div class="form-group"><input type="submit" class="btn btn-primary" value="Add"></div>
</form> -->


<form:form commandName="add_book"
           cssClass="form-horizontal" enctype="multipart/form-data" >

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

    <!--
    <div class="form-group">
        <label for="image" class="col-sm-2 control-label">Изображение:</label>
        <div class="col-sm-8">
             <input type="file" name="image" />
        </div>
    </div> -->


    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="Сохранить" class="btn btn-lg btn-primary pull-right" />
        </div>
    </div>

</form:form>
