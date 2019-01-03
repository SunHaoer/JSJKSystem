package com.jsjk.service;

import com.jsjk.pojo.UserBase;

public interface RegisterService {
	
	/**
	 * 校验userName唯一
	 * @param userName
	 * @return
	 */
	public boolean notExistUserName(String userName);
	
	/**
	 * 校验phone唯一
	 * @param phone
	 * @return
	 */
	public boolean notExistPhone(String phone);
	
	/**
	 * 处理合法的注册信息
	 * @param user
	 */
	public void saveRegister(UserBase user);
	
}
