package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("É");
        System.out.println(list.get(2));
    }
}