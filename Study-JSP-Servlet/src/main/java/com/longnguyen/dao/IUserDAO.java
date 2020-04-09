package com.longnguyen.dao;

import com.longnguyen.model.UserModel;

public interface IUserDAO extends GenericDao<UserModel>{
	
	UserModel findByUserNameAndPasswordAndStatus(String userNam, String passWord, Integer status);
}
