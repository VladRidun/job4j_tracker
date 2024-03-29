package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) throws IOException {
        SoftReference<V> softReference = cache.getOrDefault(key, new SoftReference<>(null));
        V value = null;
        if (softReference.get() != null) {
            value = softReference.get();
        } else {
            put(key, load(key));
            value = cache.get(key).get();
        }
        return value;
    }

    protected abstract V load(K key) throws IOException;

}