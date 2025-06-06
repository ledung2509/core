package org.example;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    myLinkedList list = new myLinkedList();

    @Test
    public void testAddFirst() {
        list.addFirst("A");
        assertEquals("A", list.getFirst());
    }

    @Test
    public void testAddLast() {
        list.addLast("B");
        assertEquals("B", list.getLast());
    }

    @Test
    public void testOfferFirst() {
        assertTrue(list.offerFirst("C"));
        assertEquals("C", list.getFirst());
    }

    @Test
    public void testOfferLast() {
        assertTrue(list.offerLast("D"));
        assertEquals("D", list.getLast());
    }

    @Test
    public void testGet() {
        list.addLast("E");
        assertEquals("E", list.get(0));
    }

    @Test
    public void testRemoveFirst() {
        list.addLast("F");
        assertEquals("F", list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveLast() {
        list.addLast("G");
        assertEquals("G", list.removeLast());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPollFirst() {
        list.addLast("H");
        assertEquals("H", list.pollFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPollLast() {
        list.addLast("I");
        assertEquals("I", list.pollLast());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGetFirst() {
        list.addFirst("J");
        assertEquals("J", list.getFirst());
    }

    @Test
    public void testGetLast() {
        list.addLast("K");
        assertEquals("K", list.getLast());
    }

    @Test
    public void testPeekFirst() {
        list.addLast("L");
        assertEquals("L", list.peekFirst());
    }

    @Test
    public void testPeekLast() {
        list.addLast("M");
        assertEquals("M", list.peekLast());
    }

    @Test
    public void testRemove() {
        list.addLast("N");
        assertEquals("N", list.remove());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testPoll() {
        list.addLast("O");
        assertEquals("O", list.poll());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testElement() {
        list.addFirst("P");
        assertEquals("P", list.element());
    }

    @Test
    public void testPeek() {
        list.addFirst("Q");
        assertEquals("Q", list.peek());
    }

    @Test
    public void testPush() {
        list.push("R");
        assertEquals("R", list.getFirst());
    }

    @Test
    public void testPop() {
        list.push("S");
        assertEquals("S", list.pop());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveObject() {
        list.addLast("T");
        assertTrue(list.remove("T"));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAdd() {
        assertTrue(list.add("U"));
        assertEquals("U", list.getLast());
    }

    @Test
    public void testOffer() {
        assertTrue(list.offer("V"));
        assertEquals("V", list.getLast());
    }

    @Test
    public void testRemoveFirstOccurrence() {
        list.addLast("W");
        assertTrue(list.removeFirstOccurrence("W"));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemoveLastOccurrence() {
        list.addLast("X");
        list.addLast("Y");
        list.addLast("X");
        assertTrue(list.removeLastOccurrence("X"));
        assertEquals("Y", list.getLast());
    }

    @Test
    public void testDescendingIterator() {
        list.addLast("A");
        list.addLast("B");
        Iterator<String> it = list.descendingIterator();
        assertTrue(it.hasNext());
        assertEquals("B", it.next());
    }

    @Test
    public void testListIterator() {
        list.addLast("A");
        list.addLast("B");
        ListIterator<String> it = list.listIterator(1);
        assertTrue(it.hasNext());
        assertEquals("B", it.next());
    }

    @Test
    public void testSize() {
        list.addFirst("Z");
        assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst("AA");
        assertFalse(list.isEmpty());
    }
}
