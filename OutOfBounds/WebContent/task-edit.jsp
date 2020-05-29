<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="
	java.util.List,
	model.entity.CategoryBean,
	model.entity.StatusBean,
	model.entity.TaskBean,
	model.entity.EmployeeBean
	"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集</title>
</head>
<body>
	<%
		TaskBean task = (TaskBean) request.getAttribute("taskBean");
	%>


	<h1>Edit Task</h1>
	<p>編集内容を入力してください</p>

	<br>
	<form action="task-edit-servlet" method="post">
		<ul>
			<li>タスク名<br> <input type="text" name="taskName"
				value=<%=task.getTaskName()%> maxlength=50>
			</li>

			<li>カテゴリ情報<br> <select name="categoryID">
					<%
						List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
						for (CategoryBean c : categoryList) {
							if (c.getId() == task.getCategoryId()) {
					%>
					<option value="<%=c.getId()%>" selected><%=c.getName()%></option>
					<%
						} else {
					%>
					<option value="<%=c.getId()%>"><%=c.getName()%></option>
					<%
						}
						}
					%>
			</select>
			</li>

			<li>期限<br> <input type="date" name="limitDate"
				value=<%=task.getLimitDate()%>>
			</li>

			<li>担当者情報<br> <select name="employeeId">
					<%
						List<EmployeeBean> employeeList = (List<EmployeeBean>) session.getAttribute("employeeList");
						for (EmployeeBean emp : employeeList) {
							String em=emp.getId();
							String emT=task.getEmployeeId();
							if (emp.getId().equals(task.getEmployeeId())) {
					%>
					<option value="<%=emp.getId()%>" selected><%=emp.getName()%></option>
					<%
						} else {
					%>
					<option value="<%=emp.getId()%>"><%=emp.getName()%></option>
					<%
						}
						}
					%>
			</select>
			</li>

			<li>ステータス情報<br> <select name="status">
					<%
						List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
						for (StatusBean st : statusList) {
							String stC=st.getCode();
							String stT=task.getStatus();
							if (st.getCode().equals(task.getStatus())) {
					%>
					<option value="<%=st.getCode()%>" selected><%=st.getName()%></option>
					<%
						} else {
					%>
					<option value="<%=st.getCode()%>"><%=st.getName()%></option>
					<%
						}
						}
					%>
			</select>
			</li>

			<li>メモ<br> <textarea name="memo" maxlength=100><%=task.getMemo()%></textarea>
			</li>
		</ul>
		<input type = "hidden" name="taskId" value="<%= task.getTaskId()%>">
		<input type="submit" value="Edit">
	</form>
	<a href="menu-list-servlet"><button type="button">Menu</button></a>
</body>
</html>