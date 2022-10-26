package com.ashishgupta.cache.storage;

import com.ashishgupta.cache.exception.NotFoundException;
import com.ashishgupta.cache.exception.StorageFullException;

import java.util.HashMap;

public class HashMapBasedStorage<Key,Value> implements Storage<Key, Value>{

    private HashMap<Key, Value> storage;
    private Integer capacity;

    public HashMapBasedStorage(Integer capacity){
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    private Boolean isStorageFull(){
        if (storage.size() == capacity){
            return true;
        }
        return false;
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()){
            throw new StorageFullException("Storage is Full");
        }
        if(storage.containsKey(key)){
            Value data = storage.get(key);
            if(data != value){
                storage.put(key,value);
            }
        }else{
            storage.put(key,value);
        }

    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (storage.containsKey(key)){
            return storage.get(key);
        }
        throw  new NotFoundException("Element not found");
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (storage.containsKey(key)){
            storage.remove(key);
        }
        throw new NotFoundException("Element not found");
    }
}
