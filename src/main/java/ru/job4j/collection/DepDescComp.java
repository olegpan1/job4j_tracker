package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/", 2);
        String[] second = o2.split("/", 2);
        return second[0].compareTo(first[0]) == 0 ?  o1.compareTo(o2)
                : (second[0].compareTo(first[0]) > 0 ? 1 : -1);
    }
}