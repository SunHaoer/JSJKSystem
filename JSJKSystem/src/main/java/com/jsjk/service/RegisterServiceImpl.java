package com.jsjk.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsjk.mapper.RegisterMapper;
import com.jsjk.pojo.UserBase;
import com.jsjk.utils.HttpUtils;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper registerMapper;
	
	@Override
	public boolean notExistUserName(String userName) {
		//System.out.println("2\n\n\n\n");
		boolean isLegal = true;
		//System.out.println(userName + "合法");
		return isLegal;
	}

	@Override
	public boolean notExistPhone(String phone) {
		boolean isLegal = true;
		//System.out.println(phone + "合法");
		return isLegal;
	}

	@Override
	public void saveRegister(UserBase user) {
		registerMapper.saveRegister(user);
		registerMapper.createUserDataTable("user_" + user.getUserId() + "_datatable");
		System.out.println(user.getUserId() + "\n\n");
	}

	@Override
	public String createVerificationCode() {
		String verificationCode = "";
		for(int i = 0; i < 4; i++) {
			verificationCode += (int)(Math.random() * 10);
		}
		return verificationCode;
	}

	@Override
	public void getVerificationCode() {
        String host = "https://aliyun.chanyoo.net";
        String path = "/sendsms";
        String method = "GET";
        String appcode = "fba4071a97e249b7869aaa569815dc88";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "15958566981");
        querys.put("content", "您的手机号：13012345678，验证码：110426，请及时完成验证，如不是本人操作请忽略。【阿里云市场】");

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
