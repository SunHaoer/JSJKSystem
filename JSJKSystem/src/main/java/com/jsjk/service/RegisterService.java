package com.jsjk.service;

import com.jsjk.pojo.UserBase;

import net.sf.json.JSONObject;

public interface RegisterService {
	
	/**
	 * 处理合法的注册信息
	 * @param user
	 */
	public boolean saveRegister(UserBase user);
	
	/**
	 * 产生验证码
	 * @return
	 */
	public String createPhoneVerificationCode();
	
	/**
	 * 向手机发送验证码
	 * @throws Exception 
	 */
	public JSONObject getPhoneVerificationCode(String userPhone, String phoneVerificationCode) throws Exception;
	
	/**
	 * 验证userName是否合法
	 * @param userName
	 * @return
	 */
	public boolean userNameIsLegal(String userName);
	
	/**
	 * 验证userPhone是否合法
	 * @param userPhone
	 * @return
	 */
	public boolean userPhoneIsLegal(String userPhone);
	
	/**
	 * 验证phoneVerification
	 * @param inputPhoneVerificationCode
	 * @param standardPhoneVerificationCode
	 * @return
	 */
	public boolean phoneVerificationCodeIsLegal(String inputPhoneVerificationCode,
			String standardPhoneVerificationCode);
	
	/**
	 * 验证userBirthYear是否合法
	 * @param userBirthYear
	 * @return
	 */
	public boolean userBirthYearIsLegal(int userBirthYear);
	
	/**
	 * 验证userPassword
	 * @param userPassword
	 * @param userpassword2
	 * @return
	 */
	public boolean userPasswordIsLegal(String userPassword, String userPassword2);

}
