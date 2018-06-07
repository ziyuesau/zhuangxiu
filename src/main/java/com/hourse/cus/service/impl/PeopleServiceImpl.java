package com.hourse.cus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.hourse.cus.dao.PeopleDao;
import com.hourse.cus.entity.PeopleEntity;
import com.hourse.cus.service.PeopleService;



@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
	@Autowired
	private PeopleDao peopleDao;
	
	@Override
	public PeopleEntity queryObject(Integer id){
		return peopleDao.queryObject(id);
	}
	
	@Override
	public List<PeopleEntity> queryList(Map<String, Object> map){
		return peopleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return peopleDao.queryTotal(map);
	}
	
	@Override
	public void save(PeopleEntity people){
		peopleDao.save(people);
	}
	
	@Override
	public void update(PeopleEntity people){
		peopleDao.update(people);
	}
	
	@Override
	public void delete(Integer id){
		peopleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		peopleDao.deleteBatch(ids);
	}
	
}
