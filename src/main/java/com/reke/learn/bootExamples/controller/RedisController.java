package com.reke.learn.bootExamples.controller;



import com.reke.learn.bootExamples.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sinocall on 2017/6/22.
 */
@RestController
public class RedisController {



	@RequestMapping("/set/{key}/{value}")
	String set(@PathVariable String key, @PathVariable String value){
		RedisUtil.set(key,value);
		return "success";
	}

	@RequestMapping("/get/{key}")
	String get(@PathVariable String key){
		String value = RedisUtil.get(key);
		return value;
	}

}
