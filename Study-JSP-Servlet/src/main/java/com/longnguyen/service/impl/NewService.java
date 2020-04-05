package com.longnguyen.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.longnguyen.dao.INewDAO;
import com.longnguyen.model.NewModel;
import com.longnguyen.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDAO;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		Long newID = newDAO.save(newModel);
		System.out.println(newID);
		return null;
	}

}
