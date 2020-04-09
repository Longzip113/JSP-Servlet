package com.longnguyen.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import com.longnguyen.dao.GenericDao;
import com.longnguyen.mapper.RowMapper;

public class AbsTractDAO<T> implements GenericDao<T> {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Properties properties = new Properties();
//			properties.put("user", "root");
//			properties.put("password", "long250599");
//			return DriverManager.getConnection("jdbc:mysql://localhost:3306/NewServlet", properties);
			Class.forName(resourceBundle.getString("driverName"));
			Properties properties = new Properties();
			properties.put("user", resourceBundle.getString("user"));
			properties.put("password", resourceBundle.getString("password"));
			return DriverManager.getConnection(resourceBundle.getString("url"), properties);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> Query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameters ()
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (Exception e) {
			// TODO: handle exception
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
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object[] parameters) {
		// TODO Auto-generated method stub
		for (int i = 0; i < parameters.length; i++) {
			Object parameter = parameters[i];
			int index = 1 + i;
			try {
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate(); // use for all
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate(); // use for all
			resultSet = statement.getGeneratedKeys(); // vì hệ thống tự tạo id nên phải grnera đúng id
			if (resultSet.next()) {
				id = resultSet.getLong(1); //return id tự tăng 
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public int count(String sql, Object... parameters) {
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		int count = 0;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate(); // use for all
			resultSet = statement.getGeneratedKeys(); // vì hệ thống tự tạo id nên phải grnera đúng id
			if (resultSet.next()) {
				count = resultSet.getInt(1); //return id tự tăng 
			}
			connection.commit();
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
