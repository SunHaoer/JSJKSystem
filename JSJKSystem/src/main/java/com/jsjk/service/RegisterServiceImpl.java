package com.jsjk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsjk.mapper.RegisterMapper;
import com.jsjk.pojo.UserBase;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public boolean saveRegister(UserBase user) {
		// 此处需要添加数据库事务绑定
		registerMapper.saveRegister(user);
		return true;
	}
	
	@Override
	public boolean userNameIsLegal(String userName) {
//System.out.println(userName);
		boolean flag = true;
		UserBase userBase = registerMapper.findUserByUserName(userName);
//System.out.println(userBase);
		if(userName.isEmpty() || userBase != null) {
			flag = false; 
		}
		return flag;
	}
	
}
