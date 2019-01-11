package com.jsjk.mapper;

import org.apache.ibatis.annotations.Param;

import com.jsjk.pojo.UserBase;

public interface RegisterMapper {
	
	/**
	 * 将注册信息插入数据库
	 * @param user
	 */
	public void saveRegister(UserBase user);
	
	/**
	 * 根据注册用户的id建立数据表
	 * @param userId
	 */
	public void createUserDataTable(@Param("tableName")String tableName);
	
	/**
	 * 根据userName查user
	 * @param userName
	 */
	public UserBase findUserByUserName(@Param("userName") String userName);
	
	/**
	 * 根据userPhone查user
	 * @param userPhone
	 */
	public UserBase findUserByUserPhone(@Param("userPhone") String userPhone);
	
}
