# redis-test
Project for testing various redis drivers and configurations

- redis-jedis
    - Redis test project using the Jedis driver
- redis-lettuce
    - Redis test project using the Lettuce driver


### Usage:

```bash
# Launch redis-jedis
java -jar redis-jedis.jar --spring.redis.password=xxx 
                          --spring.redis.sentinel.master=xxx 
                          --spring.redis.sentinel.nodes=xxx:1234,xxx:1234
# Test redis-jedis
curl localhost:8001/redis-jedis/test?message=hello

# Launch redis-lettuce
java -jar redis-lettuce.jar --spring.redis.password=xxx 
                            --spring.redis.sentinel.master=xxx 
                            --spring.redis.sentinel.nodes=xxx:1234,xxx:1234
# Test redis-jedis
curl localhost:8002/redis-lettuce/test?message=hello