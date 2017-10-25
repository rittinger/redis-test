package com.example.redislettuce.config;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.resource.ClientResources;
import com.lambdaworks.redis.resource.DefaultClientResources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class SpringLettuceConfig {
  @Value("${spring.redis.database}")
  private int database;

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.sentinel.nodes}")
  private String nodes;

  @Value("${spring.redis.sentinel.master}")
  private String master;

  @Bean(destroyMethod = "shutdown")
  ClientResources clientResources() {
    return DefaultClientResources.create();
  }

  @Bean(destroyMethod = "shutdown")
  RedisClient redisClient(ClientResources clientResources) {
    //RedisURI redisUri = RedisURI.create(redisHost, redisPort);
    //redisUri.setDatabase(database);
    //return RedisClient.create(clientResources, redisUri);
\
    // "redis-sentinel://localhost:26379,localhost:26380/0#mymaster"
//    RedisURI redisUri = RedisURI.builder()
//        .withDatabase(database)
//        .withPassword(password)
//        .withSentinel(nodes)
//        .build();
//
//    return RedisClient.create(clientResources, redisUri);

    RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration()
        .master(master)
        .sentinel("localhost", 26379);
    LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(sentinelConfiguration);
    lettuceConnectionFactory.setDatabase(database);
    lettuceConnectionFactory.setPassword(password);
  }

  @Bean(destroyMethod = "close")
  StatefulRedisConnection<String, String> connection(RedisClient redisClient) {
    return redisClient.connect();
  }
}
