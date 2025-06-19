package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class Main {

    private static final String APPLE = "apple";
    private static final String BANANA = "banana";

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

        //a b c d e
        System.out.println("Contains all [C, D]: " + new HashSet<>(list).containsAll(Arrays.asList("C", "D"))); // true
        list.removeAll(Arrays.asList("G", "X"));
        System.out.println("After removeAll [G, X]: " + Arrays.toString(list.toArray()));
        list.retainAll(Arrays.asList("C", "D"));
        System.out.println("After retainAll [C, D]: " + Arrays.toString(list.toArray()));

        //clear
        list.clear();
        System.out.println("After clear, size: " + 0); // 0

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

        list.add("P");
        var sub = list.subList(1, 3);
        System.out.println("SubList (1,3): " + sub);

        String[] arr = list.toArray(new String[6]);
        System.out.println("toArray(T[]): " + Arrays.toString(arr));

        MyLinkedList<String> list1 = new MyLinkedList<>();

        list1.add("A");
        list1.add("B");
        list1.add("A");
        list1.add("D");
        list1.add("E");

        System.out.println("Size: "+list1.size());

        System.out.println("Get index: " + list1.get(0));

        System.out.println("Set index: " + list1.set(3, "E"));

        Iterator<String> it1 = list.listIterator(4);
        while (it1.hasNext()) {
            System.out.println(it1.next() + " ");
        }

        System.out.println("Index of:" + list1.indexOf("A"));

        System.out.println("Last index of:" + list1.lastIndexOf("A"));

        var list2 = list1.subList(1, 3);
        System.out.println("SubList(1,3):" + list2);

        MyMap<String, Integer> map = new MyMap<>();



        map.put(APPLE, 10);
        map.put(BANANA, 20);
        map.put("orange", 30);

        map.printDisplay();

        System.out.println("get:");
        System.out.println(map.get(APPLE));
        System.out.println(map.get(BANANA));
        System.out.println(map.get("notfound"));

        System.out.println("containsKey:");
        System.out.println(map.containsKey(BANANA));
        System.out.println(map.containsKey("grape"));

        System.out.println("containsValue:");
        System.out.println(map.containsValue(20));
        System.out.println(map.containsValue(100));

        System.out.println("size: " + map.size());

        System.out.println("isEmpty: " + map.isEmpty());

        System.out.println("remove:");
        System.out.println(map.remove(APPLE)); // 20
        System.out.println(map.containsKey(BANANA));

        System.out.println("putAll:");
        MyMap<String, Integer> map2 = new MyMap<>();
        map2.put("kiwi", 99);
        map2.put("melon", 88);
        map.putAll(map2);
        System.out.println("after putAll, contains kiwi? " + map.containsKey("kiwi"));

        System.out.println("keySet:");
        System.out.println(map.keySet());

        System.out.println("values:");
        System.out.println(map.values());

        System.out.println("entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\nclear:");
        map.clear();
        System.out.println("size after clear: " + 0);
        System.out.println("isEmpty after clear: " + true);
    }
}