<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
<div id="wrapper">
<h1>Login</h1>
<div class="d1">
<div class="login">
<form action="login-servlet" method="POST">
UserID<br>
<input type="text" name="id" maxlength="24" pattern=".*\S+.*" required><br>
Password<br>
<input type="text" name="password" maxlength="32" pattern=".*\S+.*" required><br>
<input type="submit" value="Login">
</form>
<form action="employee-registration.jsp">
<input type="submit" value="Register">
</form>
</div>
</div>
<%@ include file="footer.jsp" %>
</div>
</body>
</html>