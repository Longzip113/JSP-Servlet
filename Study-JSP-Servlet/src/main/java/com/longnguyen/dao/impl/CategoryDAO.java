package com.longnguyen.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.longnguyen.dao.ICategoryDAO;
import com.longnguyen.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "long250599");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/NewServlet", properties);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		List<CategoryModel> results = new ArrayList();
		// open connection
		Connection connection = getConnection();
		String sql = "select * from category";
		PreparedStatement statement = null;

		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					CategoryModel categoryModel = new CategoryModel();
					categoryModel.setId(resultSet.getLong("id"));
					categoryModel.setCode(resultSet.getString("code"));
					categoryModel.setName(resultSet.getString("name"));
					results.add(categoryModel);
				}

				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return null;

	}

}
