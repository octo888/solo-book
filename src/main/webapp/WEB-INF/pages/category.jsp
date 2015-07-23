<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>

<div class="row" id="categoryBooks">

    <c:forEach items="${books}" var="book">

        <div class="col-sm-2">
            <div class="panel" id="categoryPanel">

                <a href=""><img src="http://placehold.it/100x150" class="img-responsive thumbnail"
                                alt="${book.name}"></a>


                <h5 data-toggle="tooltip" data-placement="right" title="${book.description}">
                    <a href="<spring:url value="/${book.id}.html"/>">${book.name}</a></h5>

            </div>
        </div>
        <!-- end col-sm-2 -->

    </c:forEach>
</div>
<!-- end row -->
<div align="center">
    <nav>
        <ul class="pagination">
            <%--<li>
                <a href="/blogs/page/${current - 1}.html" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>--%>

            <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                <c:set var="active" value="${i}"/>
                <li class="${current == active ? 'active' : '' }">
                    <a href="/category/${category.title}/page/${i}.html">${i}</a>
                </li>
            </c:forEach>

            <%--<li>
                <a href="/blogs/page/${current + 1}.html" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>--%>
        </ul>
    </nav>
</div>

