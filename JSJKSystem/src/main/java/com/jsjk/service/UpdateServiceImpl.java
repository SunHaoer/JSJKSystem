package com.jsjk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsjk.mapper.UpdateMapper;
import com.jsjk.pojo.ProductBase;
import com.jsjk.pojo.UserBase;

@Service
public class UpdateServiceImpl implements UpdateService {
	
	@Autowired
	UpdateMapper updateMapper;

	@Override
	public boolean bindingProduct(String productNo, String key) {
		ProductBase product = updateMapper.bindingProduct(productNo, key);
		System.out.println(productNo + " " + key);
		if(product == null) {
			return false;
		} else {
			return true;
		}
	}

}
