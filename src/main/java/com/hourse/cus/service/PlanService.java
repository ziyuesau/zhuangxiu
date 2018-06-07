package com.hourse.cus.service;

import com.hourse.cus.entity.PlanEntity;

import java.util.List;
import java.util.Map;

/**
 * 装修方案
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 18:01:29
 */
public interface PlanService {
	
	PlanEntity queryObject(Integer id);
	
	List<PlanEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PlanEntity plan);
	
	void update(PlanEntity plan);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
