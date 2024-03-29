<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="
	java.util.List,
	model.entity.CategoryBean,
	model.entity.StatusBean,
	model.entity.EmployeeBean
	"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
	<h1 class="form">Add Task</h1>
	<p class="center">タスクを入力してください</p><br>
	<div class="task">
	<form action="task-registration-servlet" method="post">
		<ul>
			<li>タスク名<br> <input type="text" name="taskName" required
				maxlength=50 pattern=".*\S+.*">
			</li>

			<li>カテゴリ情報<br> <select name="categoryID">
					<%
						List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
						for (CategoryBean c : categoryList) {
					%>
					<option value="<%=c.getId()%>"><%=c.getName()%></option>
					<%
						}
					%>
			</select>
			</li>

			<li>期限<br> <input type="date" name="limitDate" required>
			</li>

			<li>担当者情報<br> <select name="employeeId">
					<%
						List<EmployeeBean> employeeList = (List<EmployeeBean>) session.getAttribute("employeeList");
						for (EmployeeBean emp : employeeList) {
					%>
					<option value=<%=emp.getId()%>><%=emp.getName()%></option>
					<%
						}
					%>
			</select>
			</li>

			<li>ステータス情報<br> <select name="status">
					<%
						List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
						for (StatusBean st : statusList) {
					%>
					<option value=<%=st.getCode()%>><%=st.getName()%></option>
					<%
						}
					%>
			</select>
			</li>

			<li>メモ<br> <textarea name="memo" maxlength=100></textarea>
			</li>
		</ul>
		<div class="center">
		<input type="submit" value="Add">
		</div>
	</form>

	<!--<form action="menu-list.jsp" method="post"><input type="submit" value="Yes"></form>-->
	<div class="center">
	<a href="menu-list-servlet"><button type="button">Menu</button></a><br>
	</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
