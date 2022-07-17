package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class ItemSorterTest {

    @Test
    public void sortUpByName() {
        Item one = new Item("One", 1);
        Item oneAgain = new Item("OneAgain", 1);
        Item two = new Item("Two", 2);
        Item four = new Item("Four", 4);

        List<Item> items = Arrays.asList(one, oneAgain, two, four);
        List<Item> expect = Arrays.asList(four, one, oneAgain, two);

        Collections.sort(items, new ItemSorterUp());

        MatcherAssert.assertThat(items, is(expect));
    }

    @Test
    public void sortDownById() {
        Item one = new Item("One", 1);
        Item oneAgain = new Item("OneAgain", 1);
        Item two = new Item("Two", 2);
        Item four = new Item("Four", 4);

        List<Item> items = Arrays.asList(one, oneAgain, two, four);
        List<Item> expect = Arrays.asList(four, two, one, oneAgain);

        Collections.sort(items, new ItemSorterDown());

        MatcherAssert.assertThat(items, is(expect));
    }
}
