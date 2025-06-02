package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println(list.get(1));
        List<String> list2 = new LinkedList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        System.out.println(list2.get(2));
    }
}