package org.example;

import java.util.ArrayList;


public class List {
    public static ArrayList<Object> list = new ArrayList<Object>();

    public ArrayList<Object> defaultList(ArrayList<Object> list) {
        for(int i = 0; i <= 10; i++) {
            Object object = new Object();
            object.setName("tuan" + i);
            list.add(object);
        }
        return list;
    }

    public void displayList(ArrayList<Object> list) {
        list.forEach(System.out::println);
    }
}
