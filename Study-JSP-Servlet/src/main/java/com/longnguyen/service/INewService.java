package com.longnguyen.service;

import java.util.List;

import com.longnguyen.model.NewModel;
import com.longnguyen.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel newModel);
	void delete(Long[] ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	NewModel findOne(Long id);
}
