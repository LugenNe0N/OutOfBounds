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
<h1>Login</h1>
<form action="login-servlet" method="POST">
UserID<br>
<input type="text" name="id" maxlength="24" required><br>
Password<br>
<input type="text" name="password" maxlength="32" required><br>
<input type="submit" value="Login">
</form>
<form action="employee-registaration.jsp">
<input type="submit" value="Register">
</form>
<%@ include file="footer.jsp" %>
</body>
</html>