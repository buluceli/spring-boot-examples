package com.reke.learn.bootExamples.controller;


import com.reke.learn.bootExamples.bean.User;
import com.reke.learn.bootExamples.dao.UserMapper;
import com.reke.learn.bootExamples.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sinocall on 2017/7/14.
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService ;

	@RequestMapping("/user/{userId}")
	public User get(@PathVariable long userId){
		User user = userService.selectByPrimaryKey(userId);
		return user ;
	}
}
