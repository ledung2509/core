package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

    @Test
    public void testArrayList() {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        assert list.get(0).equals("A");
        assert list.get(1).equals("B");
    }

    @Test
    public void testLinkedList() {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        assert list.get(0).equals("A");
        assert list.get(1).equals("B");
    }
}
