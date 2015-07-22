<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../../layouts/taglib.jsp" %>


<form role="form" enctype="multipart/form-data" class="form-horizontal" action="/admin/addbook.html"
      method="post">

    <div class="form-group">
        <label for="bookName" class="col-sm-2 control-label">Название:</label>

        <div class="col-sm-8">
            <input type="text" id="bookName" class="form-control" name="name" placeholder="Название">
        </div>
    </div>
    <div class="form-group">
        <label for="authorName" class="col-sm-2 control-label">Автор:</label>

        <div class="col-sm-8">
            <input type="text" id="authorName" class="form-control col-sm-8" name="authorName" placeholder="Автор">
        </div>
    </div>
    <div class="form-group">
        <label for="bookDescription" class="col-sm-2 control-label">Описание:</label>

        <div class="col-sm-8">
            <textarea id="bookDescription" class="form-control" name="description" rows="5"></textarea>
        </div>
    </div>

    <div class="form-group">
        <label for="selectCategory" class="col-sm-2 control-label">Выберите категорию</label>

        <div class="col-sm-8">
            <form:select path="categories" name="selectCategory" cssClass="form-control">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${categories}"/>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="bookImage" class="col-sm-2 control-label">Изображение:</label>

        <div class="col-sm-8">
            <input class="form-control" type="file" id="bookImage" name="image"></div>
    </div>
    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" class="btn btn-primary pull-right" value="Добавить">
        </div>
    </div>
</form>

