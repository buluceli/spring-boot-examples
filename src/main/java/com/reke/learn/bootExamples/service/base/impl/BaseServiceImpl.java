package com.reke.learn.bootExamples.service.base.impl;


import com.reke.learn.bootExamples.dao.BaseMapper;
import com.reke.learn.bootExamples.service.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
	private BaseMapper<T, ID> baseMapper;

	public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
		this.baseMapper = baseMapper;
	}

	public int deleteByPrimaryKey(ID id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}


	public T selectByPrimaryKey(ID id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}


	public int insert(T record) {
		return baseMapper.insert(record);
	}

	public void setBaseMapper() {
		// TODO Auto-generated method stub

	}

}