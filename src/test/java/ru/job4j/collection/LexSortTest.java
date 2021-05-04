package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNumManyDots() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task.",
                "2.1. Task.",
                "1.2.4. Task.",
                "1.2.2.20",
        };
        String[] out = {
                "1. Task.",
                "1.2.2.20",
                "1.2.4. Task.",
                "2. Task.",
                "2.1. Task.",
                "10. Task.",
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}