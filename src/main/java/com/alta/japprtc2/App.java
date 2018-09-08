package com.alta.japprtc2;

import com.alta.japprtc2.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;


@Slf4j
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        log.info("the service to start.");
        System.out.println("The service to start.");
        SpringApplication.run(App.class, args);
        System.out.println("The service has started.");
        log.info("the service has started.");
    }

    @Bean
    public RedisUtils redisUtils(StringRedisTemplate redisTemplate) {
        return new RedisUtils(redisTemplate);
    }

}
