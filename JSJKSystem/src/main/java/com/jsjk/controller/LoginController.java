package com.jsjk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	/**
	 * 转向登录页面
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toRegister(){		
		return "/login";
	}
	
}
