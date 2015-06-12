<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<div class="row">

    <c:if test="${param.success eq true}" >
        <div class="alert alert-success">Вы успешно зарегестрировались!</div>
    </c:if>
<form:form commandName="user"
           cssClass="form-horizontal registrationForm">

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-8">
            <form:input path="name" cssClass="form-control" />
            <form:errors path="name" />
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-8">
            <form:input path="email" cssClass="form-control" />
            <form:errors path="email" />
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-8">
            <form:password path="password" cssClass="form-control" />
            <form:errors path="password" />
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password again:</label>
        <div class="col-sm-8">
            <input type="password" name="password_again" id="password_again" class="form-control" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="Save" class="btn btn-lg btn-primary pull-right" />
        </div>
    </div>

</form:form>

</div>