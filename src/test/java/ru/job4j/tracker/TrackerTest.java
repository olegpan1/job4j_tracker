package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplace2() {
        Tracker tracker = new Tracker();
        Item place1 = new Item("Place1");
        Item place2 = new Item("Place2");
        Item place3 = new Item("Place3");
        tracker.add(place1);
        tracker.add(place2);
        tracker.add(place3);
        int id = place2.getId();
        Item placeReplace = new Item("PlaceReplace");
        tracker.replace(id, placeReplace);
        assertThat(tracker.findById(id).getName(), is("PlaceReplace"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item place1 = new Item("Place1");
        Item place2 = new Item("Place2");
        Item place3 = new Item("Place3");
        tracker.add(place1);
        tracker.add(place2);
        tracker.add(place3);
        int id = place2.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}