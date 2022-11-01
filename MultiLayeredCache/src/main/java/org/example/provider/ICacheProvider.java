package org.example.provider;

import org.example.exceptions.StorageFullExeptions;

public interface ICacheProvider<Key,Value> {


    public void put(Key key, Value value);
    public Value get(Key key);


}
