package com.reke.learn.bootExamples.service.base;




import java.io.Serializable;


public interface BaseService<T,ID extends Serializable> {
  void setBaseMapper();
  
  int deleteByPrimaryKey(ID id);
  
  int insert(T record);
  
  int insertSelective(T record);
  
  T selectByPrimaryKey(ID id);
  
  int updateByPrimaryKeySelective(T record);
  
  int updateByPrimaryKey(T record);

}