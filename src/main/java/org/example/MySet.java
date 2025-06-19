package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

public class MySet<E> implements Set<E> {

    private final List<E> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (list.contains(e)) {
            return false;
        }
        list.add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return new HashSet<>(list).containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            if (add(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }
}
