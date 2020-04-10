package com.longnguyen.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.longnguyen.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel newModel = new NewModel();
			newModel.setId(resultSet.getLong("id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setContent(resultSet.getString("content"));
			newModel.setCategoryId(resultSet.getLong("categoryId"));
			newModel.setThumbnail(resultSet.getString("thumbnail"));
			newModel.setShortDescripTion(resultSet.getString("shortDescripTion"));
			newModel.setCreatedData(resultSet.getTimestamp("createddate"));
			newModel.setCreatedBy(resultSet.getString("createdby"));

			if (resultSet.getTimestamp("modifieddate") != null) {
				newModel.setModifiedData(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getTimestamp("modifiedby") != null) {
				newModel.setModifiedData(resultSet.getTimestamp("modifiedby"));
			}
			
			return newModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

}
