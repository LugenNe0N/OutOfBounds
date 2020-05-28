package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

public class StatusDAO {
	public StatusBean select(String id) throws ClassNotFoundException, SQLException {
		StatusBean status = new StatusBean();

		String sql = "SELECT * FROM m_status WHERE status_code = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				status.setCode(res.getString("status_code"));
				status.setName(res.getString("status_name"));
				status.setUpdateDate(res.getTimestamp("update_datetime"));
			}
		}
		return status;

	}

	public List<StatusBean> selectAll() throws ClassNotFoundException, SQLException {
		List<StatusBean> list = new ArrayList<StatusBean>();

		String sql = "SELECT * FROM m_status";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				StatusBean status = new StatusBean();
				status.setCode(res.getString("status_code"));
				status.setName(res.getString("status_name"));
				status.setUpdateDate(res.getTimestamp("update_datetime"));
				list.add(status);
			}
		}

		return list;
	}
}
