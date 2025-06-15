package org.example;

import java.util.Map;
import java.util.Objects;

public class Entry<K, V> implements Map.Entry<K, V> {

    K key;
    V value;
    Entry<K, V> next;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Map.Entry)) return false;
        Map.Entry<?, ?> other = (Map.Entry<?, ?>) obj;
        return Objects.equals(key, other.getKey()) && Objects.equals(value, other.getValue());
    }
}
