package com.example.demoredis.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl {
    @Cacheable(value = "myCache", key = "#id")
    public String getDataFromCache(String id) {
        // Este método solo se ejecutará si el valor no está en caché
        return "Datos calculados para el ID: " + id;
    }
}
