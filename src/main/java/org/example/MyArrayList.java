package org.example;

import java.util.Arrays;

public class MyArrayList <E>{

    private Object[] elements;
    private int size = 0;


    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return (E) elements[index];
    }
}
