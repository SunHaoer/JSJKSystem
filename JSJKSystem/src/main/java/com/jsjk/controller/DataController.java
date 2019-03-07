package com.jsjk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;
import com.jsjk.service.DataService;

import net.sf.json.JSONObject;

@CrossOrigin
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	/**
	 * 获取信息根据日期
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/getDataByDate")
	@ResponseBody
	public String getDataByDate(String date){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		List<Data> list = dataService.getDataByDate(date);
		outputJson.put("data", list);
		return outputJson.toString();
	}
	
	/**
	 * 获取信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/getData")
	@ResponseBody
	public String getData(){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("result", false);
		List<DateData> list = dataService.getData();
		outputJson.put("data", list);
		return outputJson.toString();
	}
}
