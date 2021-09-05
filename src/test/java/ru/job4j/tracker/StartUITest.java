package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new CreateAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ReplaceAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new DeleteAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Find id"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByIdAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator()
//                        + "0. Find item by id" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//                        + "=== Find item by id ====" + System.lineSeparator()
//                        + "Найдена заявка: Item{id=" + item.getId() + ", name='"
//                        + item.getName() + "', created=" + item.getTime() + "}"
//                        + System.lineSeparator() + "Menu." + System.lineSeparator()
//                        + "0. Find item by id" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//        ));
    }

    @Test
    public void whenNotFindById() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Find id"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId() + 1), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByIdAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + "Заявка с id " + (item.getId() + 1) + " не найдена"
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Find name"));
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByNameAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator()
//                        + "0. Find items by name" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//                        + "=== Find items by name ====" + System.lineSeparator()
//                        + "Список заявок с именем: " + item.getName() + System.lineSeparator()
//                        + "Item{id=" + item.getId() + ", name='"
//                        + item.getName() + "', created=" + item.getTime() + "}"
//                        + System.lineSeparator() + "Menu." + System.lineSeparator()
//                        + "0. Find items by name" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//        ));
    }

    @Test
    public void whenNotFindByName() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String noName = "No name";
        Input in = new StubInput(
                new String[]{"0", noName, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByNameAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + "Заявки с именем " + noName + " не найдены" + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. Find items by name"
                        + System.lineSeparator() + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Show1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ShowAllAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator()
//                        + "0. Show all items" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//                        + "=== Show all items ====" + System.lineSeparator()
//                        + "Item{id=" + item.getId() + ", name='"
//                        + item.getName() + "', created=" + item.getTime() + "}"
//                        + System.lineSeparator() + "Menu." + System.lineSeparator()
//                        + "0. Show all items" + System.lineSeparator()
//                        + "1. Exit" + System.lineSeparator()
//        ));
    }

    @Test
    public void whenNoShowAllAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ShowAllAction(out),
                new ExitAction()
        ));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
                        + "Хранилище еще не содержит заявок"
                        + System.lineSeparator() + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"6", "0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI().init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}