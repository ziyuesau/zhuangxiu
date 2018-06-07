package com.hourse.cus.service;

import com.hourse.cus.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 材料种类
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:38
 */
public interface CategoryService {
	
	CategoryEntity queryObject(Integer id);
	
	List<CategoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CategoryEntity category);
	
	void update(CategoryEntity category);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
