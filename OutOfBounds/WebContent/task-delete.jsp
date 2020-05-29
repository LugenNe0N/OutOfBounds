<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除</title>
</head>
<body>
<h1>Delete Task</h1>

<h3><%=request.getAttribute("taskName") %></h3>

本当にこのタスクを削除しても<br>
よろしいですか？<br>

<!-- 削除サーブレットへ飛ばす -->
<form action="task-delete-servlet" method="post">

<input type="submit" value="Yes">
</form>

<!-- メニューへ戻す -->
<!--<form action="menu-list.jsp" method="post"><input type="submit" value="Yes"></form>-->
<a href ="menu-list-servlet"><button type="button">Menu</button></a>
</body>
</html>