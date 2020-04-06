package com.longnguyen.service;

import java.util.List;

import com.longnguyen.model.NewModel;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel newModel);
	void delete(Long[] ids);
}
