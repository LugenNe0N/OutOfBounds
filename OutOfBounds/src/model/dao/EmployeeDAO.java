package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeeBean;

public class EmployeeDAO {
	public void insert(EmployeeBean employee) throws ClassNotFoundException, SQLException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_user VALUES(?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String user_id = employee.getId();
			String password = employee.getPassword();
			String user_name = employee.getName();
			Timestamp update_datetime = employee.getUpdateDate();

			pstmt.setString(1, user_id);
			pstmt.setString(2, password);
			pstmt.setString(3, user_name);
			pstmt.setTimestamp(4, update_datetime);

			pstmt.executeUpdate();
		}
	}

	public void update(EmployeeBean employee) throws ClassNotFoundException, SQLException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"UPDATE m_user SET password = ?, user_name = ? WHERE user_id = ?")) {

			// DTOからのデータの取り出し
			String user_id = employee.getId();
			String password = employee.getPassword();
			String user_name = employee.getName();


			pstmt.setString(1, password);
			pstmt.setString(2, user_name);
			pstmt.setString(3, user_id);

			pstmt.executeUpdate();
		}
	}

	public void delete(String id) throws ClassNotFoundException, SQLException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM m_user WHERE user_id = ?")) {

			pstmt.setString(1, id);

			pstmt.executeUpdate();
		}
	}

	public EmployeeBean select(String id) throws ClassNotFoundException, SQLException {
		EmployeeBean employee = new EmployeeBean();

		String sql = "SELECT * FROM m_user WHERE user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				employee.setId(res.getString("user_id"));
				employee.setPassword(res.getString("password"));
				employee.setName(res.getString("user_name"));
				employee.setUpdateDate(res.getTimestamp("update_datetime"));
			}
		}
		return employee;

	}

	public List<EmployeeBean> selectAll() throws ClassNotFoundException, SQLException {
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();

		String sql = "SELECT * FROM m_user";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				EmployeeBean employee = new EmployeeBean();
				employee.setId(res.getString("user_id"));
				employee.setPassword(res.getString("password"));
				employee.setName(res.getString("user_name"));
				employee.setUpdateDate(res.getTimestamp("update_datetime"));
				list.add(employee);
			}
		}

		return list;
	}

	public boolean loginCheck(String id, String pass) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			if (res.next()) {
				return true;
			}
		}
		return false;
	}

}
