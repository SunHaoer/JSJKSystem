package com.jsjk.service;

import com.jsjk.pojo.UserBase;

public interface RegisterService {
	
	/**
	 * 处理合法的注册信息
	 * @param user
	 */
	public boolean saveRegister(UserBase user);
	
	/**
	 * 验证userName是否合法
	 * @param userName
	 * @return
	 */
	public boolean userNameIsLegal(String userName);

}
