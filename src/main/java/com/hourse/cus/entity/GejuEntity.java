package com.hourse.cus.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.hourse.common.validator.group.AddGroup;
import com.hourse.common.validator.group.UpdateGroup;

/**
 * 格局
 * 
 * @author ye
 * @email 
 * @date 2018-05-14 01:30:35
 */
public class GejuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//格局
	private String name;
	
	private Integer column1;
	private Integer column2;
	private Integer column3;
	private Integer column4;
	private Integer column5;

	public Integer getColumn5() {
		return column5;
	}
	public void setColumn5(Integer column5) {
		this.column5 = column5;
	}
	public Integer getColumn1() {
		return column1;
	}
	public void setColumn1(Integer column1) {
		this.column1 = column1;
	}
	public Integer getColumn2() {
		return column2;
	}
	public void setColumn2(Integer column2) {
		this.column2 = column2;
	}
	public Integer getColumn3() {
		return column3;
	}
	public void setColumn3(Integer column3) {
		this.column3 = column3;
	}
	public Integer getColumn4() {
		return column4;
	}
	public void setColumn4(Integer column4) {
		this.column4 = column4;
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
	 * 设置：格局
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：格局
	 */
	public String getName() {
		return name;
	}
}
