package com.reke.learn.bootExamples.dao;



import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T,ID extends Serializable> {
	  int deleteByPrimaryKey(ID id);
	  
	  int insert(T record);
	  
	  int insertSelective(T record);
	  
	  T selectByPrimaryKey(ID id);
	  
	  int updateByPrimaryKeySelective(T record);
	  	  
	  int updateByPrimaryKey(T record);
	List<T> selectBySql(@Param("paramSQL") String paramSQL);
	int selectCountBySql(@Param("paramSQL") String paramSQL);
	void updateBySql(@Param("paramSQL") String paramSQL);
	    
	}