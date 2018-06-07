package com.hourse.cus.controller;

import java.util.ArrayList;
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

import com.qiniu.util.StringUtils;
import com.hourse.common.utils.MyBeanUtils;
import com.hourse.common.utils.PageUtils;
import com.hourse.common.utils.Query;
import com.hourse.common.utils.R;
import com.hourse.common.validator.ValidatorUtils;
import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;
import com.hourse.cus.entity.GejuEntity;
import com.hourse.cus.entity.MaterialEntity;
import com.hourse.cus.entity.PlanEntity;
import com.hourse.cus.service.CategoryService;
import com.hourse.cus.service.GejuService;
import com.hourse.cus.service.MaterialService;
import com.hourse.cus.service.PeopleService;
import com.hourse.cus.service.PlanService;
import com.hourse.cus.shiro.ShiroUtils;

/**
 * 装修方案
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 18:01:29
 */
@Controller
@RequestMapping("/cus/plan")
public class PlanController {
	@Autowired
	private PlanService planService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private GejuService gejuService;
	private static HashMap<Integer,MaterialEntity  > prices=new HashMap<Integer,MaterialEntity>();
	private static HashMap<Integer,Float  > peoples=new HashMap<Integer,Float>();
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@ResponseBody
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        if(ShiroUtils.getUserEntity().getUserType()==2){
        	query.put("userId", ShiroUtils.getUserId());
        }
		List<PlanEntity> planList = planService.queryList(query);
		int total = planService.queryTotal(query);
		List<PlanEntity> planList1=new ArrayList<PlanEntity>(); 
		for (PlanEntity planEntity : planList) {
			if(!prices.containsKey(planEntity.getCizhuan())){
				prices.put(planEntity.getCizhuan(), ( materialService.queryObject(planEntity.getCizhuan())));
			}
			if(!prices.containsKey(planEntity.getDiban())){
				prices.put(planEntity.getDiban(), ( materialService.queryObject(planEntity.getDiban())));
			}
			if(!prices.containsKey(planEntity.getBizhi())){
				prices.put(planEntity.getBizhi(), ( materialService.queryObject(planEntity.getBizhi()) ));
			}
			if(!prices.containsKey(planEntity.getMen())){
				prices.put(planEntity.getMen(), ( materialService.queryObject(planEntity.getMen()) ));
			}
			if(!prices.containsKey(planEntity.getWeiyu())){
				prices.put(planEntity.getWeiyu(), ( materialService.queryObject(planEntity.getWeiyu()) ));
			}
			if(!peoples.containsKey(40))
					{
				peoples.put(40,Float.parseFloat( peopleService.queryObject(40).getPrice()));
			}
			if(!peoples.containsKey(41))
			{
				peoples.put(41,Float.parseFloat( peopleService.queryObject(41).getPrice()));
			}

			if(!peoples.containsKey(42))
			{
				peoples.put(42,Float.parseFloat( peopleService.queryObject(42).getPrice()));
			}

			if(!peoples.containsKey(43))
			{
				peoples.put(43,Float.parseFloat( peopleService.queryObject(43).getPrice()));
			}

			if(!peoples.containsKey(44))
			{
				peoples.put(44,Float.parseFloat( peopleService.queryObject(44).getPrice()));
			}

			 
			planList1.add(planEntity);
			
			boolean add=false;
			PlanEntity   planEntity1=new PlanEntity();
			try {
				MyBeanUtils.copyBeanNotNull2Bean(planEntity, planEntity1);
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(params.containsKey("cizhuan")&&!StringUtils.isNullOrEmpty(params.get("cizhuan").toString())){
				 add=true;
				planEntity1.setCizhuan(Integer.parseInt(params.get("cizhuan").toString()));
				if(!prices.containsKey(planEntity1.getCizhuan())){
					prices.put(planEntity1.getCizhuan(), ( materialService.queryObject(planEntity1.getCizhuan()) ));
				}
				
			}
			if(params.containsKey("diban")&&!StringUtils.isNullOrEmpty(params.get("diban").toString())){
				 add=true;
				planEntity1.setDiban(Integer.parseInt(params.get("diban").toString()));
				if(!prices.containsKey(planEntity1.getDiban())){
					prices.put(planEntity1.getDiban(), ( materialService.queryObject(planEntity1.getDiban()) ));
				}
				 
			}
			if(params.containsKey("bizhi")&&!StringUtils.isNullOrEmpty(params.get("bizhi").toString())){
				 add=true;
				planEntity1.setBizhi(Integer.parseInt(params.get("bizhi").toString()));
				 
				if(!prices.containsKey(planEntity1.getBizhi())){
					prices.put(planEntity1.getBizhi(), ( materialService.queryObject(planEntity1.getBizhi()) ));
				}
				 
			}
			if(params.containsKey("men")&&!StringUtils.isNullOrEmpty(params.get("men").toString())){
				 add=true;
				planEntity1.setMen(Integer.parseInt(params.get("men").toString()));
				 
				if(!prices.containsKey(planEntity1.getMen())){
					prices.put(planEntity1.getMen(), ( materialService.queryObject(planEntity1.getMen()) ));
				}
				 
			}
			if(params.containsKey("weiyu")&&!StringUtils.isNullOrEmpty(params.get("weiyu").toString())){
				 add=true;
				planEntity1.setWeiyu(Integer.parseInt(params.get("weiyu").toString()));
				 
				if(!prices.containsKey(planEntity1.getWeiyu())){
					prices.put(planEntity1.getWeiyu(), ( materialService.queryObject(planEntity1.getWeiyu()) ));
				}
			}
			float totalPrice1=0f;
			float totalPrice2=0f;
			int sizebegin=Integer.parseInt(  planEntity.getSize().split("-")[0]);
			int sizeend=Integer.parseInt( planEntity.getSize().split("-")[1]);
			MaterialEntity cizhuan= prices.get(planEntity.getCizhuan());
			GejuEntity geju=gejuService.queryObject(planEntity.getGeju());
			//System.out.println("length"+cizhuan.getSpec().split("//*").length);
			int cizhuansize=Integer.parseInt(cizhuan.getSpec().replace("*", ",").split(",")[0])*Integer.parseInt(cizhuan.getSpec().replace("*", ",").split(",")[1]);
			
			int yongshi1=Integer.parseInt( planEntity.getYongshi().split("-")[0]);
			int yongshi2=Integer.parseInt( planEntity.getYongshi().split("-")[1]);
			totalPrice1=Float.parseFloat(planEntity.getPrice())
					+sizebegin/(cizhuansize/1000000f)*(1+0.05f)*Float.parseFloat(cizhuan.getPrice())
					+Float.parseFloat(prices.get(planEntity.getDiban()).getPrice())*sizebegin*(1+0.05f)
					+Float.parseFloat(prices.get(planEntity.getBizhi()).getPrice())*(geju.getColumn1()+geju .getColumn2()+geju.getColumn3()+geju.getColumn4()+geju.getColumn5())//灯具
					+Float.parseFloat(prices.get(planEntity.getMen()).getPrice())*sizebegin/125//涂料
					+Float.parseFloat(prices.get(planEntity.getWeiyu()).getPrice())*(1)
					+yongshi1*(peoples.get(40)+peoples.get(41)+peoples.get(42)+peoples.get(43)+peoples.get(44));
			totalPrice2=Float.parseFloat(planEntity.getPrice())
					+sizeend/(cizhuansize/1000000f)*(1+0.05f)*Float.parseFloat(cizhuan.getPrice())
					+Float.parseFloat(prices.get(planEntity.getDiban()).getPrice())*sizeend*(1+0.05f)
					+Float.parseFloat(prices.get(planEntity.getBizhi()).getPrice())*(geju.getColumn1()+geju .getColumn2()+geju.getColumn3()+geju.getColumn4()+geju.getColumn5())//灯具
					+Float.parseFloat(prices.get(planEntity.getMen()).getPrice())*sizeend/125//涂料
					+Float.parseFloat(prices.get(planEntity.getWeiyu()).getPrice())*(1)
					+yongshi2*(peoples.get(40)+peoples.get(41)+peoples.get(42)+peoples.get(43)+peoples.get(44));
			
			planEntity.setTotalPrice(  totalPrice1 +"-"+totalPrice2);
			if(add){
				float totalPrice11=0f;
				float totalPrice21=0f;
				int sizebegin1=Integer.parseInt(  planEntity1.getSize().split("-")[0]);
				int sizeend1=Integer.parseInt( planEntity1.getSize().split("-")[1]);
				int yongshi11=Integer.parseInt( planEntity1.getYongshi().split("-")[0]);
				int yongshi21=Integer.parseInt( planEntity1.getYongshi().split("-")[1]);
				MaterialEntity cizhuan1= prices.get(planEntity1.getCizhuan());
				GejuEntity geju1=gejuService.queryObject(planEntity1.getGeju());
				int cizhuansize1=Integer.parseInt(cizhuan.getSpec().replace("*", ",").split(",")[0])*Integer.parseInt(cizhuan.getSpec().replace("*", ",").split(",")[1]);
				
				totalPrice11=Float.parseFloat(planEntity1.getPrice())
						+sizebegin1/(cizhuansize1/1000000f)*(1+0.05f)*Float.parseFloat(cizhuan1.getPrice())
						+Float.parseFloat(prices.get(planEntity1.getDiban()).getPrice())*sizebegin1*(1+0.05f)
						+Float.parseFloat(prices.get(planEntity1.getBizhi()).getPrice())*(geju1.getColumn1()+geju1 .getColumn2()+geju1.getColumn3()+geju1.getColumn4()+geju1.getColumn5())//灯具
						+Float.parseFloat(prices.get(planEntity1.getMen()).getPrice())*sizebegin1/125//涂料
						+Float.parseFloat(prices.get(planEntity1.getWeiyu()).getPrice())*(1)
						+yongshi11*(peoples.get(40)+peoples.get(41)+peoples.get(42)+peoples.get(43)+peoples.get(44));
			totalPrice21=Float.parseFloat(planEntity1.getPrice())
					+sizeend1/(cizhuansize1/1000000f)*(1+0.05f)*Float.parseFloat(cizhuan1.getPrice())
					+Float.parseFloat(prices.get(planEntity1.getDiban()).getPrice())*sizeend1*(1+0.05f)
					+Float.parseFloat(prices.get(planEntity1.getBizhi()).getPrice())*(geju1.getColumn1()+geju1 .getColumn2()+geju1.getColumn3()+geju1.getColumn4()+geju1.getColumn5())//灯具
					+Float.parseFloat(prices.get(planEntity1.getMen()).getPrice())*sizeend1/125//涂料
					+Float.parseFloat(prices.get(planEntity1.getWeiyu()).getPrice())*(1)
					+yongshi21*(peoples.get(40)+peoples.get(41)+peoples.get(42)+peoples.get(43)+peoples.get(44));
			
				planEntity1.setTotalPrice(  totalPrice11 +"-"+totalPrice21);	
				
				StringBuffer description=new StringBuffer();
				description.append("基本配置:");
				description.append("瓷砖:").append(materialService.queryObject(planEntity1.getCizhuan()).getName());
				description.append("地板:").append(materialService.queryObject(planEntity1.getDiban()).getName());
				description.append("壁纸:").append(materialService.queryObject(planEntity1.getBizhi()).getName());
				description.append("门:").append(materialService.queryObject(planEntity1.getMen()).getName());
				description.append("卫浴:").append(materialService.queryObject(planEntity1.getWeiyu()).getName());
				
//				planEntity1.setDescription(description.toString());
				planEntity.setPeizhi(description.toString());
				planList1.add(planEntity1);
			}
			
		}
		
		PageUtils pageUtil = new PageUtils(planList1, planList1.size(), query.getLimit(), query.getPage());
		return R.ok().put("total", planList1.size()).put("rows", planList1);
		//return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@ResponseBody
	public R info(@PathVariable("id") Integer id){
		PlanEntity plan = planService.queryObject(id);
		
		return R.ok().put("plan", plan);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R save(@RequestBody PlanEntity plan){
		String[] sizes=plan.getSize().split("-");	  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  	
		plan.setSizeBegin(Integer.parseInt(sizes[0]));
		plan.setSizeEnd(Integer.parseInt(sizes[1]));;
		if(ShiroUtils.getUserEntity().getUserType()==2)
		plan.setUserId(ShiroUtils.getUserId().intValue());
		StringBuffer description=new StringBuffer();
		description.append("基本配置:");
		description.append("瓷砖:").append(materialService.queryObject(plan.getCizhuan()).getName());
		description.append("地板:").append(materialService.queryObject(plan.getDiban()).getName());
		description.append("壁纸:").append(materialService.queryObject(plan.getBizhi()).getName());
		description.append("门:").append(materialService.queryObject(plan.getMen()).getName());
		description.append("卫浴:").append(materialService.queryObject(plan.getWeiyu()).getName());
		
//		plan.setDescription(description.toString());
		plan.setPeizhi(description.toString());
		ValidatorUtils.validateEntity(plan, AddGroup.class);
		planService.save(plan);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update(@RequestBody PlanEntity plan){
		String[] sizes=plan.getSize().split("-");	  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  		  	
		plan.setSizeBegin(Integer.parseInt(sizes[0]));
		plan.setSizeEnd(Integer.parseInt(sizes[1]));;
		if(ShiroUtils.getUserEntity().getUserType()==2)
		plan.setUserId(ShiroUtils.getUserId().intValue());
		StringBuffer description=new StringBuffer();
		description.append("基本配置:");
		description.append("瓷砖:").append(materialService.queryObject(plan.getCizhuan()).getName());
		description.append("地板:").append(materialService.queryObject(plan.getDiban()).getName());
		description.append("壁纸:").append(materialService.queryObject(plan.getBizhi()).getName());
		description.append("门:").append(materialService.queryObject(plan.getMen()).getName());
		description.append("卫浴:").append(materialService.queryObject(plan.getWeiyu()).getName());
		
//		plan.setDescription(description.toString());
		plan.setPeizhi(description.toString());
	ValidatorUtils.validateEntity(plan, UpdateGroup.class);
		planService.update(plan);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public R delete(@RequestBody Integer[] ids){
		planService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/plan.html")
	public String plan(HttpServletRequest req) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		req.setAttribute("geju",gejuService.queryList(map));
		map.put("typeId",40);//瓷砖
		req.setAttribute("cizhuan",materialService.queryList(map));
	
		map.put("typeId",41);//地板
		req.setAttribute("diban",materialService.queryList(map));
		
		map.put("typeId",42);//壁纸
		req.setAttribute("bizhi",materialService.queryList(map));
		
		map.put("typeId",43);//门
		req.setAttribute("men",materialService.queryList(map));
		map.put("typeId",44);//卫浴
		req.setAttribute("weiyu",materialService.queryList(map));
		
		return "modules/cus/plan.html";
	}
	@RequestMapping("/planadd.html")
	public String planadd(HttpServletRequest req) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		req.setAttribute("geju",gejuService.queryList(map));
	//	map.put("userId", ShiroUtils.getUserId().intValue());
		map.put("typeId",40);//瓷砖
		req.setAttribute("cizhuan",materialService.queryList(map));
	
		map.put("typeId",41);//地板
		req.setAttribute("diban",materialService.queryList(map));
		
		map.put("typeId",42);//壁纸
		req.setAttribute("bizhi",materialService.queryList(map));
		
		map.put("typeId",43);//门
		req.setAttribute("men",materialService.queryList(map));
		map.put("typeId",44);//卫浴
		req.setAttribute("weiyu",materialService.queryList(map));
		
		return "modules/cus/planadd.html";
	}

	@RequestMapping("/planedit.html")
	public String planedit(@RequestParam("id") Integer id,
			HttpServletRequest req) {
		PlanEntity plan = planService.queryObject(id);
		HashMap<String,Object> map=new HashMap<String,Object>();
		req.setAttribute("geju",gejuService.queryList(map));
		map.put("typeId",40);//瓷砖
		req.setAttribute("cizhuan",materialService.queryList(map));
	
		map.put("typeId",41);//地板
		req.setAttribute("diban",materialService.queryList(map));
		
		map.put("typeId",42);//壁纸
		req.setAttribute("bizhi",materialService.queryList(map));
		
		map.put("typeId",43);//门
		req.setAttribute("men",materialService.queryList(map));
		map.put("typeId",44);//卫浴
		req.setAttribute("weiyu",materialService.queryList(map));
		
		req.setAttribute("plan", plan);
		return "modules/cus/planedit.html";
	}
	
	public static void main(String[] args) {
		String s="22*30";
		System.out.println(s.replace("*", ",").split(",").length);
		System.out.println(s.split("").length);
	}
}
