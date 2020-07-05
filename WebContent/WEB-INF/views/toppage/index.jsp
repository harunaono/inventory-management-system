<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>在庫管理システム</title>
    </head>
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