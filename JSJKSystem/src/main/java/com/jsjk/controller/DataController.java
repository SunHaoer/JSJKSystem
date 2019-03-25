package com.jsjk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.helpers.DateTimeDateFormat;
import org.apache.taglibs.standard.lang.jstl.Literal;
import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;
import com.jsjk.service.DataService;
import com.jsjk.utils.HealthData;
import com.jsjk.utils.UserInfo;
import com.jsjk.vewModel.DataViewModel;

import net.sf.json.JSONObject;
import net.sf.jsqlparser.statement.replace.Replace;

@CrossOrigin
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="/setData")
	@ResponseBody
	public String setData(@RequestParam(defaultValue = "1")int heartRate, @RequestParam(defaultValue = "1")int bloodPressure1, @RequestParam(defaultValue = "1")int bloodPressure2, @RequestParam(defaultValue = "1")int alcoholConcentration) {
		JSONObject outputJson = new JSONObject();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd,HHmmss");		// 设置日期格式
		String timeStr = df.format(new Date());		// new Date()为获取当前系统时间
		String dataDate = timeStr.split(",")[0];
		String dataTime = timeStr.split(",")[1];
		if(Integer.parseInt(dataTime) - UserInfo.nowTime > 20) {
			System.out.println(1);
			UserInfo.timeCnt = 0;
		} else {
			UserInfo.timeCnt++;
			System.out.println(2);
		}
		System.out.println(UserInfo.nowTime + "\n\n");
		UserInfo.nowTime = Integer.parseInt(dataTime);
		int fatigue = UserInfo.timeCnt;
		dataService.setData(dataDate, dataTime, heartRate, bloodPressure1, bloodPressure2, alcoholConcentration, fatigue);
		UserInfo.timeCnt++;
		outputJson.put("success", true);
		outputJson.put("message", "");
		return outputJson.toString();
	}
	
	/**
	 * 获取信息根据日期
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/getLastData")
	@ResponseBody
	public String getLastData(){	
		JSONObject outputJson = new JSONObject();
		outputJson.put("success", true);
		List<Data> list = dataService.getDataByDate();
		Data data = list.get(list.size() - 1);
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
		outputJson.put("success", true);
		List<DateData> list = dataService.getData();
		for(DateData dateData : list) {
			dateData.setDataDate(dateData.getDataDate().replace("y", "年"));
			dateData.setDataDate(dateData.getDataDate().replace("m", "月"));
			dateData.setDataDate(dateData.getDataDate().replace("d", "日") );
		}
		outputJson.put("data", list);
		System.out.println(list.get(0).getDataDate());
		return outputJson.toString();
	}
}
