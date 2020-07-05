<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>店舗登録</h2>

<label for="name">店舗名</label><br />
<input type="text" name="name" value="${store.store_name}" />
<br /><br />

<label for="code">ID</label><br />
<input type="text" name="code" value="${store.code}" />
<br /><br />

<label for="password">パスワード</label><br />
<input type="password" name="password" />
<br /><br />

<button type="submit">登録</button>

<p><a href="<c:url value='/toppage/index' />">トップページへ戻る</a></p>