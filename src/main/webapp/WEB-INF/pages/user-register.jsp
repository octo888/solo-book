<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<div class="row">

    <c:if test="${success eq true}" >
        <div class="alert alert-success">Вы успешно зарегестрировались!</div>
    </c:if>

<form:form commandName="user"
           cssClass="form-horizontal registrationForm">

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Имя пользователя:</label>
        <div class="col-sm-8">
            <form:input path="name" cssClass="form-control" />
            <form:errors path="name" />
        </div>
    </div>

    <div class="form-group">
        <label for="nickName" class="col-sm-2 control-label">Никнейм на сайте:</label>
        <div class="col-sm-8">
            <form:input path="nickName" cssClass="form-control" />
            <form:errors path="nickName" />
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
        <label for="password" class="col-sm-2 control-label">Пароль:</label>
        <div class="col-sm-8">
            <form:password path="password" cssClass="form-control" />
            <form:errors path="password" />
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Повторите пароль:</label>
        <div class="col-sm-8">
            <input type="password" name="password_again" id="password_again" class="form-control" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="Сохранить" class="btn btn-lg btn-primary pull-right" />
        </div>
    </div>

</form:form>

</div>

<script type="text/javascript">
    $(document).ready(function() {

        $(".registrationForm").validate(
                {
                    rules: {
                        name: {
                            required : true,
                            minlength : 3,
                            remote : {
                                url: "<spring:url value='/register/available.html' />",
                                type: "get",
                                data: {
                                    username: function() {
                                        return $("#name").val();
                                    }
                                }
                            }
                        },
                        email: {
                            required : false,
                            email: true
                        },
                        nickName: {
                            required : true,
                            minlength : 3
                        },
                        password: {
                            required : true,
                            minlength : 4
                        },
                        password_again: {
                            required : true,
                            minlength : 4,
                            equalTo: "#password"
                        }
                    },
                    highlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    },
                    messages: {
                        name: {
                            remote: "Выбранное имя пользователя уже существует!"
                        }
                    }
                }
        );
    });
</script>