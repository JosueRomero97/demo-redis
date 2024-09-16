package com.example.demoredis.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate template;

    @GetMapping("redis")
    public String hello() {
        ValueOperations<String, String> ops = this.template.opsForValue();

        // Add a Hello World string to your cache.
        String key = "Message";
        if (!this.template.hasKey(key)) {
            ops.set(key, "Hello World!");
        }

        // Return the string from your cache.
        return ops.get(key);
    }

    @GetMapping("/redis/test")
    public String testConnection() {
        try {
            template.getConnectionFactory().getConnection().ping();
            return "Conexión exitosa a Redis";
        } catch (Exception e) {
            return "Error conectando a Redis: " + e.getMessage();
        }
    }
}
