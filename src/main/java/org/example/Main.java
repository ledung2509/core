package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println(list.get(2)); //C
        System.out.println(list.remove("A")); //B C D E
        System.out.println(list.set(1, "G"));
        System.out.println(list.get(1));
        list.add("F");
        list.add(2, "G");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}