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
<<<<<<< HEAD
	public String register(UserBase user, @RequestParam(value="userPassword2", defaultValue="") String userPassword2){	
=======
	public String register(UserBase user, HttpSession session, @RequestParam(value="userPassword2", defaultValue="") String userPassword2, @RequestParam(value="userPhoneVerificationCode", defaultValue="") String phoneVerificationCode){	
		System.out.println(user + "\n\n" + "phoneVerficationCode=" + phoneVerificationCode + "userPasswrod2=" + userPassword2 + "\n\n");		
>>>>>>> 450f5a45eefb2260df583f7c1df1b032df6eb637
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
<<<<<<< HEAD
=======
//System.out.println(userName + "\n\n");
>>>>>>> 450f5a45eefb2260df583f7c1df1b032df6eb637
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
<<<<<<< HEAD
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userPhone = userPhone.trim();
		if(true) {
=======
System.out.println(userPhone + "\n\n");
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userPhone = userPhone.trim();
		if(registerService.userPhoneIsLegal(userPhone)) {
>>>>>>> 450f5a45eefb2260df583f7c1df1b032df6eb637
			outputJson.put("result", true);
		} 
		return outputJson.toString();
	}
<<<<<<< HEAD
	
=======
	
	/**
	 * 获取短信验证码
	 */
	@RequestMapping(value="/getPhoneVerificationCode")
	@ResponseBody
	public String getVerificationCode(@RequestParam(value="userPhone", defaultValue="") String userPhone, HttpSession session) {
		session.setAttribute("phoneVerificationCode", "0000");
System.out.println(userPhone);
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		userPhone = userPhone.trim();
        if(registerService.userPhoneIsLegal(userPhone)) {    // 手机号合法
			String phoneVerificationCode = registerService.createPhoneVerificationCode();
			session.setAttribute("userPhone", userPhone);
			session.setAttribute("phoneVerificationCode", phoneVerificationCode);
System.out.println((String)session.getAttribute("phoneVerificationCode") + "\n\n\n");
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
	@RequestMapping(value="/validatePhoneVerificationCode", produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String validatePhoneVerificationCode(@RequestParam(value="userPhoneVerificationCode", defaultValue="") String phoneVerificationCode, HttpSession session) {
System.out.println(phoneVerificationCode + "==" + (String)session.getAttribute("phoneVerificationCode") + "==" + session.getAttribute("userPhone") + "\n\n");		
		JSONObject outputJson = new JSONObject();
		boolean flag = registerService.phoneVerificationCodeIsLegal(phoneVerificationCode, (String)session.getAttribute("phoneVerificationCode"));
		outputJson.put("result", flag);
		return outputJson.toString();
	}

	@RequestMapping(value="/test1", method = RequestMethod.POST)
	@ResponseBody
	public String test1() {
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", "test1");
		return outputJson.toString();
	}
	
	@RequestMapping(value="/test2")
	@ResponseBody
	public String test2(ServletRequest servletRequest, ServletResponse servletResponse, UserBase user, HttpSession session, @RequestParam(value="userPhoneVerificationCode") String phoneVerificationCode, @RequestParam(defaultValue="") String userPassword2) {
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort();
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
//        response.setHeader("Access-Control-Allow-Credentials","true");
        JSONObject outputJson = new JSONObject();
System.out.println(user + "\n\n" + "phoneVerficationCode=" + phoneVerificationCode + "userPasswrod2=" + userPassword2 + "\n\n");
        outputJson.put("result", "test2");
		return outputJson.toString();
	}
	
	@RequestMapping(value="/test3")
	@ResponseBody
	public String test3(String userName) {
		JSONObject outputJson = new JSONObject();
System.out.println(userName);
		outputJson.put("result", "啦啦啦，哈哈哈");
		return outputJson.toString();
	}
>>>>>>> 450f5a45eefb2260df583f7c1df1b032df6eb637
}
