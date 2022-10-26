package main.com.ashishgupta.cache.factory;

import main.com.ashishgupta.cache.Cache;
import main.com.ashishgupta.cache.policy.EvictionPolicy;
import main.com.ashishgupta.cache.policy.LRUEvictionPolicy;
import main.com.ashishgupta.cache.storage.HashMapBasedStorage;
import main.com.ashishgupta.cache.storage.Storage;

import java.util.HashMap;

public class CacheFactory<Key,Value> {
    public Cache<Key,Value> getDefaultCache(int capacity){
        return new Cache(new LRUEvictionPolicy(), new HashMapBasedStorage(capacity));
    };
}
