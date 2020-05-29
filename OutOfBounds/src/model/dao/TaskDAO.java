package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {
	public void insert(TaskBean task) throws ClassNotFoundException, SQLException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO t_task (task_name,category_id,limit_date,user_id,status_code,memo)"
								+ " VALUES(?, ?, ?, ?, ?, ?)")) {
			// DTOからのデータの取り出し
			String task_name = task.getTaskName();
			int category_id = task.getCategoryId();
			Date limit_date = task.getLimitDate();
			String user_id = task.getEmployeeId();
			String status_code = task.getStatus();
			String memo = task.getMemo();
			//Timestamp create_datetime = task.getRegisteredDate();

			pstmt.setString(1, task_name);
			pstmt.setInt(2, category_id);
			pstmt.setDate(3, limit_date);
			pstmt.setString(4, user_id);
			pstmt.setString(5, status_code);
			pstmt.setString(6, memo);
			//pstmt.setTimestamp(7, create_datetime);

			pstmt.executeUpdate();
		}
	}

	public void update(TaskBean task) throws ClassNotFoundException, SQLException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
"UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, user_id = ?, status_code = ?, memo = ? WHERE task_id =? ")) {

			// DTOからのデータの取り出し
			String task_name = task.getTaskName();
			int category_id = task.getCategoryId();
			Date limit_date = task.getLimitDate();
			String user_id = task.getEmployeeId();
			String status_code = task.getStatus();
			String memo = task.getMemo();
			int task_id = task.getTaskId();

			pstmt.setString(1, task_name);
			pstmt.setInt(2, category_id);
			pstmt.setDate(3, limit_date);
			pstmt.setString(4, user_id);
			pstmt.setString(5, status_code);
			pstmt.setString(6, memo);
			pstmt.setInt(7, task_id);

			pstmt.executeUpdate();
		}
	}

	public void delete(int id) throws ClassNotFoundException, SQLException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"DELETE FROM t_task WHERE task_id = ?;")) {

			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		}
	}

	public TaskBean select(String id) throws ClassNotFoundException, SQLException {
		TaskBean task = new TaskBean();

		String sql = "SELECT * FROM t_task WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				task.setTaskId(Integer.parseInt(id));
				task.setTaskName(res.getString("task_name"));
				task.setCategoryId(res.getInt("category_id"));
				task.setLimitDate(res.getDate("limit_date"));
				task.setEmployeeId(res.getString("user_id"));
				task.setStatus(res.getString("status_code"));
				task.setMemo(res.getString("memo"));
			}
		}
		return task;

	}

	public List<TaskBean> selectAll() throws ClassNotFoundException, SQLException {
		List<TaskBean> list = new ArrayList<TaskBean>();

		String sql = "SELECT * FROM t_task";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				TaskBean task = new TaskBean();
				task.setTaskId(res.getInt("task_id"));
				task.setTaskName(res.getString("task_name"));
				task.setCategoryId(res.getInt("category_id"));
				task.setLimitDate(res.getDate("limit_date"));
				task.setEmployeeId(res.getString("user_id"));
				task.setStatus(res.getString("status_code"));
				task.setMemo(res.getString("memo"));
				task.setRegisteredDate(res.getTimestamp("create_datetime"));
				task.setUpdateDate(res.getTimestamp("update_datetime"));
				list.add(task);
			}
		}

		return list;
	}

}
