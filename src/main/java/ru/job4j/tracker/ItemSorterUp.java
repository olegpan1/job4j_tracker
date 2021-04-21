package ru.job4j.tracker;

import java.util.Collections;
import java.util.List;

public class ItemSorterUp {
    public static List<Item> sortUpByName(List<Item> list) {
        Collections.sort(list, new SortByNameItem());
        return list;
    }

    public static List<Item> sortUpById(List<Item> list) {
        Collections.sort(list);
        return list;
    }
}
