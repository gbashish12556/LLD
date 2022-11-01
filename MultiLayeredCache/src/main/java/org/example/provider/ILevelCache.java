package org.example.provider;

import org.example.model.ReadResponse;
import org.example.model.StatsResponse;
import org.example.model.WriteResponse;

public interface ILevelCache<Key,Value> {

    public ReadResponse<Value> get(Key key);
    public WriteResponse put(Key key, Value value);
    public StatsResponse stats();


}
