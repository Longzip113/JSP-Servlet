package com.longnguyen.dao.impl;

import java.util.List;

import com.longnguyen.dao.INewDAO;
import com.longnguyen.mapper.NewMapper;
import com.longnguyen.model.NewModel;
import com.longnguyen.paging.Pageble;

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
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getThumbnuil(),
				newModel.getShortDescripTion(), newModel.getCategoryId(), newModel.getCreatedData(),
				newModel.getCreatedBy());
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
				newModel.getModifiedData(), newModel.getModifiedBy(), newModel.getId());

	}

	@Override
	public void delete(Long ids) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, ids);

	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// String sql = "SELECT * FROM news LIMIT ?, ?";
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null &&pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return Query(sql.toString(), new NewMapper());

	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

}
