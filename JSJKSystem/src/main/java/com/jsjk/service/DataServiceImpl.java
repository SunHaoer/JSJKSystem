package com.jsjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsjk.mapper.DataMapper;
import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private DataMapper dataMapper;

	@Override
	public List<Data> getDataByDate() {
		List<Data> list = dataMapper.getDataByDate();
		return list;
	}

	@Override
	public List<DateData> getData() {
		List<DateData> list = dataMapper.getData();
		System.out.println(list.get(0).getData_synthesize());
		return list;
	}

	@Override
	public void setData(String dataDate, String dataTime, int heartRate, int bloodPressure1, int bloodPressure2,
			int alcoholConcentration, int fatigue) {
		dataMapper.setData(dataDate, dataTime, heartRate, bloodPressure1, bloodPressure2, alcoholConcentration, fatigue);
		
	}

}
