<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録</title>
</head>
<body>
	<h1>Add Task</h1>
	<p>タスクを入力してください</p>
	<br>
	<form action="task-registration-servlet" method="post">
		<ul>
			<li>タスク名<br> <input type="text" name="taskName">
			</li>

			<li>カテゴリ情報<br> <select name="categoryID">
					<%

					%>
					<option value=<%=%>>
						<%=%></option>
					<%

					%>
			</select>
			</li>

			<li>期限<br> <input type="date" name="limitDate">
			</li>

			<li>担当者情報<br> <select name="id">
					<%

					%>
					<option value=<%=%>>
						<%=%></option>
					<%

					%>
			</select>
			</li>

			<li>ステータス情報<br> <select name="status">
					<%

					%>
					<option value=<%=%>>
						<%=%></option>
					<%

					%>
			</select>
			</li>

			<li>メモ<br> <textarea name="memo"></textarea>
			</li>
		</ul>
		<input type="submit" value="Add">
	</form>

<!--<form action="menu-list.jsp" method="post"><input type="submit" value="Yes"></form>-->
<a href ="menu-list-servlet"><button type="button">Yes</button></a>
</body>
</html>