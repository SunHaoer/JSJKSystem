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
	@RequestMapping("/toregister")
	public String toRegister(){		
		return "/register";
	}
	
	/**
	 * 处理注册信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/register", produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String register(UserBase user, HttpSession session, @RequestParam(defaultValue="") String phoneVerificationCode, @RequestParam(defaultValue="") String userPassword2){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		user.trimSpace();
		phoneVerificationCode = phoneVerificationCode.trim();
		if(user.notNullValidation() 
		&& registerService.phoneVerificationCodeIsLegal(phoneVerificationCode, (String)session.getAttribute("phoneVerificationCode"))
		&& registerService.userPasswordIsLegal(user.getUserPassword(), userPassword2)
		&& registerService.userPhoneNotChange(user.getUserPhone(), (String)session.getAttribute("userPhone"))
		&& registerService.userBirthYearIsLegal(user.getUserBirthYear())) {
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
	 * 获取短信验证码
	 */
	@RequestMapping(value="/getPhoneVerificationCode", produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String getVerificationCode(@RequestParam(defaultValue="") String userPhone, HttpSession session) {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userPhone = userPhone.trim();
        if(registerService.userPhoneIsLegal(userPhone)) {    // 手机号合法
			String phoneVerificationCode = registerService.createPhoneVerificationCode();
			session.setAttribute("userPhone", userPhone);
			session.setAttribute("phoneVerificationCode", phoneVerificationCode);
			session.setMaxInactiveInterval(600);
			try {
				JSONObject receivedJson = registerService.getPhoneVerificationCode(userPhone, phoneVerificationCode);
				if(Integer.parseInt(receivedJson.getString("result")) >= 0 ) {    // 发送成功
					outputJson.put("result", true);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
        } 
		return outputJson.toString();
	}
	
	/**
	 * 校验verificationCode
	 * @param verificationCode
	 * @return
	 */
	@RequestMapping(value="/validateVerificationCode", produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String validateVerificationCode(@RequestParam(defaultValue="") String phoneVerificationCode, HttpSession session) {
		JSONObject outputJson = new JSONObject();
		boolean flag = registerService.phoneVerificationCodeIsLegal(phoneVerificationCode, (String)session.getAttribute("phoneVerificationCode"));
		outputJson.put("result", flag);
		return outputJson.toString();
	}
	
	/**
	 * userName校验
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/validateUserName", produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String validateUserName(@RequestParam(defaultValue="") String userName) {
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
	@RequestMapping(value="/validateUserPhone", produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String validateUserPhone(@RequestParam(defaultValue="") String userPhone) {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userPhone = userPhone.trim();
		if(registerService.userPhoneIsLegal(userPhone)) {
			outputJson.put("result", true);
		} 
		return outputJson.toString();
	}

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
