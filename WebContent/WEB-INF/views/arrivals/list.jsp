<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>入荷一覧</h2>
        <table id="arrival_list">
            <tbody>
                <tr>
                    <th>日付</th>
                    <th>品番</th>
                    <th>ブランド名</th>
                    <th>商品名</th>
                    <th>カラー</th>
                    <th>サイズ</th>
                    <th>個数</th>
                </tr>
                <c:forEach var="arrival" items="${arrivals}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><fmt:formatDate value='${arrival.arrival_date}' pattern='yyyy-MM-dd' /></td>
                        <td><c:out value="${arrival.product_number}" /></td>
                        <td><c:out value="${arrival.product.brand_name}" /></td>
                        <td><c:out value="${arrival.product.product}" /></td>
                        <td><c:out value="${arrival.product.color}" /></td>
                        <td><c:out value="${arrival.product.size}" /></td>
                        <td><c:out value="${arrival.quantity}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${arrivals_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((arrivals_count - 1) / 20) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/arrivals/list?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/toppage/index' />">トップページへ戻る</a></p>

