package com.jsjk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsjk.pojo.UserBase;
import com.jsjk.service.RegisterService;

import net.sf.json.JSONObject;


@CrossOrigin
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class RegisterController extends BaseController {
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 转向注册页面
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
	@ResponseBody
	public String register(UserBase user, @RequestParam(value="userPassword2", defaultValue="") String userPassword2){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		user.trimSpace();
		if(true) {
			try {
				outputJson.put("result", true);
				registerService.saveRegister(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return outputJson.toString();
	}
	
	/**
	 * userName校验
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/validateUserName")
	@ResponseBody
	public String validateUserName(@RequestParam(value="userName", defaultValue="") String userName) {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userName = userName.trim();
		if(registerService.userNameIsLegal(userName)) {
			outputJson.put("result", true);
		} 
		return outputJson.toString();
	}
	
	/**
	 * userPhone校验
	 * @param userPhone
	 * @return
	 */
	@RequestMapping(value="/validateUserPhone")
	@ResponseBody
	public String validateUserPhone(@RequestParam(value="userPhone", defaultValue="") String userPhone) {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userPhone = userPhone.trim();
		if(true) {
			outputJson.put("result", true);
		} 
		return outputJson.toString();
	}
	
}
