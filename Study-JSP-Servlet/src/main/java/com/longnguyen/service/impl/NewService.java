package com.longnguyen.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.longnguyen.dao.ICategoryDAO;
import com.longnguyen.dao.INewDAO;
import com.longnguyen.model.CategoryModel;
import com.longnguyen.model.NewModel;
import com.longnguyen.paging.Pageble;
import com.longnguyen.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {

		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedData(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy(newModel.getCreatedBy());
		CategoryModel categoryModel = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(categoryModel.getId());
		Long newID = newDAO.save(newModel);
		return newDAO.findOne(newID);
	}

	@Override
	public NewModel update(NewModel updaNew) {
		NewModel oldNew = newDAO.findOne(updaNew.getId()); // gia tri cu
		updaNew.setCreatedData(oldNew.getCreatedData());
		updaNew.setCreatedBy(oldNew.getCreatedBy());
		updaNew.setModifiedData(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(updaNew.getCategoryCode());
		updaNew.setCategoryId(categoryModel.getId());
		updaNew.setModifiedBy(updaNew.getModifiedBy());
		newDAO.update(updaNew);
		return newDAO.findOne(updaNew.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			//1. Delete comment (Khoa ngoai new_id)
			//2. Delete new
			newDAO.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}

	@Override
	public NewModel findOne(Long id) {
		NewModel newModel = newDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
	
}
