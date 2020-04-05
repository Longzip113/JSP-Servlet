package com.longnguyen.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.longnguyen.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel newModel = new NewModel();
			newModel.setId(resultSet.getLong("id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setContent(resultSet.getString("content"));
			newModel.setCategoryId(resultSet.getLong("categoryId"));
			return newModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
			
	}

	
}
