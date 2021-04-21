package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemSorterTest {

    @Test
    public void whenSortDownByName() {
        List<Item> items = Arrays.asList(
                new Item("Two", 2),
                new Item("Four", 4),
                new Item("One", 1)
        );
        List<String> expect = Arrays.asList(
                "Two", "One", "Four"
        );
        List<Item> rsl = ItemSorterDown.sortDownByName(items);
        List<String> result = Arrays.asList(
                rsl.get(0).getName(), rsl.get(1).getName(), rsl.get(2).getName()
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortDownById() {
        List<Item> items = Arrays.asList(
                new Item("Two", 2),
                new Item("Four", 4),
                new Item("One", 1)
        );
        List<Integer> expect = Arrays.asList(
                4, 2, 1
        );
        List<Item> rsl = ItemSorterDown.sortDownById(items);
        List<Integer> result = Arrays.asList(
                rsl.get(0).getId(), rsl.get(1).getId(), rsl.get(2).getId()
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortUpByName() {
        List<Item> items = Arrays.asList(
                new Item("Two", 2),
                new Item("Four", 4),
                new Item("One", 1)
        );
        List<String> expect = Arrays.asList(
                "Four", "One", "Two"
        );
        List<Item> rsl = ItemSorterUp.sortUpByName(items);
        List<String> result = Arrays.asList(
                rsl.get(0).getName(), rsl.get(1).getName(), rsl.get(2).getName()
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortUpById() {
        List<Item> items = Arrays.asList(
                new Item("Two", 2),
                new Item("Four", 4),
                new Item("One", 1)
        );
        List<Integer> expect = Arrays.asList(
                1, 2, 4
        );
        List<Item> rsl = ItemSorterUp.sortUpById(items);
        List<Integer> result = Arrays.asList(
                rsl.get(0).getId(), rsl.get(1).getId(), rsl.get(2).getId()
        );
        assertThat(result, is(expect));
    }
}
