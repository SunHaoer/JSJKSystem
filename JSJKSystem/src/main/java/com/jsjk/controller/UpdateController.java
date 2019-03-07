package com.jsjk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsjk.service.LoginService;
import com.jsjk.service.UpdateService;

import net.sf.json.JSONObject;

@CrossOrigin
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class UpdateController {
	
	@Autowired
	private UpdateService updateService;
	
	/**
	 * 处理硬件信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/bindingProduct")
	@ResponseBody
	public String bindingProduct(String productNo, String key){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		if(true) {
			try {
				if(updateService.bindingProduct(productNo, key)){
					outputJson.put("result", true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return outputJson.toString();
	}

}
