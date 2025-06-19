package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        MyMap<String, Integer> map = new MyMap<>();

        // put
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        //Print All
        map.printDisplay();
        // get
        System.out.println("get:");
        System.out.println(map.get("apple"));
        System.out.println(map.get("banana"));
        System.out.println(map.get("notfound"));
        // containsKey
        System.out.println("containsKey:");
        System.out.println(map.containsKey("apple"));
        System.out.println(map.containsKey("grape"));
        // containsValue
        System.out.println("containsValue:");
        System.out.println(map.containsValue(20));
        System.out.println(map.containsValue(100));
        // size
        System.out.println("size: " + map.size());
        //isEmpty
        System.out.println("isEmpty: " + map.isEmpty());
        // remove
        System.out.println("remove:");
        System.out.println(map.remove("banana")); // 20
        System.out.println(map.containsKey("banana"));
        // putAll
        System.out.println("putAll:");
        MyMap<String, Integer> map2 = new MyMap<>();
        map2.put("kiwi", 99);
        map2.put("melon", 88);
        map.putAll(map2);
        System.out.println("after putAll, contains kiwi? " + map.containsKey("kiwi"));
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
        System.out.println("\nclear:");
        map.clear();
        System.out.println("size after clear: " + map.size());
        System.out.println("isEmpty after clear: " + map.isEmpty());
    }
}