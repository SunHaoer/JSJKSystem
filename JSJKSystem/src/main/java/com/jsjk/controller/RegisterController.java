package com.jsjk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsjk.pojo.UserBase;
import com.jsjk.service.RegisterService;

@Controller
public class RegisterController extends BaseController {
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 转向tilte标题栏页面
	 * @return
	 */
	@RequestMapping("/toregister")
	public String toRegister(){		
		return "/register";
	}
	
	/**
	 * 处理注册信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/register")
	public String register(UserBase user){		//转向tilte标题栏页面
		//System.out.println("1\n\n\n\n");
		if(registerService.notExistUserName(user.getUserName()) && registerService.notExistPhone(user.getUserPhone())) {
			System.out.println(user + "\n\n");
			registerService.saveRegister(user);
		}
		return "/login";
	}
	
}
