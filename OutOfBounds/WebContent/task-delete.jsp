<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除</title>
</head>
<body>
<h1>Delete Task</h1>

<!-- タスク名 -->
<%= %>
本当にこのタスクを削除しても<br>
よろしいですか？<br>

<!-- 削除サーブレットへ飛ばす -->
<form action="task-delete-servlet" method="post">
<input type="submit" value="Yes">
</form>

<!-- メニューへ戻す -->
<!--<form action="menu-list.jsp" method="post"><input type="submit" value="Yes"></form>-->
<a href ="menu-list-servlet"><button type="button">Yes</button></a>
</body>
</html>