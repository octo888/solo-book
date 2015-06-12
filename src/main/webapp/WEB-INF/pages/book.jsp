<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp"%>

<hr>
<hr>
<hr>

<div class="row" id="features" >
  <c:forEach items="${book}" var="book">
    <div class="col-sm-3 feature">
      <div class="panel">
        <div class="panel-heading">
          <h3 class="panel-title">${book.name}</h3>
        </div>
        <!-- end panel-heading -->

        <a href="" class="btn btn-info btn-block" >Открыть</a>

      </div>
      <!-- end panel -->
    </div>
    <!-- end col-sm-3 -->
  </c:forEach>
</div>
<!-- end row -->

<!-- <hr>
<hr>
<hr>
<table class="table table-bordered table-hover table-striped">
  <thead>
  <tr>
    <th>Book name</th>
  </tr>
  </thead>
  <tbody>
  <%--@elvariable id="book" type="java.util.List"--%>
  <%-- <c:forEach items="${book}" var="book">
    <tr>
      <td>
          ${book.name}
      </td>
    </tr>
  </c:forEach> --%>
  </tbody>
</table>

<h1>test spring</h1> -->