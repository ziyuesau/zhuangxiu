package com.hourse.cus.service;

import com.hourse.cus.entity.PeopleEntity;

import java.util.List;
import java.util.Map;

/**
 * 人工成本
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:39
 */
public interface PeopleService {
	
	PeopleEntity queryObject(Integer id);
	
	List<PeopleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PeopleEntity people);
	
	void update(PeopleEntity people);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
