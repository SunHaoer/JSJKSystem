package com.jsjk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsjk.mapper.LoginMapper;
import com.jsjk.pojo.UserBase;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public boolean login(String username, String password) {
		UserBase user = loginMapper.login(username, password);
		System.out.println(username + " " + password);
		if(user == null) {
			return false;
		} else {
			return true;
		}
	}

}
