<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
</head>
<body>
<h1>Create New Account</h1>
<form action="employee-registration-servlet" method="post">
UserID<br>
<input type="text" name="id" pattern=".*\S+.*" required><br>
Password<br>
<input type="text" name="password" pattern=".*\S+.*" required><br>
Name<br>
<input type="text" name="name" required><br>
<input type="submit" value="Create">
</form>
<%@ include file="footer.jsp" %>
</body>
</html>