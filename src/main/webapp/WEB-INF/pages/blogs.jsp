<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layouts/taglib.jsp" %>


<div class="row">
    <c:forEach items="${blogs}" var="item">
        <div class="list-group">
            <a href="<spring:url value="/blogs/${item.id}.html" />" class="list-group-item">
                <h4 class="list-group-item-heading">${item.name}</h4>
                <h5 class="list-group-item-heading">${item.publishedDate}</h5>
                <h5 class="list-group-item-heading"><i>${item.user.name}</i></h5>

                <p class="list-group-item-text">${item.description}</p>
            </a>
        </div>
    </c:forEach>
</div>

<nav>
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="/blogs/page/1.html">1</a></li>
        <li><a href="/blogs/page/2.html">2</a></li>
        <li><a href="/blogs/page/3.html">3</a></li>
        <li><a href="/blogs/page/4.html">4</a></li>
        <li><a href="/blogs/page/5.html">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

