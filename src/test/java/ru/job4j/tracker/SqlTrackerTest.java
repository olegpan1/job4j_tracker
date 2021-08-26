package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item = new Item("test1");
        sqlTracker.add(item);
        Item result = sqlTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        sqlTracker.add(item1);
        sqlTracker.add(item2);
        List<Item> expected = List.of(item1, item2);
        List<Item> result = sqlTracker.findAll();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByName() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        sqlTracker.add(item1);
        sqlTracker.add(item2);
        sqlTracker.add(item3);
        List<Item> expected = List.of(item1, item3);
        List<Item> result = sqlTracker.findByName("first");
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindById() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        sqlTracker.add(item1);
        sqlTracker.add(item2);
        sqlTracker.add(item3);
        Item result = sqlTracker.findById(item2.getId());
        assertThat(result, is(item2));
    }

    @Test
    public void whenFindByIdNotFound() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        sqlTracker.add(item1);
        sqlTracker.add(item2);
        sqlTracker.add(item3);
        Item result = sqlTracker.findById(-1);
        assertThat(result, is(nullValue()));
    }

    @Test
    public void whenReplace() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item1 = new Item("first");
        sqlTracker.add(item1);
        sqlTracker.replace(item1.getId(), new Item("second"));
        assertThat(sqlTracker.findById(item1.getId()).getName(), is("second"));
    }

    @Test
    public void whenDelete() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item1 = new Item("first");
        sqlTracker.add(item1);
        sqlTracker.delete(item1.getId());
        assertThat(sqlTracker.findById(item1.getId()), is(nullValue()));
    }

}