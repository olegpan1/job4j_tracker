package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("\\.");
        String[] rightString = right.split("\\.");

        for (int i = 0; i < Math.min(leftString.length, rightString.length); i++) {
            int rsl;
            try {
                rsl = Integer.compare(Integer.parseInt(leftString[i]),
                        Integer.parseInt(rightString[i]));
            } catch (NumberFormatException e) {
                break;
            }
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}