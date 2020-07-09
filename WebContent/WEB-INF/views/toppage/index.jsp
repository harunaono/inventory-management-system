<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
<c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
    <head>
        <meta charset="UTF-8">
        <title>在庫管理システム</title>
    </head>
            <div id="header">
                <div id="header_menu">
                    <h1><a href="<c:url value='/' />"></a></h1>&nbsp;&nbsp;&nbsp;

                </div>
                <c:if test="${sessionScope.login_store != null}">
                    <div id="employee_name">
                        <c:out value="${sessionScope.login_store.store_name}" />&nbsp;店&nbsp;&nbsp;&nbsp;
                        <a href="<c:url value='/logout' />">ログアウト</a>
                    </div>
                </c:if>
            </div>
    <body>
      <div style="margin-left: 200px;">
      <h2>在庫管理システム</h2>
         <p><a href="<c:url value='/store/new' />">１．店舗登録</a></p>
         <p><a href="<c:url value='/product/new' />">２．商品登録</a></p>
         <p><a href="<c:url value='/arrival/new' />">３．入荷登録</a></p>
         <p><a href="<c:url value='/arrival/list' />">４．入荷一覧</a></p>
         <p><a href="<c:url value='/sales/new' />">５．売上登録</a></p>
         <p><a href="<c:url value='/sales/list' />">６．売上一覧</a></p>
         <p><a href="<c:url value='/stock/search' />">７．在庫検索</a></p>
         <p><a href="<c:url value='/best/search' />">８．ベストセラー、ワーストセラー</a></p>
      </div>
    </body>
</html>