<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
<h1 class="employee-registration">Create New Account</h1>
<div class="emp-regist">
<form action="employee-registration-servlet" method="post">
UserID<br>
<input type="text" name="id" pattern="^[0-9A-Za-z]+$" maxlength=24 required><br>
Password<br>
<input type="text" name="password" pattern="^[0-9A-Za-z]+$" maxlength=32 required><br>
Name<br>
<input type="text" name="name" pattern=".*\S+.*" maxlength=20 required><br>
<input type="submit" value="Create">
</form>
<a href="login.jsp">
<button type="button">Return</button>
</a><br>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
