package org.example;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class myMap<K,V> implements Map<K,V> {

    private List<Entry<K,V>> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public V get(Object key) {
        for (Entry<K,V> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        for (Entry<K,V> entry : list) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        list.add(new AbstractMap.SimpleEntry<>(key, value));
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry<K,V> entry : list) {
            if (Objects.equals(entry.getKey(), key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K,V> entry : list) {
            if (Objects.equals(entry.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(Object key) {
        for (Entry<K,V> entry : list) {
            if (Objects.equals(entry.getKey(), key)) {
                V oldValue = entry.getValue();
                list.remove(oldValue);
            }
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Entry<K,V> entry : list) {
            set.add(entry.getKey());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        List<V> entries = new ArrayList<>();
        for(Entry<K,V> entry : list){
            entries.add(entry.getValue());
        }
        return entries;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(list);
    }

    public void printAll() {
        for (Map.Entry<K, V> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}