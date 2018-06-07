package com.hourse.cus.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 装修方案
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 18:01:29
 */
public class PlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//面积
	private String size;
	//格局
	private Integer geju;
	private String gejuName;
	//档次
	private Integer dangci;
	//风格
	private Integer style;
	//方案介绍
	private String description;
	//图片
	private String pic;
	//预计费用
	private String price;
	//预计用时
	private String yongshi;
	//公司
	private Integer userId;
	//
	private Integer sizeBegin;
	//
	private Integer sizeEnd;
	//瓷砖
	private Integer cizhuan;
	private String cizhuanName;
	//地板
	private Integer diban;
	private String dibanName;
	
	//壁纸
	private Integer bizhi;
	private String bizhiName;
	
	//门
	private Integer men;
	private String menName;
	//卫浴
	private Integer weiyu;
	private String weiyuName;
	//水工
	private Integer people1;
	//电工
	private Integer people2;
	//油工
	private Integer people3;
	//木工
	private Integer people4;
	//水工
	private Integer people5;
	
	private String totalPrice;
	
	private String companyName;
	
	private String phone;

	private String peizhi;
	
	
	public String getPeizhi() {
		return peizhi;
	}
	public void setPeizhi(String peizhi) {
		this.peizhi = peizhi;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGejuName() {
		return gejuName;
	}
	public void setGejuName(String gejuName) {
		this.gejuName = gejuName;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCizhuanName() {
		return cizhuanName;
	}
	public void setCizhuanName(String cizhuanName) {
		this.cizhuanName = cizhuanName;
	}
	public String getDibanName() {
		return dibanName;
	}
	public void setDibanName(String dibanName) {
		this.dibanName = dibanName;
	}
	public String getBizhiName() {
		return bizhiName;
	}
	public void setBizhiName(String bizhiName) {
		this.bizhiName = bizhiName;
	}
	public String getMenName() {
		return menName;
	}
	public void setMenName(String menName) {
		this.menName = menName;
	}
	public String getWeiyuName() {
		return weiyuName;
	}
	public void setWeiyuName(String weiyuName) {
		this.weiyuName = weiyuName;
	}
	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：面积
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * 获取：面积
	 */
	public String getSize() {
		return size;
	}
	/**
	 * 设置：格局
	 */
	public void setGeju(Integer geju) {
		this.geju = geju;
	}
	/**
	 * 获取：格局
	 */
	public Integer getGeju() {
		return geju;
	}
	/**
	 * 设置：档次
	 */
	public void setDangci(Integer dangci) {
		this.dangci = dangci;
	}
	/**
	 * 获取：档次
	 */
	public Integer getDangci() {
		return dangci;
	}
	/**
	 * 设置：风格
	 */
	public void setStyle(Integer style) {
		this.style = style;
	}
	/**
	 * 获取：风格
	 */
	public Integer getStyle() {
		return style;
	}
	/**
	 * 设置：方案介绍
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：方案介绍
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：图片
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：图片
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：预计费用
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：预计费用
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：预计用时
	 */
	public void setYongshi(String yongshi) {
		this.yongshi = yongshi;
	}
	/**
	 * 获取：预计用时
	 */
	public String getYongshi() {
		return yongshi;
	}
	/**
	 * 设置：公司
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：公司
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setSizeBegin(Integer sizeBegin) {
		this.sizeBegin = sizeBegin;
	}
	/**
	 * 获取：
	 */
	public Integer getSizeBegin() {
		return sizeBegin;
	}
	/**
	 * 设置：
	 */
	public void setSizeEnd(Integer sizeEnd) {
		this.sizeEnd = sizeEnd;
	}
	/**
	 * 获取：
	 */
	public Integer getSizeEnd() {
		return sizeEnd;
	}
	/**
	 * 设置：瓷砖
	 */
	public void setCizhuan(Integer cizhuan) {
		this.cizhuan = cizhuan;
	}
	/**
	 * 获取：瓷砖
	 */
	public Integer getCizhuan() {
		return cizhuan;
	}
	/**
	 * 设置：地板
	 */
	public void setDiban(Integer diban) {
		this.diban = diban;
	}
	/**
	 * 获取：地板
	 */
	public Integer getDiban() {
		return diban;
	}
	/**
	 * 设置：壁纸
	 */
	public void setBizhi(Integer bizhi) {
		this.bizhi = bizhi;
	}
	/**
	 * 获取：壁纸
	 */
	public Integer getBizhi() {
		return bizhi;
	}
	/**
	 * 设置：门
	 */
	public void setMen(Integer men) {
		this.men = men;
	}
	/**
	 * 获取：门
	 */
	public Integer getMen() {
		return men;
	}
	/**
	 * 设置：卫浴
	 */
	public void setWeiyu(Integer weiyu) {
		this.weiyu = weiyu;
	}
	/**
	 * 获取：卫浴
	 */
	public Integer getWeiyu() {
		return weiyu;
	}
	/**
	 * 设置：水工
	 */
	public void setPeople1(Integer people1) {
		this.people1 = people1;
	}
	/**
	 * 获取：水工
	 */
	public Integer getPeople1() {
		return people1;
	}
	/**
	 * 设置：电工
	 */
	public void setPeople2(Integer people2) {
		this.people2 = people2;
	}
	/**
	 * 获取：电工
	 */
	public Integer getPeople2() {
		return people2;
	}
	/**
	 * 设置：油工
	 */
	public void setPeople3(Integer people3) {
		this.people3 = people3;
	}
	/**
	 * 获取：油工
	 */
	public Integer getPeople3() {
		return people3;
	}
	/**
	 * 设置：木工
	 */
	public void setPeople4(Integer people4) {
		this.people4 = people4;
	}
	/**
	 * 获取：木工
	 */
	public Integer getPeople4() {
		return people4;
	}
	/**
	 * 设置：水工
	 */
	public void setPeople5(Integer people5) {
		this.people5 = people5;
	}
	/**
	 * 获取：水工
	 */
	public Integer getPeople5() {
		return people5;
	}
}
