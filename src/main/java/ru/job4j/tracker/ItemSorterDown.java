package ru.job4j.tracker;

import java.util.Collections;
import java.util.List;

public class ItemSorterDown {
    public static List<Item> sortDownByName(List<Item> list) {
        Collections.sort(list, Collections.reverseOrder(new SortByNameItem()));
        return list;
    }

    public static List<Item> sortDownById(List<Item> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}
