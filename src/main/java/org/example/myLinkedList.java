package org.example;

import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class myLinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    Node<E> head;
    Node<E> tail;
    int size = 0;

    @Override
    public int size() {
        Node<E> p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addFirst(E e) {
        Node<E> p = new Node<>(e, null, head);
        if (isEmpty()) {
            head = tail = p;
        } else {
            head.prev = p;
            p.next = head;
            head = p;
        }
    }

    @Override
    public void addLast(E e) {
        Node<E> p = new Node<>(e, tail, null);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E get(int index) {
        Node<E> p = head;
        int c = 0;
        while (p != null && c < index) {
            p = p.next;
            c++;
        }
        return p.item;
    }

    @Override
    public E removeFirst() {
        E element = getFirst();
        Node<E> p = head.next;

        element = null;
        head = p;
        if (p == null) {
            tail = null;
        } else {
            tail.prev = null;
        }
        return element;
    }

    @Override
    public E removeLast() {
        E element = tail.item;
        Node<E> p = tail.prev;

        //Xóa phần tử
        tail.item = null;
        tail.prev = null;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
            tail = p;
        }
        return element;
    }

    @Override
    public E pollFirst() {
        Node<E> p = head;
        return p == null ? null : removeFirst();
    }

    @Override
    public E pollLast() {
        Node<E> p = tail;
        return p == null ? null : removeLast();
    }

    @Override
    public E getFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        Node<E> p = head;
        return p.item;
    }

    @Override
    public E getLast() {
        return tail.item;
    }

    @Override
    public E peekFirst() {
        Node<E> p = head;
        return (p == null) ? null : p.item;
    }

    @Override
    public E peekLast() {
        Node<E> p = tail;
        return (p == null) ? null : p.item;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        Node<E> p = head;
        return p == null ? null : removeFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        Node<E> p = head;
        return (p == null) ? null : p.item;
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = head;
        while (node != null) {
            if (o == null && node.item == null ? null : o.equals(node.item)) {
                if (node.prev == null) { // node là head
                    head = node.next;
                } else {
                    node.prev.next = node.next;
                }
                if (node.next == null) { // node là tail
                    tail = node.prev;
                } else {
                    node.next.prev = node.prev;
                }
                node.item = null;
                node.next = null;
                node.prev = null;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        Node<E> last = tail;
        Node<E> newNode = new Node<>(e, last, null);
        tail = newNode;
        last.next = newNode;
        return true;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (o != null) {
            remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        Node<E> node = tail;

        while (node != null) {
            if (node.item == null ? null : o.equals(node.item)) {
                if (node.prev == null) { // node là head
                    head = node.next;
                } else {
                    node.prev.next = node.next;
                }
                if (node.next == null) { // node là tail
                    tail = node.prev;
                } else {
                    node.next.prev = node.prev;
                }
                node.item = null;
                node.next = null;
                node.prev = null;
                size--;
                return true;
            }
            node = node.prev;
        }

        return false;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {

            Node<E> current = tail;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.item;
                current = current.prev;
                return element;
            }
        };
    }

    @Override
    public ListIterator<E> listIterator(int index) {

        Node<E> current = head;
        //E element = get(index);
        int c = 0;
        while (current != null && c < index) {
//            if(c == index) {
//                head.item = element;
//            }
            c++;
            current = current.next;
        }

        Node<E> startNode = current;
        return new ListIterator<E>() {

            Node<E> nextNode = startNode;
            Node<E> lastReturned = null;
            int nextIndex = index;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public E next() {
                lastReturned = nextNode;
                E item = nextNode.item;
                nextNode = nextNode.next;
                nextIndex++;
                return item;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public E previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex - 1;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E e) {
                lastReturned.item = e;
            }

            @Override
            public void add(E e) {

            }
        };
    }

    public void printLinkedList() {
        Node<E> p = head;
        while (p != null) {
            if (p.item != null) { // Chỉ in nếu item không phải null
                System.out.print(p.item + " ");
            }
            p = p.next;
        }
        System.out.println();
    }
}
