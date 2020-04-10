package com.longnguyen.dao.impl;

import java.util.List;

import com.longnguyen.dao.ICategoryDAO;
import com.longnguyen.mapper.CategoryMapper;
import com.longnguyen.mapper.NewMapper;
import com.longnguyen.model.CategoryModel;
import com.longnguyen.model.NewModel;

public class CategoryDAO extends AbsTractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return Query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> category = Query(sql, new CategoryMapper(), id);

		return category.isEmpty() ? null : category.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> category = Query(sql, new CategoryMapper(), code);

		return category.isEmpty() ? null : category.get(0);
	}
}
