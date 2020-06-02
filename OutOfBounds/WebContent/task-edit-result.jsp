<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集完了</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
	<h1>Successful</h1>
	<div class="d1">
		<div class="result">
		タスクの編集が完了しました。<br>
		メニュー画面へ戻ります。<br>
	<!-- メニューへ戻す -->
<!--<form action="menu-list.jsp" method="post"><input type="submit" value="Yes"></form>-->
<a href ="menu-list-servlet"><button type="button">Yes</button></a><br>
</div></div>
<%@ include file="footer.jsp" %>
</body>
</html>