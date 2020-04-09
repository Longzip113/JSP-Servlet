package com.longnguyen.service;

import com.longnguyen.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userNam, String passWord, Integer status);
}
