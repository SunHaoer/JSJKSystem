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
	public boolean notExistUserName(String userName) {
		//System.out.println("2\n\n\n\n");
		boolean isLegal = true;
		//System.out.println(userName + "合法");
		return isLegal;
	}

	@Override
	public boolean notExistPhone(String phone) {
		boolean isLegal = true;
		//System.out.println(phone + "合法");
		return isLegal;
	}

	@Override
	public void saveRegister(UserBase user) {
		registerMapper.saveRegister(user);
		registerMapper.createUserDataTable("user_" + user.getUserId() + "_datatable");
		System.out.println(user.getUserId() + "\n\n");
	}

}
