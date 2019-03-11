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
	public List<Data> getDataByDate(String date) {
		List<Data> list = dataMapper.getDataByDate(date);
		return list;
	}

	@Override
	public List<DateData> getData() {
		List<DateData> list = dataMapper.getData();
		return list;
	}

}
