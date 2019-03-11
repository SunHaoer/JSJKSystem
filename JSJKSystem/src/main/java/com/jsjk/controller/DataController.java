package com.jsjk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;
import com.jsjk.service.DataService;
import com.jsjk.utils.HealthData;
import com.jsjk.utils.UserInfo;
import com.jsjk.vewModel.DataViewModel;

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
		outputJson.put("success", true);
		List<Data> list = dataService.getDataByDate(date);
		Data data = list.get(0);
		System.out.println(data.toString() + "\n\n");
		DataViewModel viewData = new DataViewModel(data.getHeartRate(), data.getFatigue(), data.getBloodPressure1(), data.getBloodPressure2(), data.getAlcoholConcentration());
		if(true) { 
			viewData.setNowStatus(2);
			viewData.setBloodPressure1Status(1);
			viewData.setBloodPressure2Status(1);
			String bloodPressLine = HealthData.ageBloodPressure[UserInfo.sex][(UserInfo.age - 1) / 5];
			System.out.println(bloodPressLine + "\n\n");
			if(viewData.getBloodPressure1() > Integer.parseInt(bloodPressLine.split(",")[0])) {
				viewData.setBloodPressure1(2);
			} else if(viewData.getBloodPressure1() > 998) {
				viewData.setBloodPressure1(3);
			}
			if(viewData.getBloodPressure2() > Integer.parseInt(bloodPressLine.split(",")[1])) {
				viewData.setBloodPressure1(2);
			} else if(viewData.getBloodPressure2() > 998) {
				viewData.setBloodPressure1(3);
			}
			viewData.setAlcoholConcentrationStatus(1);
			if(viewData.getAlcoholConcentration() >= 80) {
				viewData.setAlcoholConcentrationStatus(3);
			} else if(viewData.getAlcoholConcentration() >= 20) {
				viewData.setAlcoholConcentrationStatus(2);
			}
			viewData.setHeartRateStatus(1);
			if(viewData.getHeartRate() < 60) {
				viewData.setHeartRateStatus(2);
			} else if(viewData.getHeartRate() > 100) {
				viewData.setHeartRateStatus(3);
			}
			viewData.setFatigueStatus(1);
			if(viewData.getBloodPressure1Status() == 3 || viewData.getBloodPressure2Status() == 3 || viewData.getHeartRateStatus() == 3 || viewData.getFatigueStatus() == 3 || viewData.getAlcoholConcentrationStatus() != 1) {
				viewData.setNowStatus(3);
			} else if(viewData.getBloodPressure1Status() == 1 && viewData.getBloodPressure2() == 1 && viewData.getHeartRateStatus() == 1 && viewData.getFatigueStatus() == 1) {
				viewData.setNowStatus(1);
			}
			
		}
		outputJson.put("data", viewData);
		outputJson.put("message", "");
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
		outputJson.put("success", false);
		List<DateData> list = dataService.getData();
		outputJson.put("data", list);
		return outputJson.toString();
	}
}
