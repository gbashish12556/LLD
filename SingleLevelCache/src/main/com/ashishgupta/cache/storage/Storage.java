package main.com.ashishgupta.cache.storage;

import main.com.ashishgupta.cache.exception.NotFoundException;
import main.com.ashishgupta.cache.exception.StorageFullException;

public interface Storage<Key,Value> {

    public void add(Key key,Value value) throws StorageFullException;

    public Value get(Key key) throws NotFoundException;

    public void remove(Key key) throws NotFoundException;

}
