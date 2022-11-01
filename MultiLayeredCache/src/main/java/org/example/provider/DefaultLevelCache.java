package org.example.provider;

import org.example.model.LevelCacheData;
import org.example.model.ReadResponse;
import org.example.model.StatsResponse;
import org.example.model.WriteResponse;

public class DefaultLevelCache<Key,Value> implements ILevelCache<Key,Value>{

    private ICacheProvider cacheProvider;
    private LevelCacheData levelCacheData;

    private ILevelCache<Key,Value> next;

    DefaultLevelCache(ICacheProvider iCacheProvider, LevelCacheData levelCacheData, ILevelCache next){

        this.cacheProvider = iCacheProvider;
        this.levelCacheData = levelCacheData;
        this.next = next;

    }


    @Override
    public ReadResponse<Value> get(Key key) {

        Value value;
        Double totalTime = levelCacheData.getReadTime();
        value = (Value) cacheProvider.get(key);

        if (value == null) {

            if(next != null) {

                ReadResponse<Value> response = next.get(key);
                value = response.getValue();
                totalTime += response.getTotalTime();
                cacheProvider.put(key, response.getValue());
                totalTime += levelCacheData.getWriteTime();

            }

        }

        return new ReadResponse<Value>(value,totalTime);

    }

    @Override
    public WriteResponse put(Key key, Value value) {
        Double totalTime = levelCacheData.getReadTime();

        if(cacheProvider.get(key) == null){

            cacheProvider.put(key,value);
            totalTime += levelCacheData.getWriteTime();

            if(next != null) {

                WriteResponse response = next.put(key, value);
                totalTime += response.getTotalTime();

            }

        }

        return new WriteResponse(totalTime);

    }

    @Override
    public StatsResponse stats() {
        return null;
    }
}
