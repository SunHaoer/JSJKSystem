package com.jsjk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsjk.pojo.UserBase;
import com.jsjk.service.LoginService;
import com.jsjk.service.RegisterService;

import net.sf.json.JSONObject;

@CrossOrigin
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	/**
	 * 转向登录页面
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toRegister(){		
		return "/login";
	}
	
	/**
	 * 处理注册信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login")
	@ResponseBody
	public String login(String username, String password){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		if(true) {
			try {
				if(loginService.login(username, password)){
					outputJson.put("result", true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return outputJson.toString();
	}
	
}
