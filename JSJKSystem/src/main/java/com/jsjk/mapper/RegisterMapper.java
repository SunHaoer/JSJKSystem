package com.jsjk.mapper;

import org.springframework.stereotype.Repository;

import com.jsjk.pojo.UserBase;

public interface RegisterMapper {
	
	/**
	 * 将注册信息插入数据库
	 * @param user
	 */
	public void saveRegister(UserBase user);
	
}
