# redis-test
Project for testing various redis drivers and configurations

- redis-jedis
    - Redis test project using the Jedis driver
- redis-lettuce
    - Redis test project using the Lettuce driver


### Usage:

```bash
# Launch redis-jedis
java -jar redis-jedis.jar --redis.sentinels=host:port,host:port

# Test redis-jedis
curl localhost:8001/redis-jedis/test?message=hello

# Launch redis-lettuce
java -jar redis-lettuce.jar --redis.sentinels=host:port,host:port

# Test redis-jedis
curl localhost:8001/redis-lettuce/test?message=hello