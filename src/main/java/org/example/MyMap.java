package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
        int index = hash(key);
        EntryMap<K, V> map = (EntryMap<K, V>) table[index];
        while (map != null) {
            if (Objects.equals(map.getKey(), key)) {
                return true;
            }
            map = map.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : table) {
            EntryMap<K, V> map = (EntryMap<K, V>) entry;
            while (map != null) {
                if (Objects.equals(map.getValue(), value)) {
                    return true;
                }
                map = map.next;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = hash(key);
        EntryMap<K, V> map = (EntryMap<K, V>) table[index];
        while (map != null) {
            if (Objects.equals(map.getKey(), key)) {
                return map.getValue();
            }
            map = map.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = hash(key);
        EntryMap<K, V> entry = (EntryMap<K, V>) table[index];
        while (entry != null) {
            //Kiểm tra có trùng key
            if (key.equals(entry.getKey())) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
            entry = entry.next;
        }
        Entry<K, V> newEntry = new EntryMap<>(key, value, (EntryMap<K, V>) table[index]);
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
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : table) {
            EntryMap<K, V> map = (EntryMap<K, V>) entry;
            while (map != null) {
                keys.add(entry.getKey());
                map = map.next;
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            EntryMap<K, V> list = (EntryMap<K, V>) entry;
            while (list != null) {
                values.add(list.getValue());
                list = list.next;
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> entry : table) {
            EntryMap<K, V> set = (EntryMap<K, V>) entry;
            while (set != null) {
                entries.add(set);
                set = set.next;
            }
        }

        return entries;
    }

    public void printDisplay() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> entry = table[i];
            if (entry != null) {
                System.out.print("[" + entry.getKey() + ":" + entry.getValue() + "]");
            }
            System.out.println();
        }
    }
}
