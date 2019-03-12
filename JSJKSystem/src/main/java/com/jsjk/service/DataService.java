package com.jsjk.service;

import java.util.List;
import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;

public interface DataService {

	List<Data> getDataByDate();

	List<DateData> getData();

	void setData(String dataDate, String dataTime, int heartRate, int bloodPressure1, int bloodPressure2,
			int alcoholConcentration, int fatigue);

}
