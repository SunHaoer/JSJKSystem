package com.jsjk.mapper;

import org.apache.ibatis.annotations.Param;

import com.jsjk.pojo.UserBase;

public interface LoginMapper {
	
	/**
	 * 根据username和password查user
	 * @param userName
	 */
	public UserBase login(@Param("username") String userName, @Param("password") String password);
}
