package com.jsjk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;

public interface DataMapper {

	List<Data> getDataByDate();

	List<DateData> getData();

	void setData(@Param("dataDate")String dataDate, @Param("dataTime")String dataTime, @Param("heartRate")int heartRate, @Param("bloodPressure1")int bloodPressure1, @Param("bloodPressure2")int bloodPressure2, @Param("alcoholConcentration")int alcoholConcentration, @Param("fatigue")int fatigue);


}
