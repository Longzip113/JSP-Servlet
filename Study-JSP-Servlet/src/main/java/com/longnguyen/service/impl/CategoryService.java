package com.longnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.longnguyen.dao.ICategoryDAO;
import com.longnguyen.model.CategoryModel;
import com.longnguyen.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO iCategoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return iCategoryDAO.findAll();
	}
}
