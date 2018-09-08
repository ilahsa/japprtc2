package com.alta.japprtc2.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiba on 2018-09-08.
 */
public class RedisUtils {

    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private StringRedisTemplate redisTemplate;

    public RedisUtils(StringRedisTemplate _redisTemplate) {
        redisTemplate = _redisTemplate;
    }

    public <T> T saveCache(String key,T bean) {
        try {
            Object jsonObj = JSON.toJSON(bean);
            redisTemplate.opsForList().leftPush(key, jsonObj.toString());
        } catch (Exception e) {
            logger.error("transJsonError: {}" + e.getMessage());
        }
        return bean;
    }

    public <T> List<T> getCache(String key, Class<T> clazz) {
        List<T> results = new ArrayList<>();
        List<String> jsonStr = redisTemplate.opsForList().range(key, 0, -1);
        try {
            jsonStr.forEach(json -> {
                T bean = JSON.parseObject(json, clazz);
                results.add(bean);
            });
        } catch (Exception e) {
            logger.error("parseJsonError: {}" + e.getMessage());
        }
        return results;
    }

    public void delCache(String key) {
        redisTemplate.delete(key);
    }
}