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
        mySet<String> set = new mySet<>();
        assertFalse(set.add("a")); // hiện tại luôn trả về false
    }

    @Test
    void testSizeAndIsEmpty() {
        mySet<Integer> set = new mySet<>();
        assertEquals(0, set.size());
        assertFalse(set.isEmpty()); // hiện tại luôn trả về false
    }

    @Test
    void testContains() {
        mySet<String> set = new mySet<>();
        assertFalse(set.contains("abc"));
    }

    @Test
    void testIterator() {
        mySet<Integer> set = new mySet<>();
        assertNull(set.iterator());
    }

    @Test
    void testToArray() {
        mySet<String> set = new mySet<>();
        assertArrayEquals(new Object[0], set.toArray());
    }

    @Test
    void testToArrayGeneric() {
        mySet<String> set = new mySet<>();
        String[] arr = new String[1];
        assertNull(set.toArray(arr)); // hiện tại luôn trả về null
    }

    @Test
    void testRemove() {
        mySet<String> set = new mySet<>();
        assertFalse(set.remove("test"));
    }

    @Test
    void testContainsAll() {
        mySet<String> set = new mySet<>();
        Set<String> checkSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.containsAll(checkSet));
    }

    @Test
    void testAddAll() {
        mySet<String> set = new mySet<>();
        Set<String> addSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.addAll(addSet));
    }

    @Test
    void testRetainAll() {
        mySet<String> set = new mySet<>();
        Set<String> retainSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.retainAll(retainSet));
    }

    @Test
    void testRemoveAll() {
        mySet<String> set = new mySet<>();
        Set<String> removeSet = new HashSet<>(Arrays.asList("a", "b"));
        assertFalse(set.removeAll(removeSet));
    }

    @Test
    void testClear() {
        mySet<String> set = new mySet<>();
        set.clear();
        // Không có gì để assert, vì clear() không trả về gì và size() đang luôn trả về 0
    }
}
