package com.longnguyen.dao.impl;

import java.util.List;

import com.longnguyen.dao.ICategoryDAO;
import com.longnguyen.mapper.CategoryMapper;
import com.longnguyen.model.CategoryModel;

public class CategoryDAO extends AbsTractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return Query(sql, new CategoryMapper());
	}
}
