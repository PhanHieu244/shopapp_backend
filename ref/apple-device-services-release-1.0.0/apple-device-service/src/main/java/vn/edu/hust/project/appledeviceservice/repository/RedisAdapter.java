package vn.edu.hust.project.appledeviceservice.repository;

import jakarta.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.IRedisPort;
@Service
@RequiredArgsConstructor
public class RedisAdapter implements IRedisPort {
    private final RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public Boolean lockKey(String key, String value, Long expireTime) {
        return valueOperations.setIfAbsent(key, value, expireTime, TimeUnit.SECONDS);
    }

    @Override
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }


}
