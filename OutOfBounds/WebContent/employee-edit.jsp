<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報編集</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
<h1 class="form">Edit Account</h1>
<div class="d1">
<form action="employee-edit-servlet" method="POST">
Password<br><input type="text" name="password" pattern="^[0-9A-Za-z]+$" maxlength=32 required><br>
Name<br><input type="text" name="name" pattern=".*\S+.*" maxlength=20 required><br>
<input type="submit" value="Apply">

</form>
<form action="menu-list-servlet" method="POST">
<input type="submit" value="Menu">
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
