package com.example.Caching_Spring_App.config;

import com.example.Caching_Spring_App.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheStoreBeans {

    @Bean(name="bookCache")
    public CacheStore<Long, Book> bookLoadingCache() {
        return new CacheStore<>(120, TimeUnit.SECONDS);
    }
}
