package org.example;

import java.util.Map;
import java.util.Objects;

public class EntryMap<K, V> implements Map.Entry<K, V> {

    final K key;
    V value;
    EntryMap<K, V> next;

    public EntryMap(K key, V value, EntryMap<K, V> next) {

        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final String toString() {
        return key + "=" + value;
    }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;

        return o instanceof Map.Entry<?, ?> e
                && Objects.equals(key, e.getKey())
                && Objects.equals(value, e.getValue());
    }
}
