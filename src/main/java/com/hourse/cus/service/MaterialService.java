package com.hourse.cus.service;

import com.hourse.cus.entity.MaterialEntity;

import java.util.List;
import java.util.Map;

/**
 * 材料
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:38
 */
public interface MaterialService {
	
	MaterialEntity queryObject(Integer id);
	
	List<MaterialEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MaterialEntity material);
	
	void update(MaterialEntity material);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
