package ru.job4j.collection;

import java.util.Comparator;

public class LexSortFullCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl;
        int leftNum;
        int rightNum;
        int whoseException = 0;
        String[] leftString = left.split("\\.");
        String[] rightString = right.split("\\.");

        for (int i = 0; i < Math.min(leftString.length, rightString.length); i++) {
            try {
                leftNum = Integer.parseInt(leftString[i]);
                ++whoseException;
                rightNum = Integer.parseInt(rightString[i]);
                --whoseException;
                rsl = Integer.compare(leftNum, rightNum);
            } catch (NumberFormatException e) {
                return (whoseException == 0) ? -1 : 1;
            }
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
