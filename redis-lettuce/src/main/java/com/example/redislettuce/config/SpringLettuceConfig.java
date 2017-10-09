package com.example.redislettuce.config;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.resource.ClientResources;
import com.lambdaworks.redis.resource.DefaultClientResources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringLettuceConfig {
  @Value("${redis.host}")
  private String redisHost;

  @Value("${redis.port}")
  private int redisPort = 5;

  @Value("${redis.database}")
  private int database;

  @Bean(destroyMethod = "shutdown")
  ClientResources clientResources() {
    return DefaultClientResources.create();
  }

  @Bean(destroyMethod = "shutdown")
  RedisClient redisClient(ClientResources clientResources) {
    RedisURI redisUri = RedisURI.create(redisHost, redisPort);
    redisUri.setDatabase(database);
    return RedisClient.create(clientResources, redisUri);
  }

  @Bean(destroyMethod = "close")
  StatefulRedisConnection<String, String> connection(RedisClient redisClient) {
    return redisClient.connect();
  }
}
