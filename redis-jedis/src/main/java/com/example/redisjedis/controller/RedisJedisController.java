package com.example.redisjedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisJedisController {
  @Autowired
  private StringRedisTemplate redisTemplate;

  @RequestMapping("/test")
  public String test(@RequestParam String message){
    String key = "redis-jedis::"+System.currentTimeMillis();
    redisTemplate.opsForValue().set(key, message);
    return key + " =  " + message;
  }
}
