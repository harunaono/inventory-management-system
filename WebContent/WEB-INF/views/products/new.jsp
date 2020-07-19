<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>商品登録</h2>
<form method="POST" action="<c:url value='/products/create' />">
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="brand_name">ブランド名</label><br />
<input type="text" name="brand_name" value="${product.brand_name}" />
<br /><br />

<label for="product">商品名</label><br />
<input type="text" name="product" value="${product.product}" />
<br /><br />

<label for="product_number">品番</label><br />
<input type="text" name="product_number" />
<br /><br />

<label for="size">サイズ</label><br />
<input type="text" name="size" value="${product.size}" />
<br /><br />

<label for="color">カラー</label><br />
<input type="text" name="color" value="${product.color}" />
<br /><br />

<label for="price">価格</label><br />
<input type="text" name="price" value="${product.price}" />
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
</form>

<p><a href="<c:url value='/toppage/index' />">一覧に戻る</a></p>