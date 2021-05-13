package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> originSet = new HashSet<>(Arrays.asList(origin.split("\\s|\\p{Punct}")));
        return originSet.containsAll(Arrays.asList(line.split("\\s|\\p{Punct}")));
    }
}