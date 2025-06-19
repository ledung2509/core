package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<E> implements java.util.List<E> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {

            if (Objects.equals(elements[i], o)) {
                int numRemove = size - i - 1;
                if (numRemove > 0) {
                    System.arraycopy(elements, i + 1, elements, i, numRemove);
                }
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] toAdd = c.toArray();
        int numNew = toAdd.length;
        if (numNew == 0) return false;

        ensureCapacity(size + numNew); // đảm bảo đủ chỗ

        System.arraycopy(toAdd, 0, elements, size, numNew);
        size += numNew;
        return true;
    }

    public void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index); // kiểm tra hợp lệ
        Object[] toAdd = c.toArray();
        int numNew = toAdd.length;
        if (numNew == 0) return false;

        ensureCapacity(size + numNew);

        // Dời phần tử từ index sang phải
        System.arraycopy(elements, index, elements, index + numNew, size - index);

        // Chèn phần tử mới
        System.arraycopy(toAdd, 0, elements, index, numNew);
        size += numNew;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            if (c.contains(elements[i])) {
                remove(i);// lùi lại 1 vì sau khi xóa, các phần tử dồn lại
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }

        //  Dời các phần tử từ vị trí index sang phải
        System.arraycopy(elements, index, elements, index + 1, size - index);

        elements[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedElements = (E) elements[index];
        int indexToRemove = size - index - 1;
        if (indexToRemove > 0) {
            System.arraycopy(elements, index + 1, elements, index, indexToRemove);
        }

        elements[--size] = null;

        return removedElements;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (elements[i] == null) {
                    return i;
                }
            } else {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int lastIndexOfRange(Object o, int end) {
        Object[] es = elements;
        if (o == null) {
            for (int i = end - 1; i >= 0; i--) {
                if (es[i] == null) return i;
            }
        } else {
            for (int i = end - 1; i >= 0; i--) {
                if (o.equals(es[i])) return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOfRange(o, size);
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        rangeCheckForAdd(index); // Cho phép index == size

        return new ListIterator<>() {
            int cursor = index;
            int lastRet = -1;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                lastRet = cursor;
                return (E) elements[cursor++];
            }

            @Override
            public boolean hasPrevious() {
                return cursor > 0;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                lastRet = --cursor;
                return (E) elements[cursor];
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                if (lastRet < 0) throw new IllegalStateException();
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            }

            @Override
            public void set(E e) {
                if (lastRet < 0) throw new IllegalStateException();
                MyArrayList.this.set(lastRet, e);
            }

            @Override
            public void add(E e) {
                MyArrayList.this.add(cursor++, e);
                lastRet = -1;
            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex);
        }

        List<E> result = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(get(i));
        }
        return result;
    }
}
