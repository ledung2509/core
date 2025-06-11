package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    myLinkedList list = new myLinkedList();

    @Test
    void testAddAndGet() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testAddByIndex() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");
        assertEquals("B", list.get(1));
    }

    @Test
    void testSet() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        String old = list.set(1, "X");
        assertEquals("B", old);
        assertEquals("X", list.get(1));
    }

    @Test
    void testRemoveByIndex() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String removed = list.remove(1);
        assertEquals("B", removed);
        assertEquals(2, list.size());
    }

    @Test
    void testContains() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("C"));
    }

    @Test
    void testIsEmpty() {
        myLinkedList<String> list = new myLinkedList<>();
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    void testIndexOfAndLastIndexOf() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("A");
        assertEquals(0, list.indexOf("A"));
        assertEquals(2, list.lastIndexOf("A"));
    }

    @Test
    void testToArray() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        Object[] arr = list.toArray();
        assertArrayEquals(new Object[]{"A", "B"}, arr);
    }

    @Test
    void testContainsAll() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        assertTrue(list.containsAll(Arrays.asList("A", "B")));
        assertFalse(list.containsAll(Arrays.asList("A", "C")));
    }

    @Test
    void testAddAll() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.addAll(Arrays.asList("B", "C"));
        assertEquals(3, list.size());
        assertEquals("C", list.get(2));
    }

    @Test
    void testRemoveAll() {
        myLinkedList<String> list = new myLinkedList<>();
        list.addAll(Arrays.asList("A", "B", "C", "B"));
        list.removeAll(Arrays.asList("B"));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void testRetainAll() {
        myLinkedList<String> list = new myLinkedList<>();
        list.addAll(Arrays.asList("A", "B", "C"));
        list.retainAll(Arrays.asList("B"));
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    void testClear() {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("A");
        list.add("B");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testSubList() {
        myLinkedList<String> list = new myLinkedList<>();
        list.addAll(Arrays.asList("A", "B", "C", "D"));
        List<String> sub = (List<String>) list.subList(1, 2);
        assertEquals(Arrays.asList("B", "C"), sub);
    }
}
