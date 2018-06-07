package com.hourse.cus.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 人工成本
 * 
 * @author ye
 * @email 
 * @date 2018-05-13 00:28:39
 */
public class PeopleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//种类
	private String name;
	//单价
	private String price;

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
	 * 设置：种类
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：种类
	 */
	public String getName() {
		return name;
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
}
