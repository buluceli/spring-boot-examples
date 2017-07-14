package com.reke.learn.bootExamples.dao;



import com.reke.learn.bootExamples.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User, Long> {

}