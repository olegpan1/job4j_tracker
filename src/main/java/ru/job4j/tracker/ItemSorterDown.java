package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemSorterDown implements Comparator<Item> {
    public static List<Item> sortDownById(List<Item> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public int compare(Item o1, Item o2) {
        return o2.compareTo(o1);
    }
}
