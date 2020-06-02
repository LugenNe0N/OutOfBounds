<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
<h1 class="employee-delete">Delete Account</h1>
<div class="d1">
<p>本当にユーザ情報を削除してもよろしいですか？</p>
<div style="display: inline-flex">
<form action="employee-delete-servlet" method="POST">
<input type="submit" value="Yes">
</form>
<form action="menu-list-servlet" method="POST">
<input type="submit" value="No">
</form>
</div></div>
<%@ include file="footer.jsp" %>
</body>
</html>