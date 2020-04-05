package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.model.CategoryModel;

public interface ICategoryDAO extends GenericDao<CategoryModel>{
	List<CategoryModel> findAll ();
}
