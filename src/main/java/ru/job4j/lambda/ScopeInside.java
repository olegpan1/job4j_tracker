package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    private static int total;

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        for (int num : number) {
            total = add(
                    () -> total + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}