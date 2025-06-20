package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapTest {

    @Test
     void testPut() {
        MyMap<String, Integer> map = new MyMap<>();
        assertNull(map.put("a", 1));
        assertEquals(1, map.get("a"));
        assertEquals(1, map.put("a", 2));
        assertEquals(2, map.get("a"));
    }

    @Test
    void testSizeAndIsEmpty() {
        MyMap<String, Integer> map = new MyMap<>();
        assertTrue(map.isEmpty());
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(2, map.size());
        assertFalse(map.isEmpty());
    }

    @Test
    void testContainsKey() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("a", 1);
        assertTrue(map.containsKey("a"));
        assertFalse(map.containsKey("b"));
    }

    @Test
    void testContainsValue() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("a", 5);
        map.put("b", 10);
        assertTrue(map.containsValue(5));
        assertFalse(map.containsValue(99));
    }

    @Test
    void testRemove() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(1, map.remove("a"));
        assertNull(map.get("a"));
        assertEquals(1, map.size());
    }

    @Test
    void testPutAll() {
        MyMap<String, Integer> map = new MyMap<>();
        MyMap<String, Integer> map2 = new MyMap<>();
        map2.put("x", 7);
        map2.put("y", 8);
        map.putAll(map2);
        assertEquals(7, map.get("x"));
        assertEquals(8, map.get("y"));
        assertEquals(2, map.size());
    }

    @Test
    void testClear() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("a", 1);
        map.clear();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void testKeySet() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Set<String> keys = map.keySet();
        assertTrue(keys.contains("one"));
        assertTrue(keys.contains("two"));
        assertEquals(2, keys.size());
    }

    @Test
    void testValues() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 11);
        map.put("B", 22);
        Collection<Integer> vals = map.values();
        assertTrue(vals.contains(11));
        assertTrue(vals.contains(22));
        assertEquals(2, vals.size());
    }

    @Test
    void testEntrySet() {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("z", 100);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        assertEquals(1, entries.size());
        assertTrue(entries.stream().anyMatch(e -> e.getKey().equals("z") && e.getValue().equals(100)));
    }
}
