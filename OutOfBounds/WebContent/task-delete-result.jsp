<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除完了</title>
</head>
<body>
	<h1>Successful</h1>
	<p>
		タスクの削除が完了しました。<br>
		メニュー画面へ戻ります。
	</p>
	<!-- メニューへ戻す -->
<!--<form action="menu-list.jsp" method="post"><input type="submit" value="Yes"></form>-->
<a href ="menu-list-servlet"><button type="button">Yes</button></a><br>
<%@ include file="footer.jsp" %>
</body>
</html>