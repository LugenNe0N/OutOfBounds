<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
<h1>Error Found</h1>
<%=request.getAttribute("eMessage") %>
エラーが発生しました。<br>
メニュー画面に戻ります。<br>
<a href="menu-list-servlet">
<button type="button">Yse</button>
</a>
</body>
</html>