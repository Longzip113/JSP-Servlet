package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.model.NewModel;
import com.longnguyen.paging.Pageble;

public interface INewDAO extends GenericDao <NewModel>{
	List<NewModel> findByCategoryId(Long categoryId); 
	NewModel findOne(Long id);
	Long save(NewModel newModel);
	void update(NewModel newModel);
	void delete(Long ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
