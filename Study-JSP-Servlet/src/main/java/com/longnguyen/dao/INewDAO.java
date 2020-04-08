package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.model.NewModel;

public interface INewDAO extends GenericDao <NewModel>{
	List<NewModel> findByCategoryId(Long categoryId); 
	NewModel findOne(Long id);
	Long save(NewModel newModel);
	void update(NewModel newModel);
	void delete(Long ids);
	List<NewModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
