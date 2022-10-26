package com.ashishgupta.cache.policy;

import java.security.Key;

public interface EvictionPolicy<Key> {
    public void keyAccessed(Key key);
    public Key evictKey();
}
