package com.jsjk.mapper;

import org.apache.ibatis.annotations.Param;

import com.jsjk.pojo.ProductBase;

public interface UpdateMapper {
	
	/**
	 * 根据productNo和key查product
	 * @param userName
	 */
	public ProductBase bindingProduct(@Param("productNo") String productNo, @Param("key") String key);

}
