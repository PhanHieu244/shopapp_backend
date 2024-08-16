package vn.edu.hust.project.appledeviceservice.port;

public interface IRedisPort {
    Boolean lockKey(String key, String value, Long expireTime);
    void deleteKey(String key);
}
