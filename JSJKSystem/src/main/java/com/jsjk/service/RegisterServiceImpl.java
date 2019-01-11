package com.jsjk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsjk.mapper.RegisterMapper;
import com.jsjk.pojo.UserBase;
import com.jsjk.utils.HttpUtils;

import net.sf.json.JSONObject;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public boolean saveRegister(UserBase user) {
		// 此处需要添加数据库事务绑定
		registerMapper.saveRegister(user);
		registerMapper.createUserDataTable("user_" + user.getUserId() + "_datatable");	
		return true;
	}

	@Override
	public String createPhoneVerificationCode() {
		String verificationCode = "";
		for(int i = 0; i < 4; i++) {
			verificationCode += (int)(Math.random() * 10);
		}
		//System.out.println(verificationCode + "\n\n\n");
		return verificationCode;
	}

	@Override
	public JSONObject getPhoneVerificationCode(String userPhone, String phoneVerficicationCode) throws Exception {
		//System.out.println(userPhone + " " + phoneVerficicationCode);
        String host = "https://aliyun.chanyoo.net";
        String path = "/sendsms";
        String method = "GET";
        String appcode = "fba4071a97e249b7869aaa569815dc88";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", userPhone);
        querys.put("content", "您的手机号：" + userPhone + "，验证码：" + phoneVerficicationCode + "，请及时完成验证，如不是本人操作请忽略。【阿里云市场】");

        HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
        String getResponseStr = EntityUtils.toString(response.getEntity());	// response.getEntity()只能使用一次
        JSONObject jsonObject = JSONObject.fromObject(getResponseStr);
        return jsonObject;
	}
	
	@Override
	public boolean userNameIsLegal(String userName) {
		System.out.println(userName);
		boolean flag = true;
		UserBase userBase = registerMapper.findUserByUserName(userName);
		System.out.println(userBase);
		if(userBase == null) {
			flag = true; 
		}
		return flag;
	}

	@Override
	public boolean userPhoneIsLegal(String userPhone) {
		boolean result = true;
        String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])|(18[0-9])|(19[8,9]))\\d{8}$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(userPhone);
        result = result && matcher.matches();
        UserBase userBase = registerMapper.findUserByUserPhone(userPhone);
        result = result && (userBase == null);
		return result;
	}

	@Override
	public boolean phoneVerificationCodeIsLegal(String inputPhoneVerificationCode,
			String standardPhoneVerificationCode) {
		return (standardPhoneVerificationCode != null) && (standardPhoneVerificationCode.equals(inputPhoneVerificationCode));
	}

	@Override
	public boolean userBirthYearIsLegal(int userBirthYear) {
		if(userBirthYear < 1900 || userBirthYear > 2500) {    // 出生太早或太晚
			return false;
		} 
		return true;
	}

	@Override
	public boolean userPasswordIsLegal(String userPassword, String userPasswrod2) {
		return userPassword.length() >= 6 && userPassword.equals(userPasswrod2);
	}
}
