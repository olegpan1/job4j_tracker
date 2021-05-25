package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArraysToListTest {

    @Test
    public void createList() {
        Integer[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArraysToList obj = new ArraysToList();
        List<Integer> actual = obj.createList(data);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, actual);
    }
}