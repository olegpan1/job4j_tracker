package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class MemTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        MatcherAssert.assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAll() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        memTracker.add(item1);
        memTracker.add(item2);
        List<Item> expected = List.of(item1, item2);
        List<Item> result = memTracker.findAll();
        MatcherAssert.assertThat(result, is(expected));
    }

    @Test
    public void whenFindByName() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        List<Item> expected = List.of(item1, item3);
        List<Item> result = memTracker.findByName("first");
        MatcherAssert.assertThat(result, is(expected));
    }

    @Test
    public void whenFindById() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        Item result = memTracker.findById(item2.getId());
        MatcherAssert.assertThat(result, is(item2));
    }

    @Test
    public void whenFindByIdNotFound() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        Item result = memTracker.findById(-1);
        MatcherAssert.assertThat(result, is(nullValue()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("first");
        memTracker.add(item1);
        memTracker.replace(item1.getId(), new Item("second"));
        MatcherAssert.assertThat(memTracker.findById(item1.getId()).getName(), is("second"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("first");
        memTracker.add(item1);
        memTracker.delete(item1.getId());
        MatcherAssert.assertThat(memTracker.findById(item1.getId()), is(nullValue()));
    }
}