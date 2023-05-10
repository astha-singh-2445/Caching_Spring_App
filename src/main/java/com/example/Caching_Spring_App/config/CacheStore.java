package com.example.Caching_Spring_App.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class CacheStore<K, V> {

    private final Cache<K, V> cache;

    public CacheStore(int expiryDuration, TimeUnit timeUnit) {

        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expiryDuration, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();

    }

    public Optional<V> get(K key) {

        return Optional.ofNullable(cache.getIfPresent(key));
    }

    public boolean put(K key, V value) {
        if (key != null && value != null) {
            cache.put(key, value);
            return true;
        }
        return false;
    }
}