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
        for (char ch : leftCh) {
            // Зачем использовать putIfAbsent и computeIfPresent если в этом случае merge
            // может их заменить?
//            map.putIfAbsent(ch, 0);
//            map.computeIfPresent(ch, (k, v) -> v = v + 1);
            map.merge(ch, 1, (v, nV) -> nV + 1);
        }
        for (char ch : rightCh) {
            map.computeIfPresent(ch, (k, v) -> v = v - 1);
            map.remove(ch, 0);
        }
        return map.keySet().size() == 0;
    }
}