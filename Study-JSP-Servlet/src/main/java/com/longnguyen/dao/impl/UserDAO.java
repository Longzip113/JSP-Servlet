package com.longnguyen.dao.impl;

import java.util.List;

import com.longnguyen.dao.IUserDAO;
import com.longnguyen.mapper.UserMapper;
import com.longnguyen.model.UserModel;

public class UserDAO extends AbsTractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userNam, String passWord, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> user = Query(sql.toString(), new UserMapper(), userNam, passWord, status);
		
		return user.isEmpty() ? null : user.get(0);
	}

}
