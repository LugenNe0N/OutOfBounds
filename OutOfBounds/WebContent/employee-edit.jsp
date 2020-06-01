<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報編集</title>
</head>
<body>
<h1>Edit Account</h1>
<form action="employee-edit-servlet" method="POST">
Password<br><input type="text" name="password" pattern=".*\S+.*" required><br>
Name<br><input type="text" name="name" pattern=".*\S+.*" required><br>
<input type="submit" value="Apply">

</form>
<form action="menu-list.jsp" method="POST">
<input type="submit" value="Menu">
</form>
<%@ include file="footer.jsp" %>
</body>
</html>