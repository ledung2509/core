package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    
    @Test
    void testAdd() {
        MySet<String> set = new MySet<>();
        assertTrue(set.add("a"));
        assertFalse(set.add("a"));
        assertEquals(1, set.size());
    }

    @Test
    void testSizeAndIsEmpty() {
        MySet<Integer> set = new MySet<>();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());

        set.add(1);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    void testContains() {
        MySet<String> set = new MySet<>();
        assertFalse(set.contains("abc"));
    }

    @Test
    void testIterator() {
        MySet<Integer> set = new MySet<>();
        Iterator<Integer> it = set.iterator();

        assertNotNull(it);
        assertFalse(it.hasNext());

        set.add(10);
        it = set.iterator();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void testToArray() {
        MySet<String> set = new MySet<>();
        assertArrayEquals(new Object[0], set.toArray());
    }

    @Test
    void testToArrayGeneric() {
        MySet<String> set = new MySet<>();
        String[] arr = new String[1];
        String[] result = set.toArray(arr);

        assertNotNull(result);
        assertEquals(1, result.length);
        assertNull(arr[0]);
    }

    @Test
    void testRemove() {
        MySet<String> set = new MySet<>();
        assertFalse(set.remove("test"));
    }

    @Test
    void testContainsAll() {
        MySet<String> set = new MySet<>();
        Set<String> checkSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.containsAll(checkSet));
    }

    @Test
    void testAddAll() {
        MySet<String> set = new MySet<>();
        Set<String> addSet = new HashSet<>(Arrays.asList("a", "b"));
        assertTrue(set.addAll(addSet));
        assertEquals(2, set.size());
        assertTrue(set.contains("a"));
        assertTrue(set.contains("b"));
    }

    @Test
    void testRetainAll() {
        MySet<String> set = new MySet<>();
        Set<String> retainSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.retainAll(retainSet));
    }

    @Test
    void testRemoveAll() {
        MySet<String> set = new MySet<>();
        Set<String> removeSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.removeAll(removeSet));
    }

    @Test
    void testClear() {
        MySet<String> set = new MySet<>();
        set.add("a");
        set.add("b");

        assertEquals(2, set.size());

        set.clear();

        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }
}
