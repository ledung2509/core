package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

     MyArrayList<Integer> list = new MyArrayList<>();

    @Test
    void testConstructorAndSize() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testContains() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    @Test
    void testAddAndGet() {
        assertTrue(list.add(0));
        assertTrue(list.add(9));
        assertTrue(list.add(7));
        assertTrue(list.add(9));
        assertTrue(list.add(7));
        assertEquals(5, list.size());
        assertEquals(0, list.get(0));
    }

    @Test
    void testSet() {
        list.add(1);
        list.add(3);
        assertEquals(3, list.set(1, 6));
        assertEquals(6, list.get(1));
    }

    @Test
     void testToArray() {
        list.add(1);
        list.add(2);
        Object[] arr = list.toArray();
        assertArrayEquals(new Object[]{1, 2}, arr);
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
     void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
     void testContainsAll() {
        list.add(1);
        list.add(2);
        List<Integer> other = Arrays.asList(1, 2);
        assertTrue(list.containsAll(other));
        other = Arrays.asList(1, 2, 3);
        assertFalse(list.containsAll(other));
    }

    @Test
     void testAddAll() {
        List<Integer> other = Arrays.asList(1,2,3);
        assertTrue(list.addAll(other));
        assertEquals(3, list.size());
        assertEquals(2, list.get(1));
    }

    @Test
    void testAddAllAtIndex() {
        list.add(1);
        list.add(4);
        List<Integer> other = Arrays.asList(2, 3);
        assertTrue(list.addAll(1, other));
        assertEquals(Arrays.asList(1, 2, 3, 4), Arrays.asList(list.get(0), list.get(1), list.get(2), list.get(3)));
    }

    @Test
     void testRemoveAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.removeAll(Arrays.asList(2, 3)));
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
        assertFalse(list.removeAll(Arrays.asList(4, 5)));
    }

    @Test
     void testRetainAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.retainAll(Arrays.asList(2, 3)));
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testListIterator() {
        list.add(1);
        list.add(2);
        ListIterator<Integer> it = list.listIterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
        assertTrue(it.hasPrevious());
        assertEquals(2, it.previous());
        assertTrue(it.hasPrevious());
        assertEquals(1, it.previous());
        assertFalse(it.hasPrevious());
    }

    @Test
    void testListIteratorAddSetRemove() {
        ListIterator<Integer> it = list.listIterator();
        it.add(1);
        it.add(2);
        it.add(3);
        assertEquals(3, list.size());
        it = list.listIterator();
        it.next();
        it.set(10);
        assertEquals(10, list.get(0));
        it.remove();
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    void testSubList() {
        for (int i = 0; i < 5; i++) list.add(i);
        List<Integer> sub = list.subList(1, 4);
        assertEquals(Arrays.asList(1, 2, 3), sub);
    }

    @Test
    void testSubListOutOfBounds() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(0, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(1, 0));
    }
}
