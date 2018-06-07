package com.hourse.cus.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 材料
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:38
 */
public class MaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//材料名称
	private String name;
	//材料种类
	private Integer typeId;
	private String type;
	
	//材料品牌
	private String brand;
	//材料规格
	private String spec;
	//材料介绍
	private String description;
	//单价
	private String price;
	//单位
	private String unit;
	
	private Integer userId;
	private String companyName;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	 * 设置：材料名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：材料名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：材料种类
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：材料种类
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * 设置：材料品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：材料品牌
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：材料规格
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	 * 获取：材料规格
	 */
	public String getSpec() {
		return spec;
	}
	/**
	 * 设置：材料介绍
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：材料介绍
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
	}
}
