<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>入荷登録</h2>

<form method="POST" action="<c:url value='/arrivals/create' />">
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

    <label for="arrival_date">日付</label><br />
    <input type="date" name="arrival_date" value="<fmt:formatDate value='${report.report_date}' pattern='yyyy-MM-dd' />" />
    <br /><br />

    <label for="product_number">品番</label><br />
    <input type="text" name="product_number" value="${arrival.product}" />
    <br /><br />

    <label for="quantity">個数</label><br />
    <input type="text" name="quantity" value="${arrival.quantity}" />
    <br /><br />

    <button type="submit">登録</button>
</form>
<input type="hidden" name="_token" value="${_token}" />
<p><a href="<c:url value='/toppage/index' />">トップページへ戻る</a></p>