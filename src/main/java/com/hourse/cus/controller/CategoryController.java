package com.hourse.cus.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import com.hourse.cus.entity.CategoryEntity;
import com.hourse.cus.service.CategoryService;
import com.hourse.common.utils.PageUtils;
import com.hourse.common.utils.Query;
import com.hourse.common.utils.R;
import com.hourse.common.validator.ValidatorUtils;
import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 材料种类
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:38
 */
@Controller
@RequestMapping("/cus/category")
public class CategoryController {
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

		List<CategoryEntity> categoryList = categoryService.queryList(query);
		int total = categoryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(categoryList, total, query.getLimit(), query.getPage());
		return R.ok().put("total", total).put("rows", categoryList);
		//return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") Integer id){
		CategoryEntity category = categoryService.queryObject(id);
		
		return R.ok().put("category", category);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R save(@RequestBody CategoryEntity category){
			  		  	ValidatorUtils.validateEntity(category, AddGroup.class);
		categoryService.save(category);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update(@RequestBody CategoryEntity category){
	ValidatorUtils.validateEntity(category, UpdateGroup.class);
		categoryService.update(category);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public R delete(@RequestBody Integer[] ids){
		categoryService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/categoryadd.html")
	public String categoryadd(HttpServletRequest req) {

		return "modules/cus/categoryadd.html";
	}

	@RequestMapping("/categoryedit.html")
	public String categoryedit(@RequestParam("id") Integer id,
			HttpServletRequest req) {
		CategoryEntity category = categoryService.queryObject(id);
		
		req.setAttribute("category", category);
		return "modules/cus/categoryedit.html";
	}
}
