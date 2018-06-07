package com.hourse.cus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hourse.cus.dao.PlanDao;
import com.hourse.cus.entity.PlanEntity;
import com.hourse.cus.service.PlanService;



@Service("planService")
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanDao planDao;
	
	@Override
	public PlanEntity queryObject(Integer id){
		return planDao.queryObject(id);
	}
	
	@Override
	public List<PlanEntity> queryList(Map<String, Object> map){
		return planDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return planDao.queryTotal(map);
	}
	
	@Override
	public void save(PlanEntity plan){
		planDao.save(plan);
	}
	
	@Override
	public void update(PlanEntity plan){
		planDao.update(plan);
	}
	
	@Override
	public void delete(Integer id){
		planDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		planDao.deleteBatch(ids);
	}
	
}
