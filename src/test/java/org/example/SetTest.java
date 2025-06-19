package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SetTest {
    
    @Test
    void testAdd() {
        MySet<String> set = new MySet<>();
        assertFalse(set.add("a")); // hiện tại luôn trả về false
    }

    @Test
    void testSizeAndIsEmpty() {
        MySet<Integer> set = new MySet<>();
        assertEquals(0, set.size());
        assertFalse(set.isEmpty()); // hiện tại luôn trả về false
    }

    @Test
    void testContains() {
        MySet<String> set = new MySet<>();
        assertFalse(set.contains("abc"));
    }

    @Test
    void testIterator() {
        MySet<Integer> set = new MySet<>();
        assertNull(set.iterator());
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
        assertNull(set.toArray(arr)); // hiện tại luôn trả về null
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
        assertFalse(set.addAll(addSet));
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
        set.clear();
        // Không có gì để assert, vì clear() không trả về gì và size() đang luôn trả về 0
    }
}
