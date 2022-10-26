package com.ashishgupta.cache.factory;

import com.ashishgupta.cache.storage.HashMapBasedStorage;
import com.ashishgupta.cache.Cache;
import com.ashishgupta.cache.policy.LRUEvictionPolicy;

public class CacheFactory<Key,Value> {
    public Cache<Key,Value> getDefaultCache(int capacity){
        return new Cache(new LRUEvictionPolicy(), new HashMapBasedStorage(capacity));
    };
}
