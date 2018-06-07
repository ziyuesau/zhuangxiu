package com.hourse.cus.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hourse.cus.entity.SysUserEntity;
import com.hourse.cus.shiro.ShiroUtils;
import com.hourse.cus.dao.SysUserDao;
import com.hourse.cus.service.SysUserService;


/**
 * 系统用户
 * 
 * @author ye
 *  
 * @date 2016年9月18日 上午9:46:09
 */
@Service("cusUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao cusUserDao;
 

	 

	@Override
	public SysUserEntity queryByUserName(String username) {
		return cusUserDao.queryByUserName(username);
	}
	
	@Override
	public SysUserEntity queryObject(Long userId) {
		return cusUserDao.queryObject(userId);
	}

	@Override
	 
	public List<SysUserEntity> queryList(Map<String, Object> map){
		return cusUserDao.queryList(map);
	}
	
	@Override
	 
	public int queryTotal(Map<String, Object> map) {
		return cusUserDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysUserEntity user) {
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setSalt(salt);
		user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		cusUserDao.save(user);
		
	 	}

	@Override
	@Transactional
	public void update(SysUserEntity user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
		}
		cusUserDao.update(user);
		
		 	}

	@Override
	@Transactional
	public void deleteBatch(Long[] userId) {
		cusUserDao.deleteBatch(userId);
	}

	@Override
	public int updatePassword(Long userId, String password, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		map.put("newPassword", newPassword);
		return cusUserDao.updatePassword(map);
	}

}
