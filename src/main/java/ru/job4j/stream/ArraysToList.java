package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysToList {
    public List<Integer> createList(Integer[][] data) {
        return Stream.of(data)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
