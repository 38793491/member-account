/* 
 * BasePojo.java  
 * 
 * version 1.0
 *
 * 2015年8月21日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.pojo;

/**
 * Resprent Pojo,all pojo should extends this class
 *
 * @author yangying
 * @version
 * @date 2015年8月21日 上午10:36:56
 * @since
 */
public abstract class Pojo {
	/**
	 * Primary Key
	 */
	protected long id;

	public abstract long getId();

	public void setId(long id) {
		this.id = id;
	}
}
