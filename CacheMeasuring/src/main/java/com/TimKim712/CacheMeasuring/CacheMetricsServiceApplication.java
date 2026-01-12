package com.TimKim712.CacheMeasuring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheMetricsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheMetricsServiceApplication.class, args);
    }
}