package com.jsjk.service;

import java.util.List;
import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;

public interface DataService {

	List<Data> getDataByDate(String date);

	List<DateData> getData();

}
