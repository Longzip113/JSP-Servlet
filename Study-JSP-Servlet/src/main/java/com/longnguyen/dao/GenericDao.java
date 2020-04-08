package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.mapper.RowMapper;

public interface GenericDao<T> {

	<T> List<T> Query(String sql, RowMapper<T> rowMapper,Object... parameters);
	
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
