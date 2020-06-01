package ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.entity.EmployeeBean;

public class Replace {
	public static final Pattern convURLLinkPtn = Pattern.compile(
			"(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+",
			Pattern.CASE_INSENSITIVE);


		//一つの項目のスペース除去
	public static String replace(String str) {
		str = str.replace("　", "");
		str = str.replace(" ", "");
		return str;
	}
	/*
	//TaskBeanのスペース除去
	public static TaskBean replaceTask(TaskBean task) {
		String taskName = task.getTaskName();
		String id = task.getEmployeeId();

		taskName = replace(taskName);
		id = replace(id);

		task.setTaskName(taskName);
		task.setEmployeeId(id);

		return task;
	}
	*/

	//EmployeeBeanのスペース除去
	public static EmployeeBean replaceUser(EmployeeBean employee) {
		String id = employee.getId();
		String password = employee.getPassword();
		String name = employee.getName();

		id = replace(id);
		password = replace(password);
		name = replace(name);

		employee.setId(id);
		employee.setPassword(password);
		employee.setName(name);

		return employee;

	}
	//メモのURLリンク変換
	public static String convURLLink(String str) {
		Matcher matcher = convURLLinkPtn.matcher(str);
		return matcher.replaceAll("<a href=\"$0\">$0</a>");
	}
}
