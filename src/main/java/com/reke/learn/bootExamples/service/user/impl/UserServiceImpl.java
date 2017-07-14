package com.reke.learn.bootExamples.service.user.impl;


import com.reke.learn.bootExamples.bean.User;
import com.reke.learn.bootExamples.dao.UserMapper;
import com.reke.learn.bootExamples.service.base.impl.BaseServiceImpl;
import com.reke.learn.bootExamples.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserMapper userMapper;






}
