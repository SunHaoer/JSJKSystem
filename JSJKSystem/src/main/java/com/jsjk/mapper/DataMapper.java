package com.jsjk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jsjk.pojo.Data;
import com.jsjk.pojo.DateData;

public interface DataMapper {

	List<Data> getDataByDate(@Param("date") String date);

	List<DateData> getData();


}
