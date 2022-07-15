package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    /**
     * Метод проверяет две строки на идентичность
     * Перед посимвольной проверкой сравнивается длина строк и их эквивалентность
     * @param left  Первая строка
     * @param right Вторая строка
     * @return результат сравнения
     */
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        if (left.equals(right)) {
            return true;
        }

        char[] leftCh = left.toCharArray();
        char[] rightCh = right.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : leftCh) {
            map.merge(ch, 1, (v, nV) -> nV + 1);
        }
        for (char ch : rightCh) {
            map.computeIfPresent(ch, (k, v) -> v = v - 1);
            map.remove(ch, 0);
        }
        return map.keySet().size() == 0;
    }
}