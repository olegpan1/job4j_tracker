package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemSorterUp implements Comparator<Item> {
    public static List<Item> sortUpByName(List<Item> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
