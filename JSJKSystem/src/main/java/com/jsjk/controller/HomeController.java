package com.jsjk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController {
	
	@RequestMapping("/home")
	public String home(){	//转向欢迎页面
		//System.out.println("home\n\n\n");
		return "/index";
	}

}
