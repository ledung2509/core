package org.example;

public class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(E item) {
        this.item = item;
        this.next = null;
    }

    Node( E element,Node<E> prev, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
