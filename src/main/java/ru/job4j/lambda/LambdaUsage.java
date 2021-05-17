package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task",
                "4. Task"
        };
        Comparator<String> numStr = (left, right) -> {
            int first = Integer.parseInt(left.substring(0, left.indexOf(".")));
            int second = Integer.parseInt(right.substring(0, right.indexOf(".")));
            System.out.println("compare - " + second + " : " + first);
            return Integer.compare(second, first);
        };
        Arrays.sort(numbers, numStr);
        Arrays.stream(numbers).forEach(System.out::println);
    }
}
