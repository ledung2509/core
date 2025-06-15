package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.hash;

public class MyMap<K, V> implements Map<K, V> {

    private final int capacity = 16;
    private Entry<K, V>[] table;
    private int size = 0;

    public MyMap() {
        table = (Entry<K, V>[]) new Entry[capacity];
    }

    private int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int index = hash(key);
        EntryMap<K, V> entry = (EntryMap<K, V>) table[index];
        while (entry != null) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = hash(key);
        EntryMap<K, V> entry = (EntryMap<K, V>) table[index];
        while (entry != null) {
            if (Objects.equals(entry.getKey(), key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
            entry = entry.next;
        }
        Entry<K, V> newEntry = new EntryMap<>(key, value,(EntryMap<K, V>) table[index]);
        table[index] = newEntry;
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public Collection<V> values() {
        return List.of();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }
}
