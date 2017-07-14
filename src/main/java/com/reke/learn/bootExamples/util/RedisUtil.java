package com.reke.learn.bootExamples.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private static StringRedisTemplate template;

    @Autowired
	public RedisUtil(StringRedisTemplate template) {
        this.template = template;
    }

    public  static void set(String key,String value){
		template.opsForValue().set(key, value,60*10, TimeUnit.SECONDS);
	}

	public static String get(String key){
		return template.opsForValue().get(key);
	}
}