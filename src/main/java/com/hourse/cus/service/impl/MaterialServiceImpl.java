package com.hourse.cus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hourse.cus.dao.MaterialDao;
import com.hourse.cus.entity.MaterialEntity;
import com.hourse.cus.service.MaterialService;



@Service("materialService")
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao materialDao;
	
	@Override
	public MaterialEntity queryObject(Integer id){
		return materialDao.queryObject(id);
	}
	
	@Override
	public List<MaterialEntity> queryList(Map<String, Object> map){
		return materialDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return materialDao.queryTotal(map);
	}
	
	@Override
	public void save(MaterialEntity material){
		materialDao.save(material);
	}
	
	@Override
	public void update(MaterialEntity material){
		materialDao.update(material);
	}
	
	@Override
	public void delete(Integer id){
		materialDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		materialDao.deleteBatch(ids);
	}
	
}
