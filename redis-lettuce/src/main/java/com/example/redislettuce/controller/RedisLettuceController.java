package com.example.redislettuce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.lambdaworks.redis.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisLettuceController {
  @Autowired
  private RedisClient redisClient;

  @RequestMapping("/test")
  public String test(@RequestParam String message){
    String key = "redis-lettuce::"+System.currentTimeMillis();
    redisClient.connect().sync().set(key, message);
    return key + " =  " + message;
  }
}
