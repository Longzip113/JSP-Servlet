package com.longnguyen.dao.impl;

import java.util.List;

import com.longnguyen.dao.INewDAO;
import com.longnguyen.mapper.NewMapper;
import com.longnguyen.model.NewModel;

public class NewDAO extends AbsTractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return Query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "INSERT INTO news (title, content, categoryid) VALUES(?, ?, ?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId());
	}

}
