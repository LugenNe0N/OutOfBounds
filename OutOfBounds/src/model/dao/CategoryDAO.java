package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	public CategoryBean select(int id) throws ClassNotFoundException, SQLException {
		CategoryBean category = new CategoryBean();

		String sql = "SELECT * FROM m_category WHERE category_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				category.setId(res.getInt("category_id"));
				category.setName(res.getString("category_name"));
				category.setUpdateDate(res.getTimestamp("update_datetime"));
			}
		}
		return category;

	}

	public List<CategoryBean> selectAll() throws ClassNotFoundException, SQLException {
		List<CategoryBean> list = new ArrayList<CategoryBean>();

		String sql = "SELECT * FROM m_category";

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				CategoryBean category = new CategoryBean();
				category.setId(res.getInt("category_id"));
				category.setName(res.getString("category_name"));
				category.setUpdateDate(res.getTimestamp("update_datetime"));
				list.add(category);
			}
		}

		return list;
	}
}
