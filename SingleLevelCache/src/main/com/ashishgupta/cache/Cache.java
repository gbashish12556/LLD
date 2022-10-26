package main.com.ashishgupta.cache;

import main.com.ashishgupta.cache.exception.StorageFullException;
import main.com.ashishgupta.cache.policy.EvictionPolicy;
import main.com.ashishgupta.cache.storage.Storage;

public class Cache<Key,Value> {

    private EvictionPolicy<Key> evictionPolicy;
    private Storage<Key,Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key,Value> storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        try{
            storage.add(key,value);
            evictionPolicy.keyAccessed(key);
        }catch (StorageFullException e){
            Key evictKey = evictionPolicy.evictKey();
            storage.remove(evictKey);
            if(evictKey == null){
                throw new RuntimeException("No Key to evict");
            }
            put(key,value);
        }
    }
}
