package com.hourse.cus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hourse.common.utils.PageUtils;
import com.hourse.common.utils.Query;
import com.hourse.common.utils.R;
import com.hourse.common.validator.Assert;
import com.hourse.common.validator.ValidatorUtils;
import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;
import com.hourse.cus.entity.SysUserEntity;
import com.hourse.cus.shiro.ShiroUtils;
import com.hourse.cus.service.SysUserService;

/**
 * 系统用户
 * 
 * @author ye
 * 
 * @date 2016年10月31日 上午10:40:10
 */
@Controller
@RequestMapping("/cus/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService cusUserService;
	 

 

	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	// @RequiresPermissions("cus:user:list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = cusUserService.queryList(query);
		int total = cusUserService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(),
				query.getPage());
		return R.ok().put("total", total).put("rows", userList);
		// return R.ok().put("page", pageUtil);
	}

	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/myinfo")
	@ResponseBody
	public R myinfo() {
		return R.ok().put("user", getUser());
	}

	@RequestMapping("/useradd.html")
	public String useradd(HttpServletRequest req) {
		HashMap<String,Object> map=new HashMap<String,Object>();
	 
		return "modules/cus/useradd.html";
	}

	@RequestMapping("/useredit.html")
	public String useredit(@RequestParam("id") Long userId,
			HttpServletRequest req) {
		SysUserEntity user = cusUserService.queryObject(userId);

		HashMap<String,Object> map=new HashMap<String,Object>();
		 
		req.setAttribute("user", user);
		return "modules/cus/useredit.html";
	}
	@RequestMapping("/userinfo.html")
	public String userinfo(  
			HttpServletRequest req) {
		SysUserEntity user = cusUserService.queryObject(ShiroUtils.getUserId());

		
		return "modules/cus/userinfo.html";
	}
	/**
	 * 修改登录用户密码
	 */
	@RequestMapping("/password")
	@ResponseBody
	public R password(String password, String newPassword) {
		Assert.isBlank(newPassword, "新密码不为能空");

		// 原密码
		password = ShiroUtils.sha256(password, getUser().getSalt());
		// 新密码
		newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());

		// 更新密码
		int count = cusUserService.updatePassword(getUserId(), password,
				newPassword);
		if (count == 0) {
			return R.error("原密码不正确");
		}

		return R.ok();
	}

	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	 
	// @RequiresPermissions("cus:user:info")
	public String info(@PathVariable("userId") Long userId,
			HttpServletRequest req) {
		SysUserEntity user = cusUserService.queryObject(userId);
	 
		req.setAttribute("user", user);
		return "modules/cus/userinfo.html";
	
	 
	}

	/**
	 * 保存用户
	 */
	@RequestMapping("/save")
	@ResponseBody
	// @RequiresPermissions("cus:user:save")
	public R save(@RequestBody SysUserEntity user) {
		 
		ValidatorUtils.validateEntity(user, AddGroup.class);

		cusUserService.save(user);

		return R.ok();
	}

	/**
	 * 修改用户
	 */
	@RequestMapping("/update")
	@ResponseBody
	// @RequiresPermissions("cus:user:update")
	public R update(@RequestBody SysUserEntity user) {
		ValidatorUtils.validateEntity(user, UpdateGroup.class);

		cusUserService.update(user);

		return R.ok();
	}

	/**
	 * 删除用户
	 */

	@RequestMapping("/delete")
	@ResponseBody
	// @RequiresPermissions("cus:user:delete")
	public R delete(@RequestBody Long[] userIds) {
		if (ArrayUtils.contains(userIds, 1L)) {
			return R.error("系统管理员不能删除");
		}

		if (ArrayUtils.contains(userIds, getUserId())) {
			return R.error("当前用户不能删除");
		}

		cusUserService.deleteBatch(userIds);

		return R.ok();
	}
}
