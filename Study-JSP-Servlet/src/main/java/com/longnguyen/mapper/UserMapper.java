package com.longnguyen.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.longnguyen.model.RoleModel;
import com.longnguyen.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(resultSet.getLong("id"));
			userModel.setUserName(resultSet.getString("username"));
			userModel.setPassWord(resultSet.getString("password"));
			userModel.setStatus(resultSet.getInt("status"));
			userModel.setFullName(resultSet.getString("fullname"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				userModel.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
//			userModel.setRoleid(resultSet.getInt("roleid"));
//			userModel.setCreatedData(resultSet.getTimestamp("createddate"));
//			userModel.setCreatedBy(resultSet.getString("createdby"));
//
//			if (resultSet.getTimestamp("modifieddate") != null) {
//				userModel.setModifiedData(resultSet.getTimestamp("modifieddate"));
//			}
//			if (resultSet.getTimestamp("modifiedby") != null) {
//				userModel.setModifiedData(resultSet.getTimestamp("modifiedby"));
//			}
			
			return userModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

}
