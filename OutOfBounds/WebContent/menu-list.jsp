<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="
	java.util.List,
	java.util.ArrayList,
	model.entity.CategoryBean,
	model.entity.StatusBean,
	model.entity.TaskBean,
	model.entity.EmployeeBean
	"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		EmployeeBean emp = (EmployeeBean) session.getAttribute("emp");
		String empName;
		if(emp!=null)empName=emp.getName();
		else empName="as";

		List<TaskBean> taskList = (List<TaskBean>) session.getAttribute("taskList");
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
	<h1>My Page</h1>
	<%=empName%><br>

	<form action="employee-edit.jsp" method="post">
		<input type="submit" value="edit">
	</form>
	<form action="employee-delete.jsp" method="post">
		<input type="submit" value="Delete">
	</form>
	<form action="logout-servlet" method="post">
		<input type="submit" value="Logout">
	</form>

	<h2>My Task List</h2>
	<ul>
		<%
			if (taskList != null) {
				for (TaskBean my : myTask) {
		%>
		<li><%=my.getTaskName()%>
			<form action="task-select-servlet" method="post">
				<input type="submit" value="Edit">
			</form>
			<form action="task-delete-servlet" method="post">
				<input type="submit" value="Delete">
			</form></li>
		<%
				}
			}
		%>
	</ul>
	<form action="task-registration-servlet" method="post">
		<input type="submit" value="Add">
	</form>


	<h2>Other Task List</h2>
	<ul>
		<%
			if (taskList != null) {
				for (TaskBean other : otherTask) {
		%>
		<li><%=other.getTaskName()%>
			<form action="task-select-servlet" method="post">
				<input type="submit" value="Edit">
			</form>
			<form action="task-delete-servlet" method="post">
				<input type="submit" value="Delete">
			</form></li>
		<%
				}
			}
		%>
	</ul>

</body>
</html>