package com.bootdo.pms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 测试表
 * 
 * @author boge
 * @email 1992lcg@163.com
 * @date 2018-01-31 19:52:09
 */
public class MyTableDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	//
	private String value;
	//
	private Integer rev;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：
	 */
	public void setRev(Integer rev) {
		this.rev = rev;
	}
	/**
	 * 获取：
	 */
	public Integer getRev() {
		return rev;
	}
}
