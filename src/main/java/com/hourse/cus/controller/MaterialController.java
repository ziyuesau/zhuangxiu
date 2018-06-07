package com.hourse.cus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.hourse.common.validator.ValidatorUtils;
import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;
import com.hourse.cus.entity.MaterialEntity;
import com.hourse.cus.service.CategoryService;
import com.hourse.cus.service.MaterialService;

/**
 * 材料
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:38
 */
@Controller
@RequestMapping("/cus/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	@Autowired
	private CategoryService categoryService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MaterialEntity> materialList = materialService.queryList(query);
		int total = materialService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(materialList, total, query.getLimit(), query.getPage());
		return R.ok().put("total", total).put("rows", materialList);
		//return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") Integer id){
		MaterialEntity material = materialService.queryObject(id);
		
		return R.ok().put("material", material);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R save(@RequestBody MaterialEntity material){
			  		  		  		  		  		  		  		  	ValidatorUtils.validateEntity(material, AddGroup.class);
		materialService.save(material);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update(@RequestBody MaterialEntity material){
	ValidatorUtils.validateEntity(material, UpdateGroup.class);
		materialService.update(material);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public R delete(@RequestBody Integer[] ids){
		materialService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/materialadd.html")
	public String materialadd(HttpServletRequest req) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		req.setAttribute("list",categoryService.queryList(map));
		return "modules/cus/materialadd.html";
	}

	@RequestMapping("/materialedit.html")
	public String materialedit(@RequestParam("id") Integer id,
			HttpServletRequest req) {
		MaterialEntity material = materialService.queryObject(id);
		HashMap<String,Object> map=new HashMap<String,Object>();
		req.setAttribute("list",categoryService.queryList(map));
		
		req.setAttribute("material", material);
		return "modules/cus/materialedit.html";
	}
}
