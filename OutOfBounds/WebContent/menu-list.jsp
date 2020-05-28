<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"import ="
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
EmployeeBean emp =(EmployeeBean) session.getAttribute("emp");

List<TaskBean> taskList=(List<TaskBean>)session.getAttribute("TaskList");
List<TaskBean> myTask=new ArrayList<>();
List<TaskBean> OtherTask=new ArrayList<>();

for(TaskBean t:taskList){
	if(emp.getId().equals(t.getEmployeeId())){
		myTask.add(t);
	}
	else{
		OtherTask.add(t);
	}
}
%>
<h1>My Page</h1>
<%=emp.getName() %><br>

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

<h2>Other Task List</h2>
</body>
</html>