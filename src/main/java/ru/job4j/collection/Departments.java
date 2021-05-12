package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        List<String> sorted = fillGaps(orgs);
        sorted.sort(Comparator.naturalOrder());
        System.out.print(sorted);
    }

    public static void sortDesc(List<String> orgs) {
        List<String> sorted = fillGaps(orgs);
        sorted.sort(new DepDescComp());
        System.out.print(sorted);
    }
}