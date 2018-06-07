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
import com.hourse.cus.entity.PeopleEntity;
import com.hourse.cus.service.PeopleService;
import com.hourse.common.utils.PageUtils;
import com.hourse.common.utils.Query;
import com.hourse.common.utils.R;
import com.hourse.common.validator.ValidatorUtils;
import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 人工成本
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:39
 */
@Controller
@RequestMapping("/cus/people")
public class PeopleController {
	@Autowired
	private PeopleService peopleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PeopleEntity> peopleList = peopleService.queryList(query);
		int total = peopleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(peopleList, total, query.getLimit(), query.getPage());
		return R.ok().put("total", total).put("rows", peopleList);
		//return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") Integer id){
		PeopleEntity people = peopleService.queryObject(id);
		
		return R.ok().put("people", people);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R save(@RequestBody PeopleEntity people){
			  		  		  	ValidatorUtils.validateEntity(people, AddGroup.class);
		peopleService.save(people);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update(@RequestBody PeopleEntity people){
	ValidatorUtils.validateEntity(people, UpdateGroup.class);
		peopleService.update(people);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public R delete(@RequestBody Integer[] ids){
		peopleService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/peopleadd.html")
	public String peopleadd(HttpServletRequest req) {

		return "modules/cus/peopleadd.html";
	}

	@RequestMapping("/peopleedit.html")
	public String peopleedit(@RequestParam("id") Integer id,
			HttpServletRequest req) {
		PeopleEntity people = peopleService.queryObject(id);
		
		req.setAttribute("people", people);
		return "modules/cus/peopleedit.html";
	}
}
