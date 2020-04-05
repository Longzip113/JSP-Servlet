package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.model.NewModel;

public interface INewDAO extends GenericDao <NewModel>{
	List<NewModel> findByCategoryId(Long categoryId); 
	NewModel findOne(Long id);
	Long save(NewModel newModel);
}
