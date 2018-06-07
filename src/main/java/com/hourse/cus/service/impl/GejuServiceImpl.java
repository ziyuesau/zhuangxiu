package com.hourse.cus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hourse.cus.dao.GejuDao;
import com.hourse.cus.entity.GejuEntity;
import com.hourse.cus.service.GejuService;



@Service("gejuService")
public class GejuServiceImpl implements GejuService {
	@Autowired
	private GejuDao gejuDao;
	
	@Override
	public GejuEntity queryObject(Integer id){
		return gejuDao.queryObject(id);
	}
	
	@Override
	public List<GejuEntity> queryList(Map<String, Object> map){
		return gejuDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return gejuDao.queryTotal(map);
	}
	
	@Override
	public void save(GejuEntity geju){
		gejuDao.save(geju);
	}
	
	@Override
	public void update(GejuEntity geju){
		gejuDao.update(geju);
	}
	
	@Override
	public void delete(Integer id){
		gejuDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		gejuDao.deleteBatch(ids);
	}
	
}
