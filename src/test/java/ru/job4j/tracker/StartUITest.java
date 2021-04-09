package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC", "Call Mom", "Do something"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        for (int i = 0; i < answers.length; i++) {
            StartUI.createItem(input, tracker);
            Item created = tracker.findAll()[i];
            Item expected = new Item(answers[i]);
            assertThat(created.getName(), is(expected.getName()));
        }
    }
}
