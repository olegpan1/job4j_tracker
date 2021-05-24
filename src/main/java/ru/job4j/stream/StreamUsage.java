package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(3, -5, 9, 0, -6, 1));
        List<Integer> positive = data.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toList());
        positive.forEach(p -> System.out.print(p + " "));
    }
}
