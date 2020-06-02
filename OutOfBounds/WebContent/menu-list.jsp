<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="
	java.util.List,
	java.util.ArrayList,
	java.util.regex.Pattern,
	java.util.regex.Matcher,
	model.entity.CategoryBean,
	model.entity.StatusBean,
	model.entity.TaskBean,
	model.entity.EmployeeBean
	"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link rel="stylesheet" type="text/css" href="sample.css">
</head>
<body>
	<%
		final Pattern convURLLinkPtn = Pattern.compile(
				"(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+",
				Pattern.CASE_INSENSITIVE);
		EmployeeBean emp = (EmployeeBean) request.getAttribute("name");
		String empName;
		if (emp != null)
			empName = emp.getName();
		else
			empName = "as";

		List<TaskBean> taskList = (List<TaskBean>) request.getAttribute("taskList");
		List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categoryList");
		List<EmployeeBean> employeeList = (List<EmployeeBean>) session.getAttribute("employeeList");
		List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("statusList");
		List<TaskBean> myTask = new ArrayList<>();
		List<TaskBean> otherTask = new ArrayList<>();
		if (taskList != null) {
			for (TaskBean t : taskList) {
				if (emp.getId().equals(t.getEmployeeId())) {
					myTask.add(t);
				} else {
					otherTask.add(t);
				}
			}
		}
	%>
	<!-- メソッド -->
	<%!
	public static String convURLLink(String str,Pattern convURLLinkPtn) {
	    Matcher matcher = convURLLinkPtn.matcher(str);
	    return matcher.replaceAll("<a href=\"$0\">$0</a>");
	}

	String categoryName(int id, List<CategoryBean> list) {
		String name = "error";
		for (CategoryBean category : list) {
			if (category.getId() == id) {
				name = category.getName();
			}
		}
		return name;
	}

	String employeeName(String id, List<EmployeeBean> list) {
		String name = "error";
		for (EmployeeBean employee : list) {
			if (employee.getId().equals(id)) {
				name = employee.getName();
			}
		}
		return name;
	}

	String statusName(String id, List<StatusBean> list) {
		String name = "error";
		for (StatusBean status : list) {
			if (status.getCode().equals(id)) {
				name = status.getName();
			}
		}
		return name;
	}%>


	<h1>My Page</h1>

	<div class="list">
	<%=empName%><br>
	<div style="display: inline-flex">
	<form action="employee-edit.jsp" method="post">
		<input type="submit" value="Edit">
	</form>
	<form action="employee-delete.jsp" method="post">
		<input type="submit" value="Delete">
	</form>
	<form action="logout-servlet" method="post">
		<input type="submit" value="Logout">
	</form>
	</div>
	<h2>My Task List</h2>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
			<th>編集</th>
			<th>削除</th>
			<th>最終更新</th>
		</tr>
		<%
			if (taskList != null) {
				for (TaskBean my : myTask) {
		%>
		<tr>
			<td><%=my.getTaskName()%></td>
			<td><%=categoryName(my.getCategoryId(), categoryList)%></td>
			<td><%=my.getLimitDate()%></td>
			<td><%=employeeName(my.getEmployeeId(), employeeList)%></td>
			<td><%=statusName(my.getStatus(), statusList)%></td>
			<td><%=convURLLink(my.getMemo(),convURLLinkPtn)%></td>

			<td><form action="task-select-servlet" method="post">
					<input type="hidden" name="taskId" value=<%=my.getTaskId()%>>
					<input type="submit" value="Edit">
				</form></td>
			<td><form action="task-delete-select-servlet" method="post">
					<input type="hidden" name="taskId" value=<%=my.getTaskId()%>>
					<input type="submit" value="Delete">
				</form></td>
			<td><%=my.getUpdateDate()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<form action="task-registration.jsp" method="post">
		<input type="submit" value="Add">
	</form>


	<h2>Other Task List</h2>
	<table border="1">
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
			<th>編集</th>
			<th>削除</th>
			<th>最終更新</th>
		</tr>
		<%
			if (taskList != null) {
				for (TaskBean other : otherTask) {
		%>
		<tr>
			<td><%=other.getTaskName()%></td>
			<td><%=categoryName(other.getCategoryId(), categoryList)%></td>
			<td><%=other.getLimitDate()%></td>
			<td><%=employeeName(other.getEmployeeId(), employeeList)%></td>
			<td><%=statusName(other.getStatus(), statusList)%></td>
			<td><%=convURLLink(other.getMemo(),convURLLinkPtn)%></</td>
			<td><form action="task-select-servlet" method="post">
					<input type="hidden" name="taskId" value=<%=other.getTaskId()%>>
					<input type="submit" value="Edit">
				</form></td>
			<td><form action="task-delete-select-servlet" method="post">
					<input type="hidden" name="taskId" value=<%=other.getTaskId()%>>
					<input type="submit" value="Delete">
				</form></td>
			<td><%=other.getUpdateDate()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>