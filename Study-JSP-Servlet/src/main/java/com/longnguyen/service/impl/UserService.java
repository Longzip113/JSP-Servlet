package com.longnguyen.service.impl;

import javax.inject.Inject;

import com.longnguyen.dao.IUserDAO;
import com.longnguyen.model.UserModel;
import com.longnguyen.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDao;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userNam, String passWord, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userNam, passWord, status);
	}

}
