package com.hourse.cus.service;

import com.hourse.cus.entity.GejuEntity;

import java.util.List;
import java.util.Map;

/**
 * 格局
 * 
 * @author ye
 * @email 
 * @date 2018-05-14 01:30:35
 */
public interface GejuService {
	
	GejuEntity queryObject(Integer id);
	
	List<GejuEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GejuEntity geju);
	
	void update(GejuEntity geju);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
