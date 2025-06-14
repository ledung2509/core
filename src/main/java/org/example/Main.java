package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //khởi tạo và thêm phần tử
//        MyArrayList<String> list = new MyArrayList<>();
//        System.out.println("Empty: " + list.isEmpty()); // true
//
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//
//        //lấy size và get phần tử
//        System.out.println("Size: " + list.size()); // 5
//        System.out.println("Element at 2: " + list.get(2)); // C
//
//        //contains, indexOf, lastIndexOf
//        System.out.println("Contains 'B': " + list.contains("B")); // true
//        System.out.println("Contains 'Z': " + list.contains("Z")); // false
//        System.out.println("Index of 'B': " + list.indexOf("B")); // 1
//
//        //set
//        System.out.println("Set index 1 = 'G', old value: " + list.set(1, "G")); // B
//        System.out.println("Get index 1: " + list.get(1)); // G
//
//        //remove by value
//        System.out.println("Remove 'A': " + list.remove("A")); // true
//        System.out.println("List after remove 'A': " + Arrays.toString(list.toArray())); // [G, C, D, E]
//
//        //addAll, addAll at index
//        list.addAll(Arrays.asList("F", "G", "H"));
//        System.out.println("After addAll: " + Arrays.toString(list.toArray())); // [G, C, D, E, F, G, H]
//        list.addAll(2, Arrays.asList("X", "Y"));
//        System.out.println("After addAll at index 2: " + Arrays.toString(list.toArray())); // [G, C, X, Y, D, E, F, G, H]
//
//        //remove by index
//        System.out.println("Remove at index 3: " + list.remove(3)); // Y
//        System.out.println("After remove index 3: " + Arrays.toString(list.toArray()));
//
//        //scontainsAll, removeAll, retainAll
//        //a b c d e
//        System.out.println("Contains all [C, D]: " + list.containsAll(Arrays.asList("C", "D"))); // true
//        list.removeAll(Arrays.asList("G", "X"));
//        System.out.println("After removeAll [G, X]: " + Arrays.toString(list.toArray()));
//        list.retainAll(Arrays.asList("C", "D"));
//        System.out.println("After retainAll [C, D]: " + Arrays.toString(list.toArray()));
//
//        //clear
//        list.clear();
//        System.out.println("After clear, size: " + list.size()); // 0
//
//        //listIterator
//        list.addAll(Arrays.asList("M", "N", "O"));
//        ListIterator<String> it = list.listIterator();
//        System.out.print("ListIterator forward: ");
//        while (it.hasNext()) {
//            System.out.print(it.next() + " ");
//        }
//        System.out.println();
//        System.out.print("ListIterator backward: ");
//        while (it.hasPrevious()) {
//            System.out.print(it.previous() + " ");
//        }
//        System.out.println();
//
//        //ssubList
//        list.add("P");
//        List<String> sub = list.subList(1, 3);
//        System.out.println("SubList (1,3): " + sub);
//
//        //toArray(T[] a)
//        String[] arr = list.toArray(new String[6]);
//        System.out.println("toArray(T[]): " + Arrays.toString(arr));

//        myLinkedList list = new myLinkedList();
//
//        list.add("A");
//        list.add("B");
//        list.add("A");
//        list.add("D");
//        list.add("E");
//
//        list.printLinkedList();
//
//        //Size
//        System.out.println("Size: "+list.size());
//
//        //Get index
//        System.out.println("Get index: " + list.get(0));
//
//        //Set index
//        System.out.println("Set index: " + list.set(3, "E"));
//        list.printLinkedList();
//
//        //List Iterator
//        Iterator<String> it1 = list.listIterator(4);
//        while (it1.hasNext()) {
//            System.out.println(it1.next() + " ");
//        }
//
//        //Index Of
//        System.out.println("Index of:" + list.indexOf("A"));
//
//        //Last index Of
//        System.out.println("Last index of:" + list.lastIndexOf("A"));
//
//        //Sub list
//        List<String> list1 = list.subList(1, 3);
//        System.out.println("SubList(1,3):" + list1);

        myMap<String, Integer> map = new myMap<>();

        // put
        System.out.println("put:");
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        //Print All
        System.out.println("Print all:");
        map.printAll();
        // get
        System.out.println("get:");
        System.out.println("apple = " + map.get("apple"));
        System.out.println("banana = " + map.get("banana"));
        // containsKey
        System.out.println("containsKey:");
        System.out.println("apple = " + map.containsKey("apple"));
        System.out.println("grape = " + map.containsKey("grape"));
        // containsValue
        System.out.println("containsValue:");
        System.out.println("20 = " + map.containsValue(20));
        System.out.println("100 = " + map.containsValue(100));
        // size
        System.out.println("size: " + map.size());
        //isEmpty
        System.out.println("isEmpty: " + map.isEmpty());
        // remove
        System.out.println("remove:");
        System.out.println("remove banana: " + map.remove("banana")); // 20
        System.out.println("after remove, contains banana = " + map.containsKey("banana"));
        // putAll
        System.out.println("putAll:");
        myMap<String, Integer> map2 = new myMap<>();
        map2.put("kiwi", 99);
        map2.put("melon", 88);
        map.putAll(map2);
        System.out.println("after putAll, contains kiwi = " + map.containsKey("kiwi"));
        // keySet
        System.out.println("keySet:");
        System.out.println(map.keySet());
        // values
        System.out.println("values:");
        System.out.println(map.values());
        // entrySet
        System.out.println("entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        // clear
        System.out.println("clear:");
        map.clear();
        System.out.println("size after clear: " + map.size());
        System.out.println("isEmpty after clear: " + map.isEmpty());
    }
}