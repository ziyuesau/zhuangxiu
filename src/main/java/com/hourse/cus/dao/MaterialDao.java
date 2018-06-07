package com.hourse.cus.dao;

import com.hourse.cus.entity.MaterialEntity;
import com.hourse.cus.dao.BaseDao;
/**
 * 材料
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:38
 */
public interface MaterialDao extends BaseDao<MaterialEntity> {
	String queryBrand();
	 
}
