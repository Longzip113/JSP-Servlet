package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll ();
}
