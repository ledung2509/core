package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        //khởi tạo và thêm phần tử
        MyArrayList<String> list = new MyArrayList<>();
        System.out.println("Empty: " + list.isEmpty()); // true

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //lấy size và get phần tử
        System.out.println("Size: " + list.size()); // 5
        System.out.println("Element at 2: " + list.get(2)); // C

        //contains, indexOf, lastIndexOf
        System.out.println("Contains 'B': " + list.contains("B")); // true
        System.out.println("Contains 'Z': " + list.contains("Z")); // false
        System.out.println("Index of 'B': " + list.indexOf("B")); // 1

        //set
        System.out.println("Set index 1 = 'G', old value: " + list.set(1, "G")); // B
        System.out.println("Get index 1: " + list.get(1)); // G

        //remove by value
        System.out.println("Remove 'A': " + list.remove("A")); // true
        System.out.println("List after remove 'A': " + Arrays.toString(list.toArray())); // [G, C, D, E]

        //addAll, addAll at index
        list.addAll(Arrays.asList("F", "G", "H"));
        System.out.println("After addAll: " + Arrays.toString(list.toArray())); // [G, C, D, E, F, G, H]
        list.addAll(2, Arrays.asList("X", "Y"));
        System.out.println("After addAll at index 2: " + Arrays.toString(list.toArray())); // [G, C, X, Y, D, E, F, G, H]

        //remove by index
        System.out.println("Remove at index 3: " + list.remove(3)); // Y
        System.out.println("After remove index 3: " + Arrays.toString(list.toArray()));

        //scontainsAll, removeAll, retainAll
        System.out.println("Contains all [C, D]: " + list.containsAll(Arrays.asList("C", "D"))); // true
        list.removeAll(Arrays.asList("G", "X"));
        System.out.println("After removeAll [G, X]: " + Arrays.toString(list.toArray()));
        list.retainAll(Arrays.asList("C", "D"));
        System.out.println("After retainAll [C, D]: " + Arrays.toString(list.toArray()));

        //clear
        list.clear();
        System.out.println("After clear, size: " + list.size()); // 0

        //listIterator
        list.addAll(Arrays.asList("M", "N", "O"));
        ListIterator<String> it = list.listIterator();
        System.out.print("ListIterator forward: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.print("ListIterator backward: ");
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
        System.out.println();

        //ssubList
        list.add("P");
        List<String> sub = list.subList(1, 3);
        System.out.println("SubList (1,3): " + sub);

        //toArray(T[] a)
        String[] arr = list.toArray(new String[0]);
        System.out.println("toArray(T[]): " + Arrays.toString(arr));
    }
}