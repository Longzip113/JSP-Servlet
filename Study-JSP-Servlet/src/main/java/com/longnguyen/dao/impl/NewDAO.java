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
		// String sql = "INSERT INTO news (title, content, categoryid) VALUES(?, ?, ?)";
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO news  ");
		sql.append(" (title, content, thumbnail, shortDescripTion, categoryid, createddate, createdby) ");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),
				newModel.getThumbnuil(),newModel.getShortDescripTion(), newModel.getCategoryId(),
				newModel.getCreatedData(),newModel.getCreatedBy());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = Query(sql, new NewMapper(), id);

		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel newModel) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortDescripTion = ?, content = ?, categoryId = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");

		update(sql.toString(), newModel.getTitle(), newModel.getThumbnuil(), newModel.getShortDescripTion(),
				newModel.getContent(), newModel.getCategoryId(), newModel.getCreatedData(), newModel.getCreatedBy(),
				newModel.getModifiedData(),newModel.getModifiedBy(),newModel.getId());

	}

	@Override
	public void delete(Long ids) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, ids);

	}

}
