package com.example.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.boot.CommandLineRunner;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoRedisApplication  {

    @Autowired
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisApplication.class, args);
    }

}
