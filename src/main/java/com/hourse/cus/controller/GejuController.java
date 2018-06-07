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
import com.hourse.cus.entity.GejuEntity;
import com.hourse.cus.service.GejuService;
import com.hourse.common.utils.PageUtils;
import com.hourse.common.utils.Query;
import com.hourse.common.utils.R;
import com.hourse.common.validator.ValidatorUtils;
import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 格局
 * 
 * @author ye
 * @email 
 * @date 2018-05-14 01:30:35
 */
@Controller
@RequestMapping("/cus/geju")
public class GejuController {
	@Autowired
	private GejuService gejuService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GejuEntity> gejuList = gejuService.queryList(query);
		int total = gejuService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(gejuList, total, query.getLimit(), query.getPage());
		return R.ok().put("total", total).put("rows", gejuList);
		//return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") Integer id){
		GejuEntity geju = gejuService.queryObject(id);
		
		return R.ok().put("geju", geju);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R save(@RequestBody GejuEntity geju){
			  		  	ValidatorUtils.validateEntity(geju, AddGroup.class);
		gejuService.save(geju);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update(@RequestBody GejuEntity geju){
	ValidatorUtils.validateEntity(geju, UpdateGroup.class);
		gejuService.update(geju);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public R delete(@RequestBody Integer[] ids){
		gejuService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/gejuadd.html")
	public String gejuadd(HttpServletRequest req) {

		return "modules/cus/gejuadd.html";
	}

	@RequestMapping("/gejuedit.html")
	public String gejuedit(@RequestParam("id") Integer id,
			HttpServletRequest req) {
		GejuEntity geju = gejuService.queryObject(id);
		
		req.setAttribute("geju", geju);
		return "modules/cus/gejuedit.html";
	}
}
