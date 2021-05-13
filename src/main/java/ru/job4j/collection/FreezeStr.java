package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        // если можем получить строки разной длины, то посимвольная проверка не нужна, сразу false
        if (left.length() != right.length()) {
            return false;
        }
        // если строки одинаковы, то тоже посимвольная проверка не нужна
        if (left.equals(right)) {
            return true;
        }

        char[] leftCh = left.toCharArray();
        char[] rightCh = right.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < leftCh.length; i++) {
            map.merge(leftCh[i], 1, (V, nV) -> V + 1);
            map.merge(rightCh[i], -1, (V, nV) -> V - 1);
        }
        for (Integer val : map.values()) {
            if (!val.equals(0)) {
                return false;
            }
        }
        return true;
    }
}