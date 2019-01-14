package com.jsjk.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsjk.pojo.UserBase;
import com.jsjk.service.RegisterService;

import net.sf.json.JSONObject;


@CrossOrigin
@Controller
public class RegisterController extends BaseController {
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 转向注册页面
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("/toregister")
	public String toRegister(){		
		return "/register";
	}
	
	/**
	 * 处理注册信息
	 * @param user
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/register")
	@ResponseBody
	public String register(UserBase user, HttpSession session, @RequestParam String phoneVerificationCode, @RequestParam String userPassword2){	
		JSONObject outputJson = new JSONObject();
		String inputPhoneVerificationCode = phoneVerificationCode;
		String standardPhoneVerificationCode = (String) session.getAttribute("phoneVerificationCode");
		if(user.notNullValidation() 
		&& registerService.phoneVerificationCodeIsLegal(inputPhoneVerificationCode, standardPhoneVerificationCode)
		&& registerService.userPasswordIsLegal(user.getUserPassword(), userPassword2)
		&& registerService.userPhoneIsLegal(user.getUserPhone())
		&& registerService.userBirthYearIsLegal(user.getUserBirthYear())) {
			try {
				registerService.saveRegister(user);
			} catch (Exception e) {
				outputJson.put("result", "注册失败");
			}
		} else {    // 注册失败
			outputJson.put("result", "注册失败");
		}
		return outputJson.toString();
	}
	
	/**
	 * 获取短信验证码
	 */
	@CrossOrigin
	@RequestMapping(value="/getPhoneVerificationCode")
	@ResponseBody
	public String getVerificationCode(String userPhone, HttpSession session) {
		JSONObject outputJson = new JSONObject();
        if(registerService.userPhoneIsLegal(userPhone)) {    // 手机号合法
			String phoneVerificationCode = registerService.createPhoneVerificationCode();
			session.setAttribute("phoneVerificationCode", phoneVerificationCode);
			try {
				JSONObject receivedJson = registerService.getPhoneVerificationCode(userPhone, phoneVerificationCode);
				if(Integer.parseInt(receivedJson.getString("result")) >= 0 ) {    // 发送成功
					outputJson.put("result", "短信发送成功");
				} else {
					outputJson.put("result", "操作次数过于频繁，请稍后在试");
				}
			} catch (Exception e) {
				outputJson.put("result", "操作次数过于频繁，请稍后在试");
				e.printStackTrace();
			}
        } else {
        	outputJson.put("result", "请使用中国大陆11位手机号");
        }
		return outputJson.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value="/validateUserName")
	@ResponseBody
	public String validateUserName(@RequestParam String userName) {
		JSONObject outputJson = new JSONObject();
		if(registerService.userNameIsLegal(userName)) {
			outputJson.put("result", "该用户名可以使用");
		} else {
			outputJson.put("result", "用户名重复");
		}
		return outputJson.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value="/validateUserPhone")
	@ResponseBody
	public String validateUserPhone(@RequestParam String userPhone) {
		JSONObject outputJson = new JSONObject();
		if(registerService.userPhoneIsLegal(userPhone)) {
			outputJson.put("result", "该手机号可以使用");
		} else {
			outputJson.put("result", "手机号已被注册");
		}
		return outputJson.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value="/test1")
	@ResponseBody
	public String test1() {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", "test1");
		return outputJson.toString();
	}
	
	@RequestMapping(value="/test2")
	@ResponseBody
	public String test2(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        response.setHeader("Access-Control-Allow-Credentials","true");
        JSONObject outputJson = new JSONObject();
        outputJson.put("result", "test2");
		return outputJson.toString();
	}
	
	@RequestMapping(value="/test3")
	@ResponseBody
	public String test3() {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", "test3");
		return outputJson.toString();
	}
}
