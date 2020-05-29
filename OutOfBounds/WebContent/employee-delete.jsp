<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除</title>
</head>
<body>
<h1>Delete Account</h1>
<p>本当にユーザ情報を削除してもよろしいですか？</p>
<form action="employee-delete-servlet" method="POST">
<input type="submit" value="Yes">
</form>
<form action="menu-list-servlet" method="POST">
<input type="submit" value="No">
</form>
</body>
</html>