package com.example.redisjedis.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class SpringJedisConfig {
//  @Value("${redis.host}")
//  private String redisHost;
//
//  @Value("${redis.port}")
//  private int redisPort;
//
//  @Value("${redis.database}")
//  private int database;
//
//  @Bean
//  JedisConnectionFactory jedisConnectionFactory() {
//    JedisConnectionFactory factory = new JedisConnectionFactory();
//    factory.setHostName(redisHost);
//    factory.setPort(redisPort);
//    factory.setDatabase(database);
//    factory.setUsePool(true);
//    return factory;
//  }
//
//  @Bean
//  RedisTemplate< String, Object > redisTemplate() {
//    final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
//    template.setConnectionFactory( jedisConnectionFactory() );
//    template.setKeySerializer( new StringRedisSerializer() );
//    template.setHashValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
//    template.setValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
//    return template;
//  }

}
