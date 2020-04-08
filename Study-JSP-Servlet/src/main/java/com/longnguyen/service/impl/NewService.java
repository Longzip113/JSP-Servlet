package com.longnguyen.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.longnguyen.dao.INewDAO;
import com.longnguyen.model.NewModel;
import com.longnguyen.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {

		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedData(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newID = newDAO.save(newModel);
		return newDAO.findOne(newID);
	}

	@Override
	public NewModel update(NewModel newModel) {
		NewModel oldNew = newDAO.findOne(newModel.getId()); // gia tri cu
		newModel.setCreatedData(oldNew.getCreatedData());
		newModel.setCreatedBy(oldNew.getCreatedBy());
		newModel.setModifiedData(new Timestamp(System.currentTimeMillis()));
		newModel.setModifiedBy("");
		newDAO.update(newModel);
		return newDAO.findOne(newModel.getId());
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
	public List<NewModel> findAll(Integer offset, Integer limit) {
		return newDAO.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}
	
}
