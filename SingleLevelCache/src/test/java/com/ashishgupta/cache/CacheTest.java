package com.ashishgupta.cache;

import com.ashishgupta.cache.factory.CacheFactory;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {

    Cache<Integer, Integer> cache;

    @BeforeEach
    public void setup(){
        cache = (new CacheFactory<Integer, Integer>()).getDefaultCache(3);
    }

    @org.junit.jupiter.api.Test
    public void itShouldBeAbleToGetAndAddItemsInTheCache(){

        cache.put(1,1);
        cache.put(2,2);

        assertEquals(1, cache.get(1));

    }


}
