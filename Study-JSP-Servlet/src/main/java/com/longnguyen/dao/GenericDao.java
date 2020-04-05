package com.longnguyen.dao;

import java.util.List;

import com.longnguyen.mapper.RowMapper;

public interface GenericDao<T> {

	<T> List<T> Query(String sql, RowMapper<T> rowMapper,Object... parameters);
}
